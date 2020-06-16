package com.jokenpo.game.adapter.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameResultDto {
	
	@JsonProperty("moves")
	private List<MoveDto> moves;
	
	@JsonProperty("players")
	private List<PlayerDto> players;
	
	@JsonProperty("winner")
	private MoveDto winner;
	
	

}
