package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Game;
import com.service.GameServiceImpl;

@RestController
public class GameRestController {

	@Autowired
	private GameServiceImpl gameServiceImpl;
	

	@PostMapping("/begin")
	public Game beginGame(){
		return gameServiceImpl.createGame();
	}

	@GetMapping("/game/{id}")
	public Game findGame(@PathVariable Long id){
		return gameServiceImpl.findGame(id);
	}

	@GetMapping("/game")
	public Iterable<Game> listGames(){
		return gameServiceImpl.listGames();
	}
}
