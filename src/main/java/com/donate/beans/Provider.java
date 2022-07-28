package com.donate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int providerId;
	
	private String providerName;
	private long phone;
	@Column(unique = true)
	private String email;
	private String city;
	private String cityArea;
	private String address;
	private String typeOfUser;
	private String password;
	
	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName=" + providerName + ", phone=" + phone + ", email="
				+ email + ", city=" + city + ", cityArea=" + cityArea + ", address=" + address + ", typeOfUser="
				+ typeOfUser + ", password=" + password + "]";
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Provider() {
		
	}


	public int getProviderId() {
		return providerId;
	}


	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}


	public String getProviderName() {
		return providerName;
	}


	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCityArea() {
		return cityArea;
	}


	public void setCityArea(String cityArea) {
		this.cityArea = cityArea;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTypeOfUser() {
		return typeOfUser;
	}


	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
}
