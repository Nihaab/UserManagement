package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	private String uid;
	
	private String uname;
	
	private String uaddress;
	
	private String country;
	
	private String userEmail;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uid, String uname, String uaddress, String country, String userEmail) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.country = country;
		this.userEmail = userEmail;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + ", country=" + country
				+ ", userEmail=" + userEmail + "]";
	}
	
}
