package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Round;

/**
 * Repositories for all rounds
 * @author benat
 *
 */
@Repository
public interface RoundRepository extends CrudRepository<Round, Long> {
	
	Round findById(long id);

}