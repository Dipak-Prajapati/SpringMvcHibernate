package com.dips.service;

import com.dips.model.UserModel;

public interface GenericService<E> {

	public void addUser(UserModel userModel);
	
	public void deleteUser(Integer userId);
	
}
