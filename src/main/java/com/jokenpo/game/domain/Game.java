package com.jokenpo.game.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Game {

	private List<Move> moves;
	private List<Player> players;
	private Move winner;
	
	

}
