package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="type_property_names")
public class TypePropertyName {
	
	private String name;
	@Id@GeneratedValue
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private CommandType type;
	
	


	public void setType(CommandType type) {
		this.type = type;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
