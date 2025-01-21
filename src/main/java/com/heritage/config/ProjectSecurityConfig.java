/*
package com.heritage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.heritage.services.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {
	
	private final UserServiceImpl userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public ProjectSecurityConfig(UserServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	this.userDetailsService = userDetailsService;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    	//Configure AuthenticationManagerBuilder
    	AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    	
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.csrf().disable().authorizeHttpRequests()
              //  .requestMatchers("/*").authenticated()
                .requestMatchers("/users/**","/login", "/register").permitAll()
                .anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic()
        		.and()
        		.authenticationManager(authenticationManager)
        		.addFilter(new AuthenticationFilter(authenticationManager));

        return http.build();


}
}
*/