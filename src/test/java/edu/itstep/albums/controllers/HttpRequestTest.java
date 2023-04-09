package edu.itstep.albums.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
   @Value(value="${local.server.port}")
   private int port;
   
   @Autowired
   private TestRestTemplate restTemplate;
   
   @Test
   void getHttpResponse()throws Exception{
	   assertThat(this.restTemplate.getForObject(
			   "http://localhost:"+port+"/api/v1/test",
			   String.class).contains("test Message"));
   }
}
