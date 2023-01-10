package com.minimalistic.lajn.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalistic.lajn.dto.UserAchievementDTO;



@Service
public class UserService {
	
	@Autowired
	User user;
	
	
	@Autowired
	UserRepository userRepository;
	
	

	public User getUserById(String userId) {
	User returnValue = new User();
	BeanUtils.copyProperties(userId, returnValue);
	return returnValue;
	}
	
	
	public List<UserAchievementDTO> getAllUserAchievement() {
        return ((List<User>) userRepository.findAll())
                .stream()
                .map(this::convertToUserAchievementDTO)
				.collect(Collectors.toList());
		
	}
	
    public UserAchievementDTO convertToUserAchievementDTO(User user) {
    	UserAchievementDTO userAchievementDTO = new UserAchievementDTO();
    	userAchievementDTO.setUserId(user.getId());
    	userAchievementDTO.setFirstName(user.getFirstName());
    	return userAchievementDTO;
    }


}
