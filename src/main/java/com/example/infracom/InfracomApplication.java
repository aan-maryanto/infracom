package com.example.infracom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.infracom.entity.Users;
import com.example.infracom.entity.UsersContact;
import com.example.infracom.services.UsersService;

@SpringBootApplication
public class InfracomApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfracomApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UsersService usersService) {
		return args -> {
			// Add Users when application start
			usersService.addUsers(new Users("1", "Aan Maryanto", 28));
			usersService.addUsers(new Users("2", "Aan", 27));
			// Add Users Contact when application start
			usersService.addUsersContact(new UsersContact("1", "Bekasi", null));
			usersService.addUsersContact(new UsersContact("2", "Tambun Utara", null));
			// Add Users To Contact when application start
			usersService.addUserToContact("1", "1");
			usersService.addUserToContact("2", "2");
		};
	}

}
