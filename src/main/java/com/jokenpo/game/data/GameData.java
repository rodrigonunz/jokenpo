package com.jokenpo.game.data;

import java.util.List;

import com.jokenpo.game.domain.Move;
import com.jokenpo.game.domain.Player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//Entity simulating database
public class GameData {

	private List<Move> moves;
	private List<Player> players;

}
