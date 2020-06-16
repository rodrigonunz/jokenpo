package com.jokenpo.game.persistence.port;

import java.util.List;

import com.jokenpo.game.domain.Move;

public interface MovePort {
	
	void deleteFromId(String id);
	
	Move insert(Move p);
	
	List<Move> getAll();

}
