package com.bbt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

//component it is part of spring boot to manage the spring boot class 
//if we don't use @component then this would be a normal java class 
//where spring boot can't understand it
@Component
public class BbtEmailImp implements bbtEmail {

	
	@Autowired
	//JavaMailSender it in inbuilt interface feature from springboot mail dependency
	//to send mail.
	//thesse two class and interface can only work 
	private JavaMailSender sender;
	@Override
	public void bbtEmailSend(String to, String sub, String text) {

		//inbuilt class from java from spring boot dependency.
		SimpleMailMessage s=new SimpleMailMessage();
		//using s object by simplemailmessage from the below setto,setsubject,settext used to set the address 
		//subject and text of the mail.
		s.setTo(to);
		s.setSubject(sub);
		s.setText(text);
		
		//sender from the above object refered to interface allows to transfer the data.
		
		sender.send(s);
		
	}

}
