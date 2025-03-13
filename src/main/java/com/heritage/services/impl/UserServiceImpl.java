package com.heritage.services.impl;

import com.heritage.dto.UserDto;
import com.heritage.entity.User;
import com.heritage.repository.UserRepository;
import com.heritage.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDto getUser(String publicId) {
        Optional<User> userOptional = userRepository.findByPublicId(publicId);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return modelMapper.map(userOptional.get(), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Fetch all user entities from the database
        List<User>  users = userRepository.findAll();
        // Use ModelMapper to map entities to DTOs
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto getUserByUserId(String publicId) {
        User user = userRepository.findByPublicId(publicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + publicId));
        return modelMapper.map(user, UserDto.class);
    }


    @Override
    public UserDto updateUser(String userId, UserDto user) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}

