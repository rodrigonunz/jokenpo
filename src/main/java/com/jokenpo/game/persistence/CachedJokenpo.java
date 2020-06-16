package com.jokenpo.game.persistence;

import java.util.ArrayList;

import com.jokenpo.game.data.GameData;

public class CachedJokenpo {

	public static GameData gameData;
	
	public static void runCache() {
		gameData = GameData.builder().moves(new ArrayList<>()).players(new ArrayList<>()).build();
	}

}
