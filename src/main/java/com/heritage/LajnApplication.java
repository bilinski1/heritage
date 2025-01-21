package com.heritage;

import com.heritage.entity.Role;
import com.heritage.entity.UserEntity;
import com.heritage.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.heritage.config.SpringApplicationContext;



@SpringBootApplication //(exclude={SecurityAutoConfiguration.class})
public class LajnApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	
	//Model mapper for DTO
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(LajnApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void run(String... args) throws Exception {
		UserEntity adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount){
			UserEntity user = new UserEntity();

			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
