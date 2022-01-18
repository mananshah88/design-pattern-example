package com.microservice.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.purchase.repository.maria.secondary.PurchaseRepo;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	PurchaseRepo purchaseRepo;

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> sayHello() {
		StringBuilder sb = new StringBuilder().append("Maria Secondary DB:: Count Of Purchase table::")
				.append(purchaseRepo.count());
		System.out.println(sb.toString());
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}

}
