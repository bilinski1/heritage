package com.heritage.services;

import com.heritage.dto.UserDto;
import com.heritage.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    //UserDto createUser(UserDto user);
    UserDto getUser(String publicId);
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto user);
    void deleteUser(String userId);
    //List<UserDto> getUsers(int page, int limit);
    //boolean verifyEmailToken(String token);
    //boolean requestPasswordReset(String email);
    //boolean resetPassword(String token, String password);

}

