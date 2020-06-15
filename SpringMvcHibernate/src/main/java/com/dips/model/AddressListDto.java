package com.dips.model;

import java.util.List;

public class AddressListDto {

	private List<AddressModel> addressmodel;

	public List<AddressModel> getAddressmodel() {
		return addressmodel;
	}

	public void setAddressmodel(List<AddressModel> addressmodel) {
		this.addressmodel = addressmodel;
	}

	@Override
	public String toString() {
		return "AddressListDto [addressmodel=" + addressmodel + "]";
	}
	
	
}
