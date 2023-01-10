package com.minimalistic.lajn.achievement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementController {
	
	@Autowired
	private AchievementService service;
	
	public Achievement addAchievement(Achievement achievement) {
		return service.saveAchievement(achievement);
	}

}
