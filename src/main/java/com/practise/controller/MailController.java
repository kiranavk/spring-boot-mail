package com.practise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.mail.MailSenderService;
import com.practise.model.Mail;

@RestController
public class MailController {

	@Autowired
	MailSenderService mailSender;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to MailSender!!!";
	}
	
	@PostMapping("/mail")
	public void sendMail(@RequestBody Mail mail) {
		mailSender.sendEmail(mail);
	}
}
