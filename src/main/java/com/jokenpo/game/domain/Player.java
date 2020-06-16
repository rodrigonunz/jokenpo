package com.jokenpo.game.domain;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Player {
	
	private String id;
	private String name;
	
	public void prepareUUID() {
		if (this.id == null)
			this.id = UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
