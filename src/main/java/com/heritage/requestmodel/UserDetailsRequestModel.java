package com.heritage.requestmodel;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDetailsRequestModel {
	
	private String id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String password;
	private String email;

}
