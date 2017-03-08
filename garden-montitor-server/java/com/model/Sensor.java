package com.model;

import java.util.Observable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SENSORS")
public class Sensor extends Observable{
	private String name;
	
	@Id@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy="sensor")
	Set<Bond>bonds;
	
	private double value;

	
	public Sensor(){}
	public Sensor(String name, long id, double value) {
		this.name = name;
		this.id = id;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getId(){return this.id;}
	public void setId(long id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
}
