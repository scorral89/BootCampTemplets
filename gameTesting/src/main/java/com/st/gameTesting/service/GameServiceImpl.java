package com.st.gameTesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.gameTesting.model.Game;
import com.st.gameTesting.repository.GameRepository;

@Service
public class GameServiceImpl implements GameServiceInt{
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public Game getGameByName(String name)
	{
		return gameRepository.findGameByName(name);
	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

}
