package com.ekeneattoh.fyiapi;

import controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import services.UserService;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class FyiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FyiApiApplication.class, args);
	}

	@Bean
	public UserService userService(){
		return new UserService();
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

}
