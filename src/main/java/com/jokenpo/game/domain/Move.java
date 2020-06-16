package com.jokenpo.game.domain;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Move {

	private String id;

	private Player player;

	private String component;

	public void addPlayer(Player p) {
		this.player = p;
	}

	public void prepareUUID() {
		if (this.id == null)
			this.id = "move----" + UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
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
		Move other = (Move) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}
	
	
	
}
