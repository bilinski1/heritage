/*
		package com.heritage.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.heritage.dto.UserDto;

import com.heritage.entity.UserEntity;
import com.heritage.dto.UserDetailsRequestModel;
import com.heritage.response.UserResponse;
//import com.heritage.services.impl.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
//	@Autowired
//	UserServiceImpl userService;


	@GetMapping
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hi User");
	}


	//Create User
	 @PostMapping("/newuser")
	 public UserResponse createUser(@RequestBody UserDetailsRequestModel user) throws Exception
	 {
		 
		 UserResponse returnValue = new UserResponse();
		 ModelMapper modelMapper = new ModelMapper();
		 UserDto userDto = modelMapper.map(user, UserDto.class);
		 UserDto createdUser = userService.createUser(userDto);
		 System.out.println("User Created");
		 returnValue = modelMapper.map(createdUser, UserResponse.class);
		 UserResponse returnValue1 = returnValue;
		 return returnValue1;
		 
		 
	 }
	 
	 //Update User
	 @PutMapping("/update/{id}")
	 public UserEntity updateUser(@PathVariable String id, @RequestBody UserEntity userDetails)
	 {
		 UserEntity returnValue = new UserEntity();
		 UserDto userDto = new UserDto();
		 BeanUtils.copyProperties(userDetails, userDto);
		 UserDto updatedUser = userService.updateUser(id, userDto);
		 System.out.println("User Updated");
		 BeanUtils.copyProperties(updatedUser, returnValue);
		 return returnValue;
	 }
	 
	 
	 /*
	//Get list of all users
	 @GetMapping("/allusers")
	 public List<UserAchievementDTO> getAllUserAchievement(){
		 return userService.getAllUserAchievement();
	 }

	 
	 
	 

}
	 */