package com.jokenpo.game.adapter.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jokenpo.game.adapter.rest.dto.PlayerDto;
import com.jokenpo.game.domain.Player;

@Component
public class PlayerMapper implements MapperAdapter<Player, PlayerDto> {

	@Override
	public Player mapToModel(PlayerDto o) {
		return Player.builder().id(o.getId()).name(o.getName()).build();
	}

	@Override
	public PlayerDto mapToPortOut(Player t) {
		return PlayerDto.builder().id(t.getId()).name(t.getName()).build();
	}

	@Override
	public List<PlayerDto> mapToPortOutList(List<Player> t) {
		ArrayList<PlayerDto> list = new ArrayList<PlayerDto>();
		t.forEach(a -> list.add(mapToPortOut(a)));
		return list;
	}

}
