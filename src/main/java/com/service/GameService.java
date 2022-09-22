package com.service;

import com.model.Game;

/**
 * Interface for game service
 * @author benat
 *
 */
public interface GameService {

	Game createGame();
	
	Game findGame(Long id);

	Iterable<Game> listGames();
	
	Game finishGame(Long id);
}
