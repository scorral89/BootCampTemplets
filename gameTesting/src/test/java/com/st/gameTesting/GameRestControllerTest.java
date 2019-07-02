package com.st.gameTesting;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.st.gameTesting.model.Game;
import com.st.gameTesting.service.GameServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(GameRestControllerTest.class)

public class GameRestControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean 
	private GameServiceImpl service;

	@Test
	public void givenGames_thenReturnJsomArray() throws Exception {
		Game yahtzee = new Game("Yahtzee");
		
		List<Game> allGames = Arrays.asList(yahtzee);
		
		given(service.getAllGames()).willReturn(allGames);
		mvc.perform(get("/api/games")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is(yahtzee.getName()))
				
		);
	}

}
