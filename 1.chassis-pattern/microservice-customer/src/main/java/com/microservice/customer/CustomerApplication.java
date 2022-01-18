package com.microservice.customer;

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
				"com.pattern.chassis.config.maria.primary",
				"com.microservice.customer" 
		})
@EntityScan("com.common.maria.primary")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
