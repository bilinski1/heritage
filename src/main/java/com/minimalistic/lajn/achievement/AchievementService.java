package com.minimalistic.lajn.achievement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {

	@Autowired
	private AchievementRepository achievementRepository;
	
	public Achievement saveAchievement(Achievement achievement) {
		return achievementRepository.save(achievement);
	}
	
	public List<Achievement> getAchievements(){
		return achievementRepository.findAll();
	}
	
	public Achievement getAchievementById(long id) {
		return achievementRepository.findById(id).orElse(null);
	}
	
	public Achievement getAchievementByName(String name) {
		return achievementRepository.findByName(name);
	}
}
