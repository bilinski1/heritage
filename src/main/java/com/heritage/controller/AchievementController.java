package com.heritage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.entity.UserProject;
import com.heritage.entity.AchievementService;

@RestController
public class AchievementController {
	
	@Autowired
	private AchievementService service;
	
	public UserProject addAchievement(UserProject achievement) {
		return service.saveAchievement(achievement);
	}

}
