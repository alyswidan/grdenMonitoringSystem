package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.model.Actuator;
import com.model.Bond;
import com.model.database.BondRepository;

@Service
public class BondService {
	
	@Autowired
	private BondRepository bondRepository;
	
	
	public void createBond(Bond bond)
	{
		bondRepository.save(bond);
	}
	public List<Bond> getBonds() {
		List<Bond>bonds = new ArrayList<>();
		bondRepository.findAll().forEach(bonds::add);
		return bonds;
	}
	
	
}
