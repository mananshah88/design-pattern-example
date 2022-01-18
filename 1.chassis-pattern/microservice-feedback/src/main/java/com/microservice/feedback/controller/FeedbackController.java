package com.microservice.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.feedback.repository.mongo.secondary.FeedbackRepo;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackRepo feedbackRepo;

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> sayHello() {
		StringBuilder sb = new StringBuilder().append("Mongo Secondary DB:: Count of Feedback collection::")
				.append(feedbackRepo.count());
		System.out.println(sb.toString());
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}

}
