package com.microservice.feedback.repository.mongo.secondary;

import com.common.mongo.secondary.Feedback;
import com.pattern.chassis.config.maria.DBInterface;

public interface FeedbackRepo extends DBInterface<Feedback> {
}