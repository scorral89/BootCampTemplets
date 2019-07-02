package com.st.gameTesting;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.st.gameTesting.model.Game;
import com.st.gameTesting.repository.GameRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		w
		ebEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes= GameTestingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties"
		)

public class GameRestControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private GameRepository gameRepository;

	@Test
	public void givenGamesWhenGetGames_thenStatus200()
	throws Exception {
		Game jenga = new Game("Jenga");
		gameRepository.save(jenga);
		
		mvc.perform(get("/api/Games")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("$[0].name", is("Jengo")));
				
		
	}

}
