package com.jokenpo.game.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jokenpo.game.domain.Game;
import com.jokenpo.game.domain.Move;
import com.jokenpo.game.domain.Player;
import com.jokenpo.game.persistence.port.PlayerPort;
import com.jokenpo.game.persistence.repository.MoveRepository;
import com.jokenpo.game.persistence.repository.PlayerRepository;
import com.jokenpo.game.service.GetResultCommand;

@Component
public class ResultCommandService implements GetResultCommand {

	@Autowired
	PlayerPort playerPort;
	
	@Autowired
	PlayerRepository pRepo;
	
	@Autowired
	MoveRepository mRepo;

	@Override
	public Game getResult() {
		List<Player> pAll = pRepo.getAll();
		List<Move> mAll = mRepo.getAll();
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("papel", Arrays.asList("spock", "pedra"));
		map.put("pedra", Arrays.asList("tesoura", "lagarto"));
		map.put("lagarto", Arrays.asList("papel", "spock"));
		map.put("tesoura", Arrays.asList("papel", "lagarto"));
		map.put("spock", Arrays.asList("tesoura", "pedra"));
		
		List<Move> winner = new ArrayList<Move>(mAll);
//		Collections.copy(winner, mAll);
		
		
		mAll.forEach(a -> {
			List<String> list = map.get(a.getComponent());
			list.forEach(y -> {
				winner.removeIf(f -> f.getComponent().toLowerCase().equals(y));				
			});
		});
			
		return Game.builder().moves(mAll).players(pAll).winner(winner.get(0)).build();
	}

}
