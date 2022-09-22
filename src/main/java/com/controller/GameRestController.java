package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Game;
import com.service.GameServiceImpl;

/**
 * Controller for game
 * @author benat
 *
 */
@RestController
public class GameRestController {

	@Autowired
	private GameServiceImpl gameServiceImpl;
	

	/**
	 * Begin the game with an exclusive id and a random number as answer
	 * @return
	 */
	@PostMapping("/begin")
	public Game beginGame(){
		return gameServiceImpl.createGame();
	}

	/**
	 * Find a game by id
	 * @param id
	 * @return
	 */
	@GetMapping("/game/{id}")
	public Game findGame(@PathVariable Long id){
		return gameServiceImpl.findGame(id);
	}

	/**
	 * Find all the current games
	 * @return
	 */
	@GetMapping("/game")
	public Iterable<Game> listGames(){
		return gameServiceImpl.listGames();
	}
}
