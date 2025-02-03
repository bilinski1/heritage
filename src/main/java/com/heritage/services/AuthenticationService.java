package com.heritage.services;
import com.heritage.dto.*;
import com.heritage.entity.User;

public interface AuthenticationService {

        User signup(SignUpRequest userDto);

        JwtAuthenticationResponse signin(SigninRequest signinRequest);

        JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
