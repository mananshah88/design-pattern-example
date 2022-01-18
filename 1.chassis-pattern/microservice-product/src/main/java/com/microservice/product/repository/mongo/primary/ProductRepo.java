package com.microservice.product.repository.mongo.primary;

import com.common.mongo.primary.Product;
import com.pattern.chassis.config.maria.DBInterface;

public interface ProductRepo extends DBInterface<Product> {
}