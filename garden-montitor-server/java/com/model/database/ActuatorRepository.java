package com.model.database;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Actuator;
import com.model.Command;
import com.model.Sensor;
@Repository
public interface ActuatorRepository extends CrudRepository<Actuator, Long>{
	public Sensor findByNameIgnoreCase(String name);
	
	
	@Query("select a from Bond b join b.actuator a where b.sensor.id=:id")
	public Set<Actuator>findAllSubscribingActuators(@Param(value = "id")long id);
	
	@Query("select new map(b.actuator,b.minCommand) from Bond b join b.sensor join b.minCommand where b.sensor.id=:id and (b.minCommand.isToBeSent=true or b.maxCommand.isToBeSent=true)")
	public List<Map<String,Command>>findAllIssuedCommandsToSubscribers(@Param(value = "id")long id);

}
