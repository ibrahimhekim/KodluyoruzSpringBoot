package com.hekim.sosyalMedya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SosyalMedyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SosyalMedyaApplication.class, args);
	}

}
