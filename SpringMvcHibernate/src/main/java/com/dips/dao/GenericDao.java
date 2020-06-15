package com.dips.dao;

import com.dips.model.UserModel;

public interface GenericDao<E> {

	void addUser(UserModel userModel);

	void deleteUser(Integer userId);
	
}
