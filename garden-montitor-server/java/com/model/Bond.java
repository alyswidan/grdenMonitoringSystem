package com.model;

import java.util.function.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="BONDS")
public class Bond {
	
	@Id@GeneratedValue
	private long id;
	
	private double min,max;
	@ManyToOne
	private Sensor sensor;
	@ManyToOne
	private Actuator actuator;
	@OneToOne
	@JoinColumn(name="min_id",unique=true)
	private Command minCommand;
	@OneToOne
	@JoinColumn(name="max_id",unique=true)
	private Command maxCommand;
	
	
	
	public Bond(){}
	
	public Bond(double min, double max, Sensor sensor) {
		this.min = min;
		this.max = max;
		this.sensor = sensor;
	}

	public double getMin() {
		return min;
	}
	
	public void setMin(double min) {
		this.min = min;
	}
	
	public double getMax() {
		return max;
	}
	
	public void setMax(double max) {
		this.max = max;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	
	public Actuator getActuator() {
		return actuator;
	}

	public void setActuator(Actuator actuator) {
		this.actuator = actuator;
	}

	public Command getMinCommand() {
		return minCommand;
	}
	
	public void setMinCommand(Command minCommand) {
		this.minCommand = minCommand;
	}

	public Command getMaxCommand() {
		return maxCommand;
	}

	public void setMaxCommand(Command maxCommand) {
		this.maxCommand = maxCommand;
	}

	
	

	

	
	
	
	
	
}
