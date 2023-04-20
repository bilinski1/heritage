package com.heritage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.entity.AchievementEntity;
import com.heritage.entity.AchievementService;

@RestController
public class AchievementController {
	
	@Autowired
	private AchievementService service;
	
	public AchievementEntity addAchievement(AchievementEntity achievement) {
		return service.saveAchievement(achievement);
	}

}
