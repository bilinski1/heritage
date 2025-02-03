package com.heritage.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heritage.entity.UserProject;
import org.springframework.stereotype.Component;

import lombok.Data;

import java.util.List;

@Component
@Data
public class UserDto {
	private String id;
    private String publicId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private String password;
	private String encryptedPassword;
	private List<UserProjectDto> achievements;
	private String token;
	private String refreshToken;
}

