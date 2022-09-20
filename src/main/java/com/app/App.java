package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com"})
@EntityScan("com")
@EnableJpaRepositories("com")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
//		System.out.println("Spring Application started\n");
//		System.out.println("Guess the number! (a.k.a \"Bulls and Cows\")");
	}

}
