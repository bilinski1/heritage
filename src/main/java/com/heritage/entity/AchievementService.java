package com.heritage.entity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heritage.repository.AchievementRepository;

@Service
public class AchievementService {

	@Autowired
	private AchievementRepository achievementRepository;
	
	public AchievementEntity saveAchievement(AchievementEntity achievement) {
		return achievementRepository.save(achievement);
	}
	
	public List<AchievementEntity> getAchievements(){
		return achievementRepository.findAll();
	}
	
	public AchievementEntity getAchievementById(long id) {
		return achievementRepository.findById(id).orElse(null);
	}
	
	public AchievementEntity getAchievementByName(String name) {
		return achievementRepository.findByName(name);
	}
}
