package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACTUATORS")
public class Actuator implements Observer{
	private String name;
	
	@Id@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy="actuator")
	Set<Bond>bonds;
	
	public Actuator(){
	}
	public Actuator(String name){
		this();
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public int hashCode() {

		return (int) (this.id % 1e9+7);
	}
	
	

}
