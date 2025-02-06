package com.heritage;

import com.heritage.entity.Role;
import com.heritage.entity.User;
import com.heritage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.UUID;


@SpringBootApplication //(exclude={SecurityAutoConfiguration.class})
public class LajnApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(LajnApplication.class, args);
	}

	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN).orElse(null);
		if(null == adminAccount){
			User user = new User();
			String uniqueID = UUID.randomUUID().toString();
			user.setPublicId(uniqueID);
			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
