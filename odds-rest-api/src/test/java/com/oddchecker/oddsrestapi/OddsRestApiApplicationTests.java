package com.oddchecker.oddsrestapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddchecker.oddsrestapi.controller.OddController;
import com.oddchecker.oddsrestapi.dao.OddRepository;
import com.oddchecker.oddsrestapi.entity.Odd;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= OddsRestApiApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OddsRestApiApplicationTests {

	
	private static final ObjectMapper om=new ObjectMapper();
	
	@Autowired
	MockMvc mockMvc;	
	
	@MockBean
	private OddRepository mockRepository;
	
	@Test
	public void contextLoads() throws Exception {
	
		String bookInJson="{\"odds\":\"ABC\"}";
		
		mockMvc.perform(post("/api/odds")
				.content(bookInJson)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.timestamp", is(notNullValue())))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.errors", hasItem("Please provide an user id")))
                .andExpect(jsonPath("$.errors", hasItem("Wrong odds format")));
	
				verify(mockRepository, times(0)).save(any(Odd.class));

	}
	

}
