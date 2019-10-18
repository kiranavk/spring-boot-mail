package com.practise.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.practise.model.Mail;

/**
 * https://www.google.com/settings/security/lesssecureapps
 * make sure you go to the above link and allow less secure apps turned on 
 * after logging in using the username and password provided in application.properties. 
 * @author kiranavk
 *
 */
@Service
public class MailSenderService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendEmail(Mail mail) {
		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setText("Hello world from spring boot");
//		msg.setSubject("Hi There!!!");
//		msg.setFrom("adhikarlakiran@gmail.com");
//		msg.setText("avk.kirankumar@gmail.com");
		
		msg.setText(mail.getTextMessage());
		msg.setSubject(mail.getSubject());
		msg.setFrom(mail.getFromAddress());
		msg.setTo(mail.getToAddress());
		
		javaMailSender.send(msg);
	}
}
