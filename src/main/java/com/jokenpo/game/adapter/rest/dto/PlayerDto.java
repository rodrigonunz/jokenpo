package com.jokenpo.game.adapter.rest.dto;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

	@JsonProperty("id")
	@JsonInclude(Include.NON_NULL)
	private String id;

	@NonNull
	@JsonProperty("name")
	private String name;

}
