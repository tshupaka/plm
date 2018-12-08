package com.akapush.plm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.akapush.plm")
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		/*
		 * MailManager mailManager = context.getBean(MailManager.class); User user = new
		 * User(); user.setEmail("eric.pelieu@gmail.com");
		 * mailManager.sendRegistrationEmail(user, "");
		 */
	}
}
