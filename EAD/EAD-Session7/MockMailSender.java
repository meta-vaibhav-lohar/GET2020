package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Uncomment @Component to make it component.
//@Component
//@Primary
public class MockMailSender implements MailSender {
	
	@Override
	public void SendMail() {
		System.out.println("Mock Mail");
	}
}
