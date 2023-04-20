package com.heritage.controller;

import java.util.List;

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
import com.heritage.dto.UserAchievementDTO;
import com.heritage.dto.UserDTO;

import com.heritage.entity.UserEntity;
import com.heritage.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	//Get particular user by ID
	 @GetMapping("/{id}")
	 public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") String id){
		 return ResponseEntity.ok(userService.getUserById(id));
	 }

	//Create User
	 @PostMapping("/newuser")
	 public UserEntity createUser(@RequestBody UserEntity user)
	 {
		 UserDTO userDto = new UserDTO();
		 BeanUtils.copyProperties(user, userDto);
		 System.out.println("User Created");
		 return userService.createUser(userDto);
	 }
	 
	 //Update User
	 @PutMapping("/update/{id}")
	 public UserEntity updateUser(@PathVariable String id, @RequestBody UserEntity userDetails)
	 {
		 UserEntity returnValue = new UserEntity();
		 UserDTO userDTO = new UserDTO();
		 BeanUtils.copyProperties(userDetails, userDTO);
		 UserDTO updatedUser = userService.updateUser(id, userDTO);
		 System.out.println("User Updated");
		 BeanUtils.copyProperties(updatedUser, returnValue);
		 return returnValue;
	 }
	 
	 
	 
	//Get list of all users
	 @GetMapping("/allusers")
	 public List<UserAchievementDTO> getAllUserAchievement(){
		 return userService.getAllUserAchievement();
	 }
	 
	 
	 

}
