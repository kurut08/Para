package com.para;


import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.persistence.Entity;
import javax.sql.DataSource;
import java.util.Arrays;

@EntityScan("com.para.*")
@SpringBootApplication
@Log
public class PaRaApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public PaRaApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(PaRaApplication.class, args);
		//https://www.youtube.com/watch?v=Nv2DERaMx-4 1:33:00 ~
		//https://youtu.be/Gx4iBLKLVHk?si=lc-nifXptBKD8thU&t 1:19:00 ~ Skończyłem na tym // Skidway

	}
	@Override
	public void run(final String... args){
		log.info("Datasource: "+ dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}

}
