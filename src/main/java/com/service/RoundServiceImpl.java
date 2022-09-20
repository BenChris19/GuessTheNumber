package com.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoundRepository;
import com.model.Game;
import com.model.Round;

@Service
public class RoundServiceImpl implements RoundService {

	@Autowired
	private RoundRepository roundRepository;
	@Autowired
	private GameServiceImpl gameServiceImpl;

	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	@Override
	public Round createRound(Round round) {
		Game game = gameServiceImpl.findGame(round.getGameId());
		String answer = game.getAnswer();

		String result = this.calcResult(round.getGuess(), answer);
		
		round.setGameId(game.getGameId());
		round.setResult(result);
		round.setGuessTime(LocalDateTime.now());

		String wincondition = "e:4:p:0";
		if(result.equals(wincondition)){
			System.out.println("Game won");
			gameServiceImpl.finishGame(game.getGameId());
		}

		return roundRepository.save(round);
	}

	public String calcResult(int guess, String answer){
		String strguess = String.valueOf(guess);
		String stranswer = answer;

		int exact = 0;
		int partial = 0;
		for(int i = 0; i < strguess.length(); i++){
			if(stranswer.charAt(i) == strguess.charAt(i))
			{
				exact++;
			}
			else if(stranswer.contains(""+strguess.charAt(i))){
				partial++;
			}
		}
		String result = "e:" + exact + ":p:" + partial;
		System.out.println(result+"\n");

		return result;
	}
	@Override
	public List<Round> findRounds(Long id){
		List<Round> result = new ArrayList<>();
		for(Round round : roundRepository.findAll()){
			if(round.getGameId() == id){
				System.out.println(round+"\n");
				result.add(round);
			}
		}
		return result;
	}
}