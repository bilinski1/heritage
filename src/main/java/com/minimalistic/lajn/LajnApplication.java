package com.minimalistic.lajn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class LajnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LajnApplication.class, args);
	}

}
