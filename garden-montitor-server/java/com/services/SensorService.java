package com.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.model.Actuator;
import com.model.Command;
import com.model.Sensor;
import com.model.database.SensorRepository;

@Service
public class SensorService {
	
	
	@Autowired
	private SensorRepository sensorRepository;
	
	public void createSensor(Sensor sensor)
	{
		sensorRepository.save(sensor);
	}
	
	public Sensor getSensor(String name)
	{
		return sensorRepository.findByNameIgnoreCase(name);
	}
	public double getSensorReading(String name)
	{
		return sensorRepository.findByNameIgnoreCase(name).getValue();
	}
	public List<Sensor> getSensors() {
		List<Sensor>sensors = new ArrayList<>();
		sensorRepository.findAll().forEach(sensors::add);
		return sensors;
	}

	public void updateReading(String name, double value) {
		Sensor s = sensorRepository.findByNameIgnoreCase(name);
		s.setValue(value);
		sensorRepository.save(s);	
	}
	


}
