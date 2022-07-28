package com.donate.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FoodOrders {
	@Id
	private String receiverEmail;
	private long donorPhone;
	private int receiverOtp;
	public int getReceiverOtp() {
		return receiverOtp;
	}
	public void setReceiverOtp(int receiverOtp) {
		this.receiverOtp = receiverOtp;
	}
	public FoodOrders() {
		
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public long getDonorPhone() {
		return donorPhone;
	}
	public void setDonorPhone(long donorPhone) {
		this.donorPhone = donorPhone;
	}

}
