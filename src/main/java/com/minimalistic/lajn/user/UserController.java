package com.minimalistic.lajn.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.minimalistic.lajn.dto.UserAchievementDTO;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	 @GetMapping("/user/{id}")
	 public User getById(@PathVariable String id) 
	 
	 {
		 return userService.getUserById(id);
	 }
	 
	 @GetMapping("/user/allusers")
	 public List<UserAchievementDTO> getAllUserAchievement(){
		 return userService.getAllUserAchievement();
	 }
	 

}
