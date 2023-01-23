package com.hekim.CityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityServiceApplication.class, args);
	}

}
