package com.mkdev.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-Jun-04 5:01:02 am 
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mkdev.first.*","com.mkdev.second.*"})
public class DnModuleMainPackgingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnModuleMainPackgingApplication.class, args);
	}

}
