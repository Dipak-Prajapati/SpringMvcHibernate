package com.dips.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dips.model.AddressModel;
import com.dips.model.UserModel;

@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<UserModel> implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public UserModel showData(String email, String pwd) {
		// TODO Auto-generated method stub

		UserModel userModel = null;
		List data = null;
		String hql = "FROM UserModel  WHERE email = :email and pwd = :pwd";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("pwd", pwd);
		// System.out.println("Query : " + query);
		data = query.list();
		System.out.println("Data size : " + data.size());

		if (data.size() > 0) {
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				userModel = (UserModel) iterator.next();
			}
			userModel.setBase64image(Base64.getEncoder().encodeToString(userModel.getPic()));
			// return userModel;
			return userModel;
		} else {
			return null;
		}
		// System.out.println("data size :" + data.size() + "UserModel" + userModel);
		// return data.size() > 0 ? userModel : null;
		// return userModel != null ? userModel : null;
	}

	public UserModel getData(int id) {
		// TODO Auto-generated method stub
		UserModel userModel = null;
		List data = null;
		String hql = "FROM UserModel  WHERE user_id = :id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		data = query.list();

		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			userModel = (UserModel) iterator.next();
		}
		userModel.setBase64image(Base64.getEncoder().encodeToString(userModel.getPic()));
		// return userModel;
		return userModel;
	}

	public void updateUserData(UserModel userModel) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(userModel);
	}

	public List<AddressModel> getAddressId(int userId) {
		// TODO Auto-generated method stub
		NativeQuery<AddressModel> query = getSession().createNativeQuery("select address_id from address where user_id ="+userId);
		List<AddressModel> addressId = query.list();
		return addressId;
	}

	public void deleteAddress(List<AddressModel> addressId) {
		// TODO Auto-generated method stub
		for(int i=0;i<addressId.size();i++)
		{
			Query query = getSession().createQuery("delete AddressModel where id ="+addressId.get(i));
			query.executeUpdate();
		}
	}

	public String getPassword(String email) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("select pwd from UserModel where email = :email");
		query.setParameter("email", email);
		String password = (String) query.uniqueResult();
		return password;
	}

	public List<UserModel> getAllUserData() {
		// TODO Auto-generated method stub
		List<UserModel> result = new ArrayList<UserModel>();
		List data = null;
		String hql = "FROM UserModel";
		Query query = getSession().createQuery(hql);
		data = query.list();

		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			UserModel userModel = new UserModel();
			userModel = (UserModel) iterator.next();
			userModel.setBase64image(Base64.getEncoder().encodeToString(userModel.getPic()));
			result.add(userModel);
		}
		// return userModel;
		return result;

	}

	public boolean registerCheck(String email) {
		// TODO Auto-generated method stub
		String hql = "select email FROM UserModel  WHERE email = :email";
		Query query =  getSession().createQuery(hql);
		query.setParameter("email",email);
		 String result =  (String) query.uniqueResult(); 
		 if(result == null) {
			 return false;
		 }
		 else {
			 return true;
		 }
	}

	public boolean emailExist(int userId, String email) {
		// TODO Auto-generated method stub
		String hql = "select id FROM UserModel  WHERE email = :email";
		Query query =  getSession().createQuery(hql);
		query.setParameter("email",email);
		 Integer result =   (Integer) query.uniqueResult(); 
		 
		 if(result == userId) {
			 return false;
		 }
		 else {
			 return true;
		 }
	}
}
