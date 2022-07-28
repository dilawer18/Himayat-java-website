package com.donate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donate.Dao.ProjectDao;
import com.donate.beans.FoodUnit;
import com.donate.beans.Provider;
import com.donate.beans.Receiver;
@Service
public class ServiceProviderImpl implements ServiceProvider {
	
	@Autowired
	private ProjectDao dao;
	
	@Override
	public boolean addFoodProvider(Provider provider) {
		return dao.addFoodProvider(provider);
		
	}

	@Override
	public boolean logMeIn(String email, String password,String type) {
		return dao.logMeIn(email, password,type);
	}

	@Override
	public boolean mailExistance(String email) {
		return dao.mailExistance(email);
	}

	@Override
	public boolean updatePassword(String email,String password) {
		return dao.updatePassword(email,password);
	}

	@Override
	public boolean addUnitFood(FoodUnit foodUnit) {
		if(foodUnit.getAvailabilityInHours()<=0) {
			return false;
		}else {
			return dao.addUnitFood(foodUnit);
		}
	}

	@Override
	public boolean addReceiver(Receiver receiver) {
		dao.addReceiver(receiver);
		return false;
	}

	@Override
	public List<FoodUnit> getAllFoods() {
		return dao.getAllFoods();
	}

	@Override
	public boolean selectFood(long phone, String email) {
		return dao.selectFood(phone, email);
	}

	@Override
	public boolean verifyReceiverOTPAndDeleteRecord(String email, int otp) {
		return dao.verifyReceiverOTPAndDeleteRecord(email, otp);
	}

	@Override
	public boolean sendConfirmationAndOTP(String email, long phone, int otp) {
		return dao.sendConfirmationAndOTP(email, phone, otp);
	}

}
