package com.para;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


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
		//https://youtu.be/Gx4iBLKLVHk?si=lc-nifXptBKD8thU&t 32:00 ~
		//Maraton for U <3
	}
	@Override
	public void run(final String... args){
		log.info("Datasource: "+ dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
