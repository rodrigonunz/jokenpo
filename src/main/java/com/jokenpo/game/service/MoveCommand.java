package com.jokenpo.game.service;

import java.util.List;

import com.jokenpo.game.domain.Move;
import com.jokenpo.game.exception.EntityValidatorException;

public interface MoveCommand {
	
	Move add(Move p) throws EntityValidatorException;
	
	void remove(String id);
	
	List<Move> getAll();

}
