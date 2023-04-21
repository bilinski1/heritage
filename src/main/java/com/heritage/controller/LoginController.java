package com.heritage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.entity.UserEntity;
import com.heritage.repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserEntity heritageUser) {
			UserEntity savedHeritageUser = null;
			ResponseEntity response = null;
			try {
				savedHeritageUser = userRepository.save(heritageUser);
	            if (savedHeritageUser.getId().length() > 0) {
	                response = ResponseEntity
	                        .status(HttpStatus.CREATED)
	                        .body("Given user details are successfully registered");
	            }
	        } catch (Exception ex) {
	            response = ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("An exception occured due to " + ex.getMessage());
	        }
			return response;
	}
}
