package com.st.gameTesting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.gameTesting.model.Game;
import com.st.gameTesting.repository.GameRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GameRepositoryIntegratedTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private GameRepository gameRepository;

	@Test
	public void whenFindGameByName_thenReturnGame() {
		// given
		Game scrabble = new Game("Scrabble");
		entityManager.persist(scrabble);
		entityManager.flush();
		
		//when
		String nameOfGame = scrabble.getName();
		Game foundGame= gameRepository.findGameByName(nameOfGame);
		//then
		assertThat(foundGame.getName()).isEqualTo(nameOfGame);
	}
	
	@Test
	public void whenFindGameById_thenReturnGame() {
		
		Game uno = new Game("Uno");
		entityManager.persistAndFlush(uno);
		
		Game foundGame= gameRepository.findGameById(uno.getId());
		
		assertThat(foundGame.getId()).isEqualTo(uno.getId());

	}

}
