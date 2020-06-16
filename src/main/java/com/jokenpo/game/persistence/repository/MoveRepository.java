package com.jokenpo.game.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jokenpo.game.domain.Move;
import com.jokenpo.game.persistence.CachedJokenpo;
import com.jokenpo.game.persistence.port.MovePort;

@Component
public class MoveRepository implements MovePort {

	@Override
	public void deleteFromId(String id) {
		CachedJokenpo.gameData.getMoves().removeIf(a -> a.getId().equals(id));
	}

	@Override
	public Move insert(Move p) {
		Optional<Move> findFirst = CachedJokenpo.gameData.getMoves().stream().filter(a -> a.getPlayer().getId().equals(p.getPlayer().getId())).findFirst();
		if(findFirst.isPresent())
			CachedJokenpo.gameData.getMoves().remove(findFirst.get());
		
		CachedJokenpo.gameData.getMoves().add(p);
		return p;
	}

	@Override
	public List<Move> getAll() {
		return CachedJokenpo.gameData.getMoves();
	}

}
