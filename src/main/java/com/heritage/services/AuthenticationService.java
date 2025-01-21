package com.heritage.services;
import com.heritage.dto.*;
import com.heritage.entity.UserEntity;

public interface AuthenticationService {

        UserEntity signup(SignUpRequest userDto);

        JwtAuthenticationResponse signin(SigninRequest signinRequest);

        JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
