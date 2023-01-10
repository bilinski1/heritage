package com.minimalistic.lajn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LajnController {
	
	@GetMapping("/test") 
		public String showsomething() 
		{
		return "something";
				};
	
};
