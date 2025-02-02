package com.heritage.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heritage.entity.Role;
import com.heritage.entity.UserProject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JwtAuthenticationResponse {

    private String token;
    private String refreshToken;
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private String encryptedPassword;
    @JsonManagedReference
    private List<UserProject> projects;
    private Role role;

}
