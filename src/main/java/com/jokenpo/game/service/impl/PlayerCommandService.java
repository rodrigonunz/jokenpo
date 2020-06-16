package com.jokenpo.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jokenpo.game.domain.Player;
import com.jokenpo.game.persistence.port.PlayerPort;
import com.jokenpo.game.service.PlayerCommand;

@Component
public class PlayerCommandService implements PlayerCommand {

	@Autowired
	PlayerPort playerPort;

	@Override
	public Player add(Player p) {

		p.prepareUUID();

		return playerPort.insert(p);
	}

	@Override
	public void remove(String id) {
		playerPort.deleteFromId(id);
	}

	@Override
	public List<Player> getAll() {
		return playerPort.getAll();
	}

}
