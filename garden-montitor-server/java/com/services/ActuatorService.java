package com.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.model.Actuator;
import com.model.Bond;
import com.model.Command;
import com.model.Sensor;
import com.model.database.ActuatorRepository;
import com.model.database.SensorRepository;

@Service
public class ActuatorService {
	@Autowired
	private ActuatorRepository actuatorRepository;
	

	
	public void createActuator(Actuator actuator)
	{
		actuatorRepository.save(actuator);
	}
	public List<Actuator> getActuators() {
		List<Actuator>actuators = new ArrayList<>();
		actuatorRepository.findAll().forEach(actuators::add);
		return actuators;
	}
	
	public Set<Actuator>getSubscribers(long id){
		return actuatorRepository.findAllSubscribingActuators(id);
	}
	public boolean isToBeSent(String name)
	{
		actuatorRepository.findByNameIgnoreCase(name);
		return true;
	}
	public List<Map<String,Command>>getIssuedCommands(long id)
	{
		return actuatorRepository.findAllIssuedCommandsToSubscribers(id);
		
	}
}
