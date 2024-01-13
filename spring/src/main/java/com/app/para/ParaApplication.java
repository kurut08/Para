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
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin@admin.com","admin", passwordEncode.encode("admin"), roles);

			Game_Media defaultGameMedia = new Game_Media(1, "https://fastly.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U");
			gameMediaRepo.save(defaultGameMedia);
			userRepository.save(admin);
		};
	}
}
