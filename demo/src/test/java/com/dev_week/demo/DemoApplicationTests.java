package com.dev_week.demo;

import com.dev_week.demo.controller.ControllerRegiao;
import com.dev_week.demo.entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	private final String URL = "/api/regiao";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ControllerRegiao controller;

	@Test
	void getControllerTest() throws Exception{
		mockMvc.perform(get(URL)).andExpect(status().isOk());
	}


	@Test
	void getByIdControllerTest() throws Exception{
		mockMvc.perform(get(URL + "/1")).andExpect(status().isOk());
	}

	
	@Test
	void addNewRegionTest() throws Exception{
		Regiao newRegiaoTest = new Regiao(9l, "Noroeste", 57);
		mockMvc.perform(post(URL+"/novo")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(newRegiaoTest)))
		.andExpect(status().isOk());		
	}

	@Test
	void deleteByIdRegiaoTest() throws Exception{
		mockMvc.perform(delete(URL+"/delete/{id}", "14") //apesar de ter usado 9L no post, aqui não precisa do L
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	

	@Test
	public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
