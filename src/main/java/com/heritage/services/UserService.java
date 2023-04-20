package com.heritage.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.heritage.dto.UserAchievementDTO;
import com.heritage.dto.UserDTO;

import com.heritage.entity.UserEntity;
import com.heritage.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserEntity user;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDTO userDTO;
	
	

	//Get list of User Achievements
	public List<UserAchievementDTO> getAllUserAchievement() {
        return ((List<UserEntity>) userRepository.findAll())
                .stream()
                .map(this::convertToUserAchievementDTO)
				.collect(Collectors.toList());
		
	}
	
	//Create User (using model mapper)
	public UserEntity createUser(UserDTO userDto) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity user = new UserEntity();
    	user = modelMapper.map(userDto, UserEntity.class);
    	userRepository.save(user);
    	return user;

	
	}
	
	//Update User (using model mapper)
	public UserDTO updateUser(String id, UserDTO userDto) {
		UserDTO returnValue = new UserDTO();
		UserEntity user = userRepository.findById(id).get();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		//user = modelMapper.map(userDTO, User.class);
		UserEntity updatedUserDetails = userRepository.save(user);
		BeanUtils.copyProperties(updatedUserDetails, returnValue);
		return returnValue;
	}
	
	
	//Passing Entity to DTO
    public UserAchievementDTO convertToUserAchievementDTO(UserEntity user) {
    	modelMapper.getConfiguration()
    	.setMatchingStrategy(MatchingStrategies.LOOSE);
    	UserAchievementDTO userAchievementDTO = new UserAchievementDTO();
    	userAchievementDTO = modelMapper.map(user, UserAchievementDTO.class);
    	return userAchievementDTO;
    }
    
	//Passing DTO to Entity
    public UserEntity convertDTOtoEntity(UserAchievementDTO userAchievementDTO) {
    	modelMapper.getConfiguration()
    	.setMatchingStrategy(MatchingStrategies.LOOSE);
    	UserEntity user = new UserEntity();
    	user = modelMapper.map(userAchievementDTO, UserEntity.class);
    	return user;
    }
    
    //Find User By id
    public UserDTO getUserById(String id) {
    	UserDTO returnValue = new UserDTO();
    	UserEntity user = userRepository.findById(id).get();
        BeanUtils.copyProperties(user, returnValue);
        System.out.println("Returning user id {id}");
        return returnValue;
      
    }

   

}
