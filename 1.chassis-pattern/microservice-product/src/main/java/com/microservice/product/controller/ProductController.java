package com.microservice.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product.repository.mongo.primary.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> sayHello() {
		StringBuilder sb = new StringBuilder().append("Mongo Primary DB:: Count of Product collection::")
				.append(productRepo.count());
		System.out.println(sb.toString());
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}

}
