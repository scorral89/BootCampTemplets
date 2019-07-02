package com.st.gameTesting.service;

import java.util.List;

import com.st.gameTesting.model.Game;

public interface GameServiceInt {
	public Game getGameByName(String name);
	public List<Game> getAllGames();

}
