package com.dips.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dips.model.UserModel;

@Repository
@Transactional
public abstract class GenericDaoImpl<E> implements GenericDao<E> {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(UserModel userModel) {
		getSession().save(userModel);
		System.out.println("Data is in GenericDaoImpl : " + userModel);
		System.out.println("Data Added Successfully");
	}

	public void deleteUser(Integer userId) {
		Session session = getSession();
		UserModel userModel = (UserModel) session.get(UserModel.class, userId);
		session.delete(userModel);
	}
}
