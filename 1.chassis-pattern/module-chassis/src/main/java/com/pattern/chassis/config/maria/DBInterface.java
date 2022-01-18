package com.pattern.chassis.config.maria;

import org.springframework.data.repository.CrudRepository;

public interface DBInterface<T> extends CrudRepository<T, Integer>{

}
