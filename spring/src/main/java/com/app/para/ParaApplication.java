/*
* NIE WIEM CZY KTOŚ TO BĘDZIE CZYTAŁ, ALE CÓŻ
* NO ELO
* https://www.youtube.com/watch?v=TeBt0Ike_Tk
* 1:34:00 TEST POSTMANA, WSZO DZIAŁA
* https://www.youtube.com/watch?v=5PdEmeopJVQ
* 1:38:00 FUN WITH REACT
* */
package com.app.para;

import com.app.para.models.Game_Media;
import com.app.para.repository.GameMediaRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Role;
import com.app.para.repository.RoleRepo;
import com.app.para.repository.UserRepo;

@SpringBootApplication
public class ParaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParaApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode, GameMediaRepo gameMediaRepo){
		return args ->{
			SampleDataFiller sdf = new SampleDataFiller();
			sdf.FillDatabase(roleRepository, userRepository, passwordEncode, gameMediaRepo);
		};
	}
}
