package com.pattern.chassis.config.mongo.secondary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.pattern.chassis.config.mongo.NewAbstractMongoConfig;

@Configuration
@EnableMongoRepositories(basePackages = { "com.microservice.feedback.repository.mongo.secondary" }, mongoTemplateRef = "SecondaryMongoTemplate")
public class SecondaryMongoConfig extends NewAbstractMongoConfig {

	@Value("${spring.custom.dbname}")
	String dbname;

	@Value("${spring.custom.uri}")
	String uri;

	@Bean(name = "SecondaryMongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory(dbname, uri));
		System.out.println("Secondary MongoTemplate created...");
		return mongoTemplate;
	}
}
