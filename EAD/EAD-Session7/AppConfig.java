package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.MailSender;
import com.example.demo.MockMailSender;
import com.example.demo.SmtpMailSender;


//Uncomment the @Configuration while using the @Component annotation.
@Configuration
public class AppConfig {

	@Bean("beanMock")
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

	@Bean("beanSmtp")
	public MailSender SMTPMailSender() {
		return new SmtpMailSender();
	}
}
