package com.ibrahim.springMongo;

import com.ibrahim.springMongo.entity.Tutorial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.core.mapping.Document;

//url den bağlandığımız için gerekli
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringMongoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMongoApplication.class, args);

		
	}
}
