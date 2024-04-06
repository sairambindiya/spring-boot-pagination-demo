package com.userservice.pagination.springbootpaginationdemo;

import com.userservice.pagination.springbootpaginationdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPaginationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPaginationDemoApplication.class, args);
	}

	private static final Logger logger= (Logger) LoggerFactory.getLogger(UserService.class);
	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			userService.insertMillionUsers();
			long count = userService.countUsers();
			logger.info("Total users in the database: {}", count);

		};
	}
}
