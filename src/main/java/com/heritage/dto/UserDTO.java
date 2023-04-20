package com.heritage.dto;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDTO {
	private String id;
	private String firstName;
	private String lastName;
	private Integer age;
}
