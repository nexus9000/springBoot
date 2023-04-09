package edu.itstep.albums.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  void getResponseMessage()throws Exception{
	  this.mockMvc.perform(
			  get("/api/v1/test")).andDo(
					  print()
					  ).andExpect(status().isOk()).andExpect(
							  content().string(containsString("test Message")));
  }
  
  @Test
  void checkPersonId()throws Exception{
	  this.mockMvc.perform(get(
			  "/api/v1/persons/id/999"))
	  .andDo(print()).andExpect(status().is4xxClientError());
  }
}
