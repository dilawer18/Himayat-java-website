package com.donate.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int unitId;
	@Column(nullable = true)
	private String providerEmail;
	private String name;
	private int serves;
	private int items;
	public String getProviderEmail() {
		return providerEmail;
	}
	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}
	private int availabilityInHours;
	@Column(unique = true)
	private long contactNumber;
	@Column(nullable = true)
	private long alternativeContactNumber;
	private String address;
	private String landmark;
	private Date date;
	boolean isTaken = false;
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	public int getUnitId() {
		return unitId;
	}
	public FoodUnit() {
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	
	@Override
	public String toString() {
		return "FoodUnit [unitId=" + unitId + ", name=" + name + ", serves=" + serves + ", items=" + items
				+ ", availabilityInHours=" + availabilityInHours + ", contactNumber=" + contactNumber
				+ ", alternativeContactNumber=" + alternativeContactNumber + ", address=" + address + ", landmark="
				+ landmark + ", date=" + date + ", isTaken=" + isTaken + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getServes() {
		return serves;
	}
	public void setServes(int serves) {
		this.serves = serves;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public int getAvailabilityInHours() {
		return availabilityInHours;
	}
	public void setAvailabilityInHours(int availabilityInHours) {
		this.availabilityInHours = availabilityInHours;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public long getAlternativeContactNumber() {
		return alternativeContactNumber;
	}
	public void setAlternativeContactNumber(long alternativeContactNumber) {
		this.alternativeContactNumber = alternativeContactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
