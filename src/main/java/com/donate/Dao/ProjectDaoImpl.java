package com.donate.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.donate.beans.FoodOrders;
import com.donate.beans.FoodUnit;
import com.donate.beans.Provider;
import com.donate.beans.Receiver;
import com.donate.mail.OrderConfirmationMailer;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	private String providerEmailForAddingFoodUnit;

	@Override
	public boolean addFoodProvider(Provider provider) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		System.out.println("dao called");
		try {
		transaction.begin();
		manager.persist(provider);
		transaction.commit();
		return true;
		}catch (Exception e) {
			return false;
		}finally {
			factory.close();
			manager.close();
		}
	}

	@Override
	public boolean logMeIn(String email, String password,String type) {
		if(type.equals("Donor")) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Provider p where p.email=:mail");
		query.setParameter("mail", email);
		try {
		List provider = query.getResultList();
		Provider data = (Provider) provider.get(0);
		if(data.getPassword().equals(password)){
			return true;
		}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		}else {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
			EntityManager manager = factory.createEntityManager();
			
			Query query = manager.createQuery("from Receiver p where p.email=:mail");
			query.setParameter("mail", email);
			try {
			List provider = query.getResultList();
			Receiver data = (Receiver) provider.get(0);
			if(data.getPassword().equals(password)){
				return true;
			}
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}

	@Override
	public boolean mailExistance(String email) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Provider p where p.email=:mail");
		query.setParameter("mail", email);
		try {
		List provider = query.getResultList();
		Provider data = (Provider) provider.get(0);
		if(data!=null){
			return true;
		}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean updatePassword(String email,String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Provider p where p.email=:mail");
		query.setParameter("mail", email);
		List provider = query.getResultList();
		Provider data = (Provider) provider.get(0);
		
		data.setPassword(password);
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		manager.persist(data);
		transaction.commit();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addUnitFood(FoodUnit foodUnit) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
		transaction.begin();
		manager.persist(foodUnit);
		transaction.commit();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addReceiver(Receiver receiver) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
		transaction.begin();
		manager.persist(receiver);
		transaction.commit();
		return true;
		}catch (Exception e) {
			return false;
		}finally {
			factory.close();
			manager.close();
		}
	}

	@Override
	public List<FoodUnit> getAllFoods() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		
		
		Query query = manager.createQuery("from FoodUnit where isTaken=false");
		try {
		List<FoodUnit> foods = query.getResultList();
		return foods;
		}catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	@Transactional
	synchronized public boolean selectFood(long phone, String email) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		FoodOrders orders = new FoodOrders();
		orders.setDonorPhone(phone);
		orders.setReceiverEmail(email);
		Query query = manager.createQuery("from FoodUnit where contactNumber=:phone");
		query.setParameter("phone", phone);
		List<FoodUnit> unit = query.getResultList();
		providerEmailForAddingFoodUnit = unit.get(0).getProviderEmail();
		FoodUnit foodUnit =  manager.find(FoodUnit.class, unit.get(0).getUnitId());
		foodUnit.setTaken(true);
		try {
		transaction.begin();
		manager.persist(orders);
		manager.persist(foodUnit);
		transaction.commit();
		return true;
		}catch (Exception e) {
			return false;
		}finally {
			factory.close();
			manager.close();
		}
	}

	@Override
	public boolean verifyReceiverOTPAndDeleteRecord(String email, int otp) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrders orders = manager.find(FoodOrders.class, email);
		 
		try {
			if(orders.getReceiverOtp() == otp) {
				transaction.begin();
				manager.remove(orders);
				transaction.commit();
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean sendConfirmationAndOTP(String email, long phone, int otp) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("new");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		
		FoodOrders orders=manager.find(FoodOrders.class, email);
		Query query = manager.createQuery("from FoodUnit where providerEmail=:pemail");
		query.setParameter("pemail",this.providerEmailForAddingFoodUnit);
		System.out.println(providerEmailForAddingFoodUnit);
		FoodUnit unit = (FoodUnit) query.getSingleResult();
		orders.setReceiverOtp(otp);
		try {
		new OrderConfirmationMailer().sendMail(email, unit, otp);	
		transaction.begin();
		manager.persist(orders);
		transaction.commit();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	

}
