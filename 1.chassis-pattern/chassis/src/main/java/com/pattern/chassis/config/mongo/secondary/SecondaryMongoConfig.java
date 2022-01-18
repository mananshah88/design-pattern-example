package com.pattern.chassis.config.mongo.secondary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.pattern.chassis.config.mongo.NewAbstractMongoConfig;

@Configuration
@EnableMongoRepositories(basePackages = { "com.pattern.chassis.repository.mongo.secondary" }, mongoTemplateRef = "SecondaryMongoTemplate")
public class SecondaryMongoConfig extends NewAbstractMongoConfig {

	@Bean(name = "SecondaryMongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory("development_log", "mongodb://localhost:27017/development_log"));
		System.out.println("Secondary MongoTemplate created...");
		return mongoTemplate;
	}
}
