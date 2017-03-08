package com.model.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.model.Command;


@Service
public interface CommandRepository extends CrudRepository<Command, Long>{

}
