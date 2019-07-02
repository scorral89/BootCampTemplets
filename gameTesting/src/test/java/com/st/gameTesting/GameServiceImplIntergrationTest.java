package com.st.gameTesting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.gameTesting.model.Game;
import com.st.gameTesting.repository.GameRepository;
import com.st.gameTesting.service.GameServiceImpl;
import com.st.gameTesting.service.GameServiceInt;

@RunWith(SpringRunner.class)
public class GameServiceImplIntergrationTest {
	@TestConfiguration
	static class GameServiceImplTestContextConfiguration {
		@Bean
		public GameServiceInt gameService() {
			return new GameServiceImpl();
		}
	}
	@Autowired
	private GameServiceInt gameService;
	
	@MockBean
	private GameRepository gameRepository;
	@Before
	public void setUp() {
		Game sorry= new Game("Sorry");
		Mockito.when(gameRepository.findGameByName(sorry.getName())).thenReturn(sorry);
	}
	@Test 
	public void whenBalidName_thenGameShouldBeFound() {
		String name = "Sorry";
		Game foundGame= gameService.getGameByName(name);
		assertThat(foundGame.getName()).isEqualTo(name); 
	}
}
