package com.jokenpo.game.adapter.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jokenpo.game.adapter.rest.dto.MoveDto;
import com.jokenpo.game.domain.Move;
import com.jokenpo.game.domain.Player;

@Component
public class MoveMapper implements MapperAdapter<Move, MoveDto> {

	@Override
	public MoveDto mapToPortOut(Move t) {
		return MoveDto.builder().playerId(t.getPlayer().getId()).component(t.getComponent()).build();
	}

	@Override
	public List<MoveDto> mapToPortOutList(List<Move> t) {
		ArrayList<MoveDto> list = new ArrayList<MoveDto>();
		t.forEach(a -> list.add(mapToPortOut(a)));
		return list;
	}

	@Override
	public Move mapToModel(MoveDto o) {
		return Move.builder().player(Player.builder().id(o.getPlayerId()).build()).component(o.getComponent()).build();
	}

}
