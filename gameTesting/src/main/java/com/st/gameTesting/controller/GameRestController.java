package com.st.gameTesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.gameTesting.model.Game;
import com.st.gameTesting.service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameRestController {
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> getAllGames(){
		return gameServiceImpl;
	}
	

}
