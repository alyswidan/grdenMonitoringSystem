package com.model.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.model.Bond;


@Service
public interface BondRepository extends CrudRepository<Bond, Long>{

}
