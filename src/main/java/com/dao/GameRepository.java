package com.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Game;

/**
 * Repository for all games
 * @author benat
 *
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long>   {
    
	Game findById(long id);

}