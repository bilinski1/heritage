package com.heritage.entity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heritage.repository.AchievementRepository;

@Service
public class AchievementService {

	@Autowired
	private AchievementRepository achievementRepository;
	
	public UserProject saveAchievement(UserProject achievement) {
		return achievementRepository.save(achievement);
	}
	
	public List<UserProject> getAchievements(){
		return achievementRepository.findAll();
	}
	
	public UserProject getAchievementById(long id) {
		return achievementRepository.findById(id).orElse(null);
	}
	
	public UserProject getAchievementByName(String name) {
		return achievementRepository.findByName(name);
	}
}
