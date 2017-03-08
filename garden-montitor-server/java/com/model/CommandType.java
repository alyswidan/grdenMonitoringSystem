package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMAND_TYPES")
public class CommandType {
	
	
	private String name;
	@Id@GeneratedValue
	private long id;
	@OneToMany(mappedBy="type")
	private Set<TypePropertyName> properties;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setProperties(Set<TypePropertyName> properties) {
		this.properties = properties;
	}

	public Set<TypePropertyName> getProperties() {
		return properties;
	}

	
	
}
