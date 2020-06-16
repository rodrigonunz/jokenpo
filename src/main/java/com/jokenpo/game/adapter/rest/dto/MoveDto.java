package com.jokenpo.game.adapter.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoveDto {
	
	@JsonProperty("player-id")
	private String playerId;
	
	@JsonProperty("component")
	private String component;
	
	

}
