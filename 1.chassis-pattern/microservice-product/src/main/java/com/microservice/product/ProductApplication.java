package com.microservice.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(
		exclude = { 
				DataSourceAutoConfiguration.class,
				DataSourceTransactionManagerAutoConfiguration.class 
		}, scanBasePackages = { 
				"com.pattern.chassis.config.mongo.primary",
				"com.microservice.product" 
		})
@EntityScan("com.common.maria.primary")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
