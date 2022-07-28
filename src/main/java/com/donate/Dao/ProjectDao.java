package com.donate.Dao;

import java.util.List;

import com.donate.beans.FoodUnit;
import com.donate.beans.Provider;
import com.donate.beans.Receiver;

public interface ProjectDao {

	public boolean addFoodProvider(Provider provider);
	public boolean addReceiver(Receiver receiver);
	public boolean logMeIn(String email, String password,String type);
	public boolean mailExistance(String email);
	public boolean updatePassword(String email,String password);
	public boolean addUnitFood(FoodUnit foodUnit);
	public List<FoodUnit> getAllFoods();
	public boolean selectFood(long phone,String email);
	public boolean verifyReceiverOTPAndDeleteRecord(String email, int otp);
	public boolean sendConfirmationAndOTP(String email,long phone,int otp);
//	public boolean deleteFoodOrders(String email);
}
