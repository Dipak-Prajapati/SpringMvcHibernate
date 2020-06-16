package com.dips.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dips.dao.UserDao;
import com.dips.model.AddressModel;
import com.dips.model.UserModel;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserModel> implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserModel showData(String email,String pwd) {
		// TODO Auto-generated method stub
		return userDao.showData(email,pwd);
	}

	public UserModel getData(int id) {
		// TODO Auto-generated method stub
		return userDao.getData(id);
	}

	public void updateUserData(UserModel userModel) {
		// TODO Auto-generated method stub
		
		List<AddressModel> addressId = userDao.getAddressId(userModel.getId());		
		
		List<Integer> id = new ArrayList<Integer>();
		
		for(int i=0;i<addressId.size();i++)
		{
			System.out.println("Before remove :"+addressId.get(i));
		}
		
		for(int i=0;i<userModel.getAddressModel().size();i++)
		{
			//System.out.println("addressId.get(i)"+addressId.get(i));
			System.out.println("userModel.getAddressModel().get(i).getId()"+userModel.getAddressModel().get(i).getId());
			id.add(userModel.getAddressModel().get(i).getId());
			System.out.println("id list"+id.get(i));
		}
		addressId.removeAll(id);
		for(int i=0;i<addressId.size();i++)
		{
			System.out.println("after remove :"+addressId.get(i));
		}
		if(addressId.size() > 0)
		{
			userDao.deleteAddress(addressId);
		}
		userDao.updateUserData(userModel);
	}

	public String getPassword(String email) {
		// TODO Auto-generated method stub
		return userDao.getPassword(email);
	}

	public List<UserModel> getAllUserData() {
		// TODO Auto-generated method stub
		return userDao.getAllUserData();
	}

	public boolean emailExist(int userId, String email) {
		// TODO Auto-generated method stub
		boolean ans;
		if(userId == 0) {
		 ans = userDao.registerCheck(email);
		}
		else {
			 ans = userDao.emailExist(userId,email);
		}
		if(ans == true) {
			return true;
		}else {
			return false;
		}
	}

}
