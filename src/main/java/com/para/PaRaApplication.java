package com.para;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaRaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaRaApplication.class, args);
	}
	@GetMapping
	public String hello(){
		return "Tej działa kurde ten";
	}
}
