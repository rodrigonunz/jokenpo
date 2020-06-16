package com.jokenpo.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jokenpo.game.domain.Move;
import com.jokenpo.game.domain.Player;
import com.jokenpo.game.exception.EntityValidatorException;
import com.jokenpo.game.persistence.port.MovePort;
import com.jokenpo.game.persistence.port.PlayerPort;
import com.jokenpo.game.service.MoveCommand;

@Component
public class MoveCommandService implements MoveCommand {

	@Autowired
	MovePort movePort;
	
	@Autowired
	PlayerPort playerPort;

	@Override
	public Move add(Move p) throws EntityValidatorException {
		p.prepareUUID();
		
		Player pl = playerPort.get(p.getPlayer().getId());
		if(pl == null)
			throw new EntityValidatorException("O player não foi encontrado");
		
		p.addPlayer(pl);
		
		return movePort.insert(p);
	}

	@Override
	public void remove(String id) {
		movePort.deleteFromId(id);
	}

	@Override
	public List<Move> getAll() {
		return movePort.getAll();
	}



}
