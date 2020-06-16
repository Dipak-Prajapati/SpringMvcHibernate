package com.dips.dao;

import java.util.List;

import com.dips.model.AddressModel;
import com.dips.model.UserModel;

public interface UserDao extends GenericDao<UserModel>{

	public UserModel showData(String email, String pwd);

	public UserModel getData(int id);

	public void updateUserData(UserModel userModel);

	public List<AddressModel> getAddressId(int userId);

	public void deleteAddress(List<AddressModel> addressId);

	public String getPassword(String email);

	public List<UserModel> getAllUserData();

	public boolean registerCheck(String email);

	public boolean emailExist(int userId, String email);

	
}
