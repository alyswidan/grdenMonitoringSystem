package com.model.database;

import org.springframework.data.repository.CrudRepository;

import com.model.Sensor;

public interface SensorRepository extends CrudRepository<Sensor, Long>{
	public Sensor findByNameIgnoreCase(String name);
}
