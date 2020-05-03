package com.mkdev.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-03 9:53:23 pm 
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class DnUserRestConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnUserRestConsumeApplication.class, args);
	}

}
