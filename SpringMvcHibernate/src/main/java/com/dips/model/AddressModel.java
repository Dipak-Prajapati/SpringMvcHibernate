package com.dips.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class AddressModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@NotEmpty(message = "* Please Enter The Address *")
	@Column(nullable = false)
	private String address;

	@NotEmpty(message = "* Please Enter The City *")
	@Column(nullable = false)
	private String city;
	
	@NotEmpty(message = "* Please Enter The State *")
	@Column(nullable = false)
	private String state;
	
	@NotEmpty(message = "* Please Enter The Country *")
	@Column(nullable = false)
	private String country;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
	
	
	
}
