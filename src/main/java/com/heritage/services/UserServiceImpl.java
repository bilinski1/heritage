package com.heritage.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.apache.tomcat.jni.Sockaddr;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.heritage.dto.UserAchievementDTO;
import com.heritage.dto.UserDto;

import com.heritage.entity.UserEntity;
import com.heritage.repository.UserRepository;
import com.heritage.requestmodel.UserDetailsRequestModel;
import com.heritage.utils.Utils;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserEntity user;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsRequestModel userDetailsRequestModel;
	
	@Autowired
	UserDto userDTO;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	Utils utils;
	
	

	//Get list of User Achievements
	/*@Override
	public List<UserAchievementDTO> getAllUserAchievement() {
        return ((List<UserEntity>) userRepository.findAll())
                .stream()
                .map(this::convertToUserAchievementDTO)
				.collect(Collectors.toList());
	}
	*/
	
	
	//Create User (using model mapper)
	@Override
	public UserDto createUser(UserDto userDto) 
	{
		if (userRepository.findByEmail(userDto.getEmail()) != null)
		throw new RuntimeException("Record already exists");
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
    	String publicUserId = utils.generateUserId(12);
		userEntity.setUserId(publicUserId);
    	userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    	UserEntity storedUserDetails = userRepository.save(userEntity);
    	UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);
    	return returnValue;
	}
	

	
	
	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		UserDto returnValue = new UserDto();
		UserEntity user = userRepository.findById(id);
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
    public UserDto getUserById(String id) {
    	UserDto returnValue = new UserDto();
    	UserEntity user = userRepository.findById(id);
        BeanUtils.copyProperties(user, returnValue);
        System.out.println("Returning user id {id}");
        return returnValue;
      
    }

	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(username);
		if (userEntity == null) throw new UsernameNotFoundException(username);
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>()); 
				//userEntity.getEmailVerificationStatus(),
				//true, true,
				//true, new ArrayList<>());
	}


	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null) throw new UsernameNotFoundException(email);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyEmailToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestPasswordReset(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPassword(String token, String password) {
		// TODO Auto-generated method stub
		return false;
	}

   

}
