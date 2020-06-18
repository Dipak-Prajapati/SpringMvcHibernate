package com.dips.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@NotEmpty()
	@Pattern(regexp = "^[a-zA-Z]+$",message = "* For Your First Name Can't be null and Please Use Alphabets Only *")
	@Column(nullable = false)
	private String fname;

	@NotEmpty()
	@Pattern(regexp = "^[a-zA-Z]+$",message = "* For Your Last Name Can't be null and Please Use Alphabets Only *")
	@Column(nullable = false)
	private String lname;
	
	@NotEmpty
	@Email(message = "* Please Enter a Valid Email Address *")
	@Column(nullable = false)
	private String email;
	
	@NotEmpty(message = "* Enter The Date Of Birth *")
	@Column(nullable = false)
	private String dob;
	
	@NotEmpty(message = "* Please Enter The Mobile Number *")
	@Pattern(regexp = "^[0-9]{10,10}$",message = "* Please Enter The Valid Mobile Number *")
	@Column(nullable = false)
	private String m_no;
	
	@NotEmpty(message = "* You Must Select Your Gender *")
	@Column(nullable = false)
	private String gender;
	
	@NotEmpty(message = "* Please Select Atleast One Language *")
	@Column(nullable = false)
	private String language;
	
	@NotEmpty(message = "* Please select an option! *")
	@Column(nullable = false)
	private String hobbie;
	
	@NotEmpty()
	@Pattern(regexp = "^[a-zA-Z0-9]{8,16}$",message = "* Password Can't be null and Enter minimum 8 character and maximum 16 character *")
	@Column(nullable = false)
	private String pwd;
	
	@Lob
	//@Column(nullable = true)
	private byte[] pic;
	
	@Transient
	private String base64image;
 	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id" , referencedColumnName = "user_id")
	private List<AddressModel> addressModel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHobbie() {
		return hobbie;
	}
	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	public String getBase64image() {
		return base64image;
	}
	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}
	
	public List<AddressModel> getAddressModel() {
		return addressModel;
	}
	public void setAddressModel(List<AddressModel> addressModel) {
		this.addressModel = addressModel;
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", dob=" + dob
				+ ", m_no=" + m_no + ", gender=" + gender + ", language=" + language + ", hobbie=" + hobbie + ", pwd="
				+ pwd + "]";
	}
	
	
	
	
	
}
