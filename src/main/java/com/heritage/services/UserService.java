package com.heritage.services;

import com.heritage.dto.UserDto;
import com.heritage.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    UserDto getUser(String publicId);
    List<UserDto> getAllUsers();
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto user);
    void deleteUser(String userId);
    //boolean verifyEmailToken(String token);
    //boolean requestPasswordReset(String email);
    //boolean resetPassword(String token, String password);

}

