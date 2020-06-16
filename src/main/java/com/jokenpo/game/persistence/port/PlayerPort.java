package com.jokenpo.game.persistence.port;

import java.util.List;

import com.jokenpo.game.domain.Player;

public interface PlayerPort {
	
	void deleteFromId(String id);
	
	Player get(String id);
	
	Player insert(Player p);
	
	List<Player> getAll();

}
