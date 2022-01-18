package com.microservice.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customer.repository.maria.primary.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> sayHello() {
		StringBuilder sb = new StringBuilder().append("Maria Primary DB:: Count of Customer table::")
				.append(customerRepo.count());
		System.out.println(sb.toString());
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}

}
