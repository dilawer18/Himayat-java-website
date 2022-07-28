package com.donate.mail;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.donate.beans.FoodUnit;

public class OrderConfirmationMailer {

	public void sendMail(String to,FoodUnit unit, int otp) {
    	
    	System.out.println("preparing to send message ...");
		String message = "Hello Dear,Your order is confirmed.";
		message+="serves: "+unit.getServes()+" units";
		message+="Type of items: "+unit.getItems();
		message = message+"\n"+"Collect the order from:\n "+unit.getAddress();
		message+="\nLandmark: "+unit.getLandmark();
		message+="\nPhone: "+unit.getContactNumber();
		message+="\nPlease show the OTP before receiving the order.\nYour OTP is:"+otp;
		String subject = "Order Confirmed";
//		to = "jitumandal879@gmail.com";
//		from = "jitumandal866@gmail.com";
		
//		sendEmail(message,subject,to,from);
		sendAttach(message,subject,to);
	}

	//this is responsible to send the message with attachment
	private static void sendAttach(String message, String subject, String to) {

		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("diug786@gmail.com", "doaj xqao fost ndpm");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom("jitumandal866@gmail.com");
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//attachement..
		
		//file path
		String path="C:\\photo\\IMG_20210910_160331.jpg";
		
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		//text
		//file
		
		MimeBodyPart textMime = new MimeBodyPart();
		
		MimeBodyPart fileMime = new MimeBodyPart();
		
		try {
			
			textMime.setText(message);
			
			File file=new File(path);
			fileMime.attachFile(file);
			
			
			mimeMultipart.addBodyPart(textMime);
			//mimeMultipart.addBodyPart(fileMime);
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		m.setContent(mimeMultipart);
		
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	
		
		
		
	}
}
