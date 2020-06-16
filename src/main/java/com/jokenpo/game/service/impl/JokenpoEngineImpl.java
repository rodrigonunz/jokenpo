package com.jokenpo.game.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jokenpo.game.domain.Move;
import com.jokenpo.game.domain.Player;
import com.jokenpo.game.service.JokenpoEngine;

@Component
public class JokenpoEngineImpl implements JokenpoEngine {

	@Override
	public Player getWinner(List<Move> moves) {
		
		return null;
	}

}
