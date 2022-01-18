package com.microservice.purchase;

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
				"com.pattern.chassis.config.maria.secondary",
				"com.microservice.purchase" 
		})
@EntityScan("com.common.maria.secondary")
public class PurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseApplication.class, args);
	}

}
