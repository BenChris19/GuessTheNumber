package com.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GameRepository;
import com.model.Game;

/**
 * Implementation for game service
 * @author benat
 *
 */
@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GameRepository gameRepository;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	Random rng = new Random();

	/**
	 * Create a game
	 */
	@Override
	public Game createGame() {
		Game game = new Game();

		game.setFinished(false);

		game.setAnswer(this.generateAnswer());

		return gameRepository.save(game);
	}

	/**
	 * Find a game by if
	 * @param id
	 */
	@Override
	public Game findGame(Long id){
		if(gameRepository.findById(id).isPresent()){
			Game game = gameRepository.findById(id).get();
			Game gameWithAnswer = !game.isFinished() ? new Game(game.getGameId(),null,game.isFinished()):game;
			System.out.println(gameWithAnswer);
			return game;
		}
		return null;
	}

	/**
	 * List all of the games
	 */
	@Override
    public Iterable<Game> listGames() {
		Iterable<Game> games = gameRepository.findAll();
		for(Game game : games){
			Game gameWithAnswer = !game.isFinished() ? new Game(game.getGameId(),null,game.isFinished()):game;
			System.out.println(gameWithAnswer);
		}
		return games;
    }

	/**
	 * Generate a random 4 digit exclusive digit number
	 * @return
	 */
	public String generateAnswer(){
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4 , 5, 6, 7, 8, 9));
		String answer = "";
		for(int i = 0; i < 4; i++){
			int index;
			if(i==0){
				index = rng.nextInt(1,nums.size());
			}
			else{
				index = rng.nextInt(nums.size());
			}
			int num = nums.get(index);
			nums.remove(index);
			answer += num;
		}
		return answer;
	}

	/**
	 * Game has been won, change to game finish
	 * @param id
	 */
	public Game finishGame(Long id) {
		Game game = this.findGame(id);
		game.setFinished(true);
		System.out.print("^\n"
				+ "|\n"
				+ "|\n"
				+ "Answer: "+game.getAnswer()+"\n");
		return gameRepository.save(game);
	}
}