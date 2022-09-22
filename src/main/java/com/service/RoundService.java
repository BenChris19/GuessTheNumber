package com.service;

import java.util.List;

import com.model.Round;

/**
 * Service interface for rounds
 * @author benat
 *
 */
public interface RoundService {

	Round createRound(Round round);

    List<Round> findRounds(Long id);
}
