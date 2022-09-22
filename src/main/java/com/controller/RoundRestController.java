package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Round;
import com.service.RoundServiceImpl;

/**
 * Controller for rounds
 * @author benat
 *
 */
@RestController
public class RoundRestController {
	
	@Autowired
	private RoundServiceImpl roundServiceImpl;

	/**
	 * Guess the number requests a JSON as body (do this through Postman)
	 * @param round
	 * @return
	 */
	@PostMapping("/guess")
	public Round guess(@RequestBody Round round){
		return roundServiceImpl.createRound(round);
	}

	/**
	 * Find rounds by game id
	 * @param id
	 * @return
	 */
	@GetMapping("/rounds/{id}")
	public List<Round> findRounds(@PathVariable Long id){
		return roundServiceImpl.findRounds(id);
	}
}
