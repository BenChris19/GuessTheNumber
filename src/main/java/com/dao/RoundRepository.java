package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Round;

@Repository
public interface RoundRepository extends CrudRepository<Round, Long> {
	
	Round findById(long id);

}