package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Command;
import com.model.CommandType;
import com.model.Sensor;
import com.model.database.CommandRepository;
import com.model.database.CommandTypeRepository;
import com.model.database.SensorRepository;
@Service
public class CommandService {
	
	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private CommandTypeRepository commandTypeRepository;

	public void createCommand(Command command) {
		commandRepository.save(command);
	}
	
	public void createCommandType(CommandType commandType)
	{
		
	}
	
	public List<CommandType> getTypes() {
		List<CommandType> types = new ArrayList<>();
		commandTypeRepository.findAll().forEach(types::add);
		return types;
	}
	public List<Command> getCommands() {
		List<Command> commands = new ArrayList<>();
		commandRepository.findAll().forEach(commands::add);
		return commands;
	}

}
