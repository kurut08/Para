package com.app.para;

import com.app.para.repository.GameLibraryRepo;
import com.app.para.repository.GameRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.para.repository.RoleRepo;
import com.app.para.repository.UserRepo;

@SpringBootApplication
public class ParaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParaApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode, GameRepo gameRepo, GameLibraryRepo gameLibraryRepo){
		return args ->{
			SampleDataFiller sdf = new SampleDataFiller();
			sdf.FillDatabase(roleRepository, userRepository, passwordEncode, gameRepo, gameLibraryRepo);
		};
	}
}
