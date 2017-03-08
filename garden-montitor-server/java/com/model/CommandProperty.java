package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMAND_PROPERTIES")
public class CommandProperty {
	
	private String name;
	private double value;
	@Id@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="command_id")
	private Command command;
	
	

	public void setCommand(Command command) {
		this.command = command;
	}

	public void setId(long id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
