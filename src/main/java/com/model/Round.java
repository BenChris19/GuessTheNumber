package com.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
/**
 * Store all info for rounds
 * @author benat
 *
 */
public class Round {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roundId;
	private Long gameId;
	private int guess;
	private String result;
	private LocalDateTime guessTime;
}