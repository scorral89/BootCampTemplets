package com.gt.saturdayThrashing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(
	webEnvironment = WebEnvironment.MOCK,
	classes = SaturdayThrashingApplication.class
)
@TestPropertySource(
	locations = "classpath:applicationintegrationtest.properties" 
)

public class SaturdayThrashingIntegrationTests {
	@Autowired
	private MockMvc mvc;
	

	@Test
	public void getIndexPage_returnsHtmlAnd200Status() throws Exception {
		mvc.perform(
			get("/").contentType(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}

}
