package com.jokenpo.game.service;

import java.util.List;

import com.jokenpo.game.domain.Player;

public interface PlayerCommand {
	
	Player add(Player p);
	
	void remove(String id);
	
	List<Player> getAll();

}
