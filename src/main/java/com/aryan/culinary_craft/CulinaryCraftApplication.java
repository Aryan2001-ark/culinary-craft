package com.aryan.culinary_craft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CulinaryCraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CulinaryCraftApplication.class, args);
	}

}
