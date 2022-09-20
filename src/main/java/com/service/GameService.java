package com.service;

import com.model.Game;

public interface GameService {

	Game createGame();
	
	Game findGame(Long id);

	Iterable<Game> listGames();
	
	Game finishGame(Long id);
}
