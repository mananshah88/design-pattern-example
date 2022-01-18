package com.pattern.chassis.config.mongo.primary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.pattern.chassis.config.mongo.NewAbstractMongoConfig;

@Configuration
@EnableMongoRepositories(basePackages = { "com.microservice.product.repository.mongo.primary" }, mongoTemplateRef = "PrimaryMongoTemplate")
public class PrimaryMongoConfig extends NewAbstractMongoConfig {

	@Value("${spring.custom.dbname}")
	String dbname;

	@Value("${spring.custom.uri}")
	String uri;

	@Primary
	@Bean(name = "PrimaryMongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory(dbname, uri));
		System.out.println("Primary MongoTemplate created...");
		return mongoTemplate;
	}
}
