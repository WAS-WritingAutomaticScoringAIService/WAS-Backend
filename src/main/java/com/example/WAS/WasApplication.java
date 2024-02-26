package com.example.WAS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan(basePackages = {"com.example.WAS"})
@EnableJpaAuditing
@SpringBootApplication
public class WasApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasApplication.class, args);
	}

	// test 2
}
