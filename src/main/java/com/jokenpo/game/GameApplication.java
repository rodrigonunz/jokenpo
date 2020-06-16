package com.jokenpo.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jokenpo.game.persistence.CachedJokenpo;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
		CachedJokenpo.runCache();
	}

}
