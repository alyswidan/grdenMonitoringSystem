package com.controllers;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Actuator;
import com.model.Bond;
import com.model.Command;
import com.model.CommandType;
import com.model.Sensor;
import com.services.ActuatorService;
import com.services.BondService;
import com.services.CommandService;
import com.services.SensorService;


@RequestMapping("/client")
@RestController
public class ClientController {
	
	@Autowired
	public SensorService sensorService;
	@Autowired
	public ActuatorService actuatorService;
	@Autowired
	public BondService bondService;
	@Autowired
	public CommandService commandService;
	
	//Client Routes
	
	//sensors
	@GetMapping("/sensors")
	public List<Sensor> getSensorNames(){return sensorService.getSensors();}
	
	@GetMapping("/sensors/{name}")
	public double getSensorReading(@PathVariable String name){return sensorService.getSensorReading(name);}
	
	@PostMapping("/sensors")
	public void createSensor(@RequestBody Sensor sensor){	sensorService.createSensor(sensor);   }
	//end sensors

	//actuators
	@GetMapping("/actuators")
	public List<String> getActuatorNames(){return actuatorService.getActuators().stream().map(actuator->actuator.getName()).collect(Collectors.toList());}
	
	@PostMapping("/actuators")	
	public void createActuator(@RequestBody Actuator actuator){actuatorService.createActuator(actuator);}
	//end actuators
	//bonds
	@GetMapping("/bonds")
	public List<Bond> getBonds(){return bondService.getBonds();}
	
	@PostMapping("/bonds")
	public void createSensor(@RequestBody Bond bond){bondService.createBond(bond);}
	//end bonds
	
	//commands
	@GetMapping("commands")
	public List<Command> getCommands(){return commandService.getCommands();}

	@PostMapping("commands")	
	public void createCommand(@RequestBody Command command){commandService.createCommand(command);}

	@GetMapping("/commands/types")
	public List<CommandType> getTypes(){return commandService.getTypes();}
	//end commands
	
	//end Client Routes
	
	


}
