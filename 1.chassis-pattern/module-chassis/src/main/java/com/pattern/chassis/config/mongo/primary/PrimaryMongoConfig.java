package com.pattern.chassis.config.mongo.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.pattern.chassis.config.mongo.NewAbstractMongoConfig;

@Configuration
@EnableMongoRepositories(basePackages = { "com.pattern.chassis.repository.mongo.primary" }, mongoTemplateRef = "PrimaryMongoTemplate")
public class PrimaryMongoConfig extends NewAbstractMongoConfig {

	@Primary
	@Bean(name = "PrimaryMongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory("development_partner", "mongodb://localhost:27017/development_partner"));
		System.out.println("Primary MongoTemplate created...");
		return mongoTemplate;
	}
}
