package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	// Uncomment @Autowired to perform name injection.
	// @Autowired
	// Uncomment @Qualifier to solve the multiple bean problem.
	// @Qualifier("smtpmailsender")
	private MailSender mailSender;

	// Uncomment below lines and comment the setter to apply constructor injection.
	/*
	 * @Autowired public SendingController(MailSender mailSender) { this.mailSender
	 * = mailSender; }
	 */

	@Autowired
	public void setMailSender(MailSender beanMock) {
		this.mailSender = beanMock;
	}

	@GetMapping("/send")
	public String sendMail() {

		mailSender.SendMail();

		return "Mail sent successfully";
	}
}