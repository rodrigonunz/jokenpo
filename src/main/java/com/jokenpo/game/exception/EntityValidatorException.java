package com.jokenpo.game.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"suppressed", "localizedMessage", "cause", "stackTrace"})
public class EntityValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityValidatorException(String message) {
		super(message);
	}
	
	@Override
	@JsonProperty("message")
	public String getMessage() {
		return super.getMessage();
	}

}
