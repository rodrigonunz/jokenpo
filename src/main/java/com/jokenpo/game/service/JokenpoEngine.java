package com.jokenpo.game.service;

import java.util.List;

import com.jokenpo.game.domain.Move;
import com.jokenpo.game.domain.Player;

public interface JokenpoEngine {
	
	Player getWinner(List<Move> moves);
	
}
