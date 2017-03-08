package com.model;

import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDS")
public class Command {
	
	@Id@GeneratedValue
	private long id;	
	private boolean isToBeSent;
	@ManyToOne
	@JoinColumn(name="type_id")
	private CommandType type;
	
	@OneToMany(mappedBy="command")
	private Set<CommandProperty> properties;
	

	public void setId(long id) {
		this.id = id;
	}
	public boolean isToBeSent() {
		return isToBeSent;
	}
	public void setToBeSent(boolean isToBeSent) {
		this.isToBeSent = isToBeSent;
	}
	
	public CommandType getType() {
		return type;
	}
	public void setType(CommandType type) {
		this.type = type;
	}

	public void setProperties(Set<CommandProperty> properties) {
		this.properties = properties;
	}
	public Set<CommandProperty> getProperties() {
		return properties;
	}
	
	

	
	



	
	
	
	
	
	
	
	
}
