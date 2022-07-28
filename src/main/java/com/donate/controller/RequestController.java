package com.donate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.donate.beans.FoodUnit;
import com.donate.beans.Provider;
import com.donate.beans.Receiver;
import com.donate.mail.OTPMailer;
import com.donate.otp.OtpGenerator;
import com.donate.service.ServiceProvider;

@Controller
public class RequestController {

	@Autowired
	private ServiceProvider serviceProvider;

	private Provider provider1;
	private int signupOtp;

	int passwordChangeOtp;
	
	private boolean receiver = false;
	private Receiver receiver1;

	private String receiverEmail;
	private String providerEmailForAddingFoodUnit;

	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/handover")
	public String handOver(){
		return "handOverFoodPageForProvider";
	}
	@PostMapping("/submitOtpToHandoverFood")
	public String submitOtpToHandOver(@RequestParam("email") String email,@RequestParam("otp") int otp,Model model) {
		if(serviceProvider.verifyReceiverOTPAndDeleteRecord(email, otp)==true) {
			model.addAttribute("message", "OTP Verified...You Can HandOver the food now");
			return "response";
		}else {
			model.addAttribute("message", "Please enter valid information");
			return "handOverFoodPageForProvider";
		}
	}

	@GetMapping("/get/{phone}")
	public String selectFood(@PathVariable("phone") long phone,Model model) {
		
		boolean result = serviceProvider.selectFood(phone, receiverEmail);
		if(result == true) {
			int otp = new OtpGenerator().getOtp();
			
			serviceProvider.sendConfirmationAndOTP(receiverEmail, phone, otp);
			model.addAttribute("message", "You have Selected the order Successfully");
			return "response";
		}else {
			model.addAttribute("message", "Something Went Wrong");
			return "response";
		}
	}

	@GetMapping("/forgotpasswordrequest")
	public String forgotPasswordRequest() {

		return "forgotpassword";
	}

	@PostMapping("/getotp")
	public String getOTP(@RequestParam("email") String email, Model model) {

		if (serviceProvider.mailExistance(email) == true) {
			int otp = new OtpGenerator().getOtp();
			this.passwordChangeOtp = otp;
			OTPMailer mailer = new OTPMailer();
			mailer.sendMail(email, otp);
			model.addAttribute("message", "OTP successfully sent to your mail address");
			model.addAttribute("otp", otp);
			model.addAttribute("email", email);
			model.addAttribute("otpsent", "sent");
			return "forgotpassword";
		} else {
			model.addAttribute("message", "email address doesn't exist");
			return "forgotpassword";
		}
	}

	@GetMapping("/providersignup")
	public String signup() {
		return "providersignup";
	}

	@GetMapping("/receiversignup")
	public String receiverSignupPage() {
		return "receiversignup";
	}

	@PostMapping("/submitotp")
	public String submitOtp(@RequestParam("email") String email,
			@RequestParam("enteredotp") int enteredotp, Model model) {

		System.out.println(this.passwordChangeOtp + " " + enteredotp);
		if (this.passwordChangeOtp == enteredotp) {
			model.addAttribute("email", email);
			
			return "createnewpassword";
		} else {
			model.addAttribute("message", "Invalid OTP");
			model.addAttribute("otpsent", "true");
			return "forgotpassword";
		}
	}

	@PostMapping("/updatepassword")
	public String updatePassword(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("passwordagain") String passwordAgain, Model model) {
		System.out.println(email + " " + password + " " + passwordAgain);
		if (password.equals(passwordAgain)) {
			boolean result = serviceProvider.updatePassword(email, password);
			if (result == true) {
				model.addAttribute("message", "Password Updated Successfully...!!");
				return "login";
			} else {
				model.addAttribute("exception", "Something Went Wrong...!!");
				return "createnewpassword";
			}
		} else {
			model.addAttribute("passwordmismatch", "Password Mismatch...Type Again");
			return "createnewpassword";
		}
	}

	@PostMapping("/formsubmit")
	public String submitForm(@RequestParam("providerName") String name, @RequestParam("phone") long phone,
			@RequestParam("email") String email, @RequestParam("city") String city,
			@RequestParam("cityArea") String cityArea, @RequestParam("address") String address,
			@RequestParam("typeOfUser") String typeOfUser, @RequestParam("password") String password,
			@RequestParam("passwordagain") String passwordAgain, @RequestParam("type") String type, Model model) {

		if (type.equals("doner")) {
			Provider provider = new Provider();
			provider.setAddress(address);
			provider.setCity(city);
			provider.setCityArea(cityArea);
			provider.setTypeOfUser(typeOfUser);
			provider.setEmail(email);
			provider.setPhone(phone);
			provider.setProviderName(name);
			provider.setPassword(passwordAgain);

//		if(password.equals(passwordAgain)) {
//			serviceProvider.addFoodProvider(provider);
//		}
			if (password.equals(passwordAgain) && password.length() >= 8) {
				provider1 = provider;
				
				int otp = new OtpGenerator().getOtp();
				signupOtp = otp;
				new OTPMailer().sendMail(email, otp);
				model.addAttribute("email", email);
				return "signupmailverify";
			} else {
				if (!password.equals(passwordAgain)) {
					model.addAttribute("message", "Password Mismatch");
					return "providersignup";
				} else if (password.length() < 8) {
					model.addAttribute("message", "Password length must contain atleast 8 characters");
					return "providersignup";
				}
			}

		} else {
			Receiver receiver = new Receiver();
			receiver.setReceiverName(name);
			receiver.setPhone(phone);
			receiver.setEmail(email);
			receiver.setTypeOfUser(typeOfUser);
			receiver.setCityArea(cityArea);
			receiver.setCity(city);
			receiver.setAddress(address);
			receiver.setPassword(password);
			if (password.equals( passwordAgain) && password.length() >= 8) {
				receiver1 = receiver;
				this.receiver = true;
				model.addAttribute("email", email);
				int otp = new OtpGenerator().getOtp();
				signupOtp = otp;
				new OTPMailer().sendMail(email, otp);
				return "signupmailverify";
			} else {
				
				if (!password.equals(passwordAgain)) {
					model.addAttribute("message", "Password Mismatch");
					return "receiversignup";
				} else if (password.length() < 8) {
					model.addAttribute("message", "Password length must contain atleast 8 characters");
					return "receiversignup";
				}
			}
			System.out.println(receiver);
		}
		return null;
	}

	@PostMapping("/addprovider")
	public String addProvider(@RequestParam("enteredotp") int otp, Model model) {
		if (signupOtp == otp) {
			boolean result;
			//System.out.println(receiver);
			if (this.receiver == true) {
				result = serviceProvider.addReceiver(receiver1);
			} else {
				result = serviceProvider.addFoodProvider(provider1);
			}
			model.addAttribute("message", "Account Created...Please try to login");
			return "login";
		} else {
			model.addAttribute("otpmismatch", "OTP Mismatch...Try Again");
			return "signupmailverify";
		}
	}

	@PostMapping("/logindata")
	public String logMeIn(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("type") String type, Model model) {
		boolean verified = serviceProvider.logMeIn(email, password, type);
		if (verified == true) {
			if (type.equals("Donor")) {
				this.providerEmailForAddingFoodUnit = email;
				System.out.println(providerEmailForAddingFoodUnit);
				return "donate";
			} else {
				List<FoodUnit> foods = serviceProvider.getAllFoods();
				model.addAttribute("foods", foods);
				this.receiverEmail = email;
				return "showallfoods";
			}
		} else {
			model.addAttribute("message", "Wrong Credentials...!!");
			return "login";
		}
	}

	@PostMapping("/changepassword")
	public String changePassword(@RequestParam("email") String email, @RequestParam("otp") int otp) {

		return null;
	}

	@PostMapping("/addunitfood")
	public String addUnitFood(@RequestParam("name") String name, @RequestParam("serves") int serves,
			@RequestParam("items") int items, @RequestParam("hours") int hours, @RequestParam("phone") long contact,
			 @RequestParam("address") String address,
			@RequestParam("landmark") String landmark,Model model) {
		FoodUnit foodUnit = new FoodUnit();
		foodUnit.setName(name);
		foodUnit.setServes(serves);
		foodUnit.setItems(items);
		foodUnit.setAvailabilityInHours(hours);
		foodUnit.setContactNumber(contact);
//		System.out.println("Alternative contact: "+altContact);
//		if(altContact!=0) {
//			foodUnit.setAlternativeContactNumber(altContact);
//		}
		foodUnit.setAddress(address);
		foodUnit.setLandmark(landmark);
		Date date = new Date();
		foodUnit.setDate(date);
		foodUnit.setProviderEmail(providerEmailForAddingFoodUnit);
		System.out.println(foodUnit);
		serviceProvider.addUnitFood(foodUnit);
		model.addAttribute("message", "Thank You for your valuable Contibution");
		return "response";
	}

}
