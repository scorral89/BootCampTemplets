package com.st.gameTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.gameTesting.model.Game;

@Repository
public interface GameRepository  extends JpaRepository<Game, Long>{
	public Game findGameByName(String name);
	public Game findGameById(Long id);

}