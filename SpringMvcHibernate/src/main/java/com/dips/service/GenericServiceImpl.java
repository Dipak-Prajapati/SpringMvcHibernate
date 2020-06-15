package com.dips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dips.dao.GenericDao;
import com.dips.model.UserModel;

@Service
public abstract class GenericServiceImpl<E> implements GenericService<E>{

	@Autowired
	private GenericDao<UserModel> dao;
	
	public void addUser(UserModel userModel)
	{
		dao.addUser(userModel);
	}
	
	public void deleteUser(Integer userId)
	{
		dao.deleteUser(userId);
	}
}
