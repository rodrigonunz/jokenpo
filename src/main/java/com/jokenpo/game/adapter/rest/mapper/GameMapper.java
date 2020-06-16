package com.jokenpo.game.adapter.rest.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jokenpo.game.adapter.rest.dto.GameResultDto;
import com.jokenpo.game.adapter.rest.dto.MoveDto;
import com.jokenpo.game.domain.Game;

@Component
public class GameMapper implements MapperAdapter<Game, GameResultDto> {
	
	@Autowired
	MoveMapper moveMapper;
	
	@Autowired
	PlayerMapper playerMapper;

	@Override
	public Game mapToModel(GameResultDto o) {
		return null;
	}

	@Override
	public GameResultDto mapToPortOut(Game t) {
		return GameResultDto.builder().winner(
				MoveDto.builder()
				.component(t.getWinner().getComponent())
				.playerId(t.getWinner().getPlayer().getId()).build())
				.moves(moveMapper.mapToPortOutList(t.getMoves()))
				.players(playerMapper.mapToPortOutList(t.getPlayers()))
				.build();
	}

	@Override
	public List<GameResultDto> mapToPortOutList(List<Game> t) {
		return null;
	}

}
