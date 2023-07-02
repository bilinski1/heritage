package com.heritage.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserResponse {
		private String id;
		private String firstName;
		private String lastName;
		private Integer age;
		private String email;
	}

