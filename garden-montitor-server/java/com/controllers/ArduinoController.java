package com.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Actuator;
import com.model.Command;
import com.model.Sensor;
import com.services.ActuatorService;
import com.services.BondService;
import com.services.CommandService;
import com.services.SensorService;

@RequestMapping("arduino")
@RestController
public class ArduinoController {
	@Autowired
	public SensorService sensorService;
	@Autowired
	public ActuatorService actuatorService;
	@Autowired
	public BondService bondService;
	@Autowired
	public CommandService commandService;
	
	//garden controller routes
	//controller sends a sensor readings then asks the server if this readings caused any commands to be issued 
	//if it caused commands to be issued the server sends a json of pairs (actuator,command) back to the controller 
	
	//sensors
	@PutMapping("/sensors/{name}")
	public void updateSensorReading(@RequestBody double value,@PathVariable String name){sensorService.updateReading(name,value);}
	
	//end sensors
	
	//commands
	
	//get commands issued to all actuators subscribing to the given sensor
	@GetMapping("/commands/{sensorName}")
	public Set<Actuator>getCommands(@PathVariable String sensorName)
	{
		long id = sensorService.getSensor(sensorName).getId();
		return actuatorService.getSubscribers(id);
	}
	@GetMapping("/commands/issued/{sensorName}")
	public List<Map<String,Command>> getIssuedCommands(@PathVariable String sensorName)
	{
		long id = sensorService.getSensor(sensorName).getId();
		return actuatorService.getIssuedCommands(id);
		
	}
	
	//end commands
	
	


}
