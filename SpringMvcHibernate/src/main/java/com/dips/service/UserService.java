package com.dips.service;

import java.util.List;

import com.dips.model.UserModel;

public interface UserService extends GenericService<UserModel>{

	public UserModel showData(String email , String pwd);

	public UserModel getData(int id);

	public void updateUserData(UserModel userModel);

	public String getPassword(String email);

	public List<UserModel> getAllUserData();

	public boolean emailExist(int userId, String email);

}
