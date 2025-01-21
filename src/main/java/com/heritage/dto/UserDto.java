package com.heritage.dto;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDto {
	private String id;
    private String userId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private String password;
	private String encryptedPassword;
}

