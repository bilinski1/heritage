/*
package com.heritage.services.impl;

import com.heritage.services.UserService;
import com.heritage.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.heritage.dto.UserAchievementDTO;
import com.heritage.dto.UserDto;

import com.heritage.entity.UserEntity;
import com.heritage.utils.Utils;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;
	
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


	//Load user by username
	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
			}
		};
	}


	//Create User (using model mapper)
	@Override
	public UserDto createUser(UserDto userDto) 
	{
		if (userRepository.findByEmail(userDto.getEmail()).isPresent()) throw new RuntimeException("Record already exists");
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
    	String publicUserId = utils.generateUserId(12);
		userEntity.setUserId(publicUserId);
    	userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
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

        //Passing DTO to Entity
        public UserEntity convertDTOtoEntity (UserAchievementDTO userAchievementDTO){
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.LOOSE);
            UserEntity user = new UserEntity();
            user = modelMapper.map(userAchievementDTO, UserEntity.class);
            return user;
        }

        //Find User By id
        public UserDto getUserById (String id){
            UserDto returnValue = new UserDto();
            UserEntity user = userRepository.findById(id);
            BeanUtils.copyProperties(user, returnValue);
            System.out.println("Returning user id {id}");
            return returnValue;

        }


        @Override
        public UserDto getUser (String email){
            UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found"));
            if (userEntity == null) throw new UsernameNotFoundException(email);
            UserDto returnValue = new UserDto();
            BeanUtils.copyProperties(userEntity, returnValue);
            return returnValue;
        }

        @Override
        public UserDto getUserByUserId (String userId){
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void deleteUser (String userId){
            // TODO Auto-generated method stub

        }

        @Override
        public boolean verifyEmailToken (String token){
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean requestPasswordReset (String email){
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean resetPassword (String token, String password){
            // TODO Auto-generated method stub
            return false;
        }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
		*/