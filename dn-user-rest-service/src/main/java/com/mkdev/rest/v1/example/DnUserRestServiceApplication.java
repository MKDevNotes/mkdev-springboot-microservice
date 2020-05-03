package com.mkdev.rest.v1.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mkdev.rest.v1.example.model.DnUser;
import com.mkdev.rest.v1.example.repository.DnUserRepository;


/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-03 9:54:40 pm 
 */
@SpringBootApplication
public class DnUserRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnUserRestServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DnUserRepository userRepository) {
		return (args) -> {
			DnUser user1 = new DnUser("user fistName1", "user lastName1", "user email1", 200.10);
			userRepository.save(user1);
			DnUser user2 = new DnUser("user fistName2", "user lastName2", "user email2", 302.2);
			userRepository.save(user2);
			DnUser user3 = new DnUser("user fistName3", "user lastName3", "user email3", 40.32);
			userRepository.save(user3);
			DnUser user4 = new DnUser("user fistName4", "user lastName4", "user email4", 403.23);
			userRepository.save(user4);
			DnUser user5 = new DnUser("user fistName5", "user lastName5", "user email5", 323.32);
			userRepository.save(user5);
		};
	}

}
