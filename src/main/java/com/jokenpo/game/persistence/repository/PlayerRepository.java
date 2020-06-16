package com.jokenpo.game.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jokenpo.game.domain.Player;
import com.jokenpo.game.persistence.CachedJokenpo;
import com.jokenpo.game.persistence.port.PlayerPort;

@Component
public class PlayerRepository implements PlayerPort {

	@Override
	public void deleteFromId(String id) {
		CachedJokenpo.gameData.getPlayers().removeIf(a -> a.getId().equals(id));
	}

	@Override
	public Player insert(Player p) {
		CachedJokenpo.gameData.getPlayers().add(p);
		return p;
	}

	@Override
	public List<Player> getAll() {
		return CachedJokenpo.gameData.getPlayers();
	}

	@Override
	public Player get(String id) {
		return CachedJokenpo.gameData.getPlayers().stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
	}
	

}
