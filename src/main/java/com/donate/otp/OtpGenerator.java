package com.donate.otp;

import java.util.Random;

public class OtpGenerator {
	
	public int getOtp() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(8999);
		return otp;
	}

}
