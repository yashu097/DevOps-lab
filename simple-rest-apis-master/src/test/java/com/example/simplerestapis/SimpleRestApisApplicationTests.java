package com.example.simplerestapis;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.simplerestapis.controller.WebController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRestApisApplicationTests {

	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@MockBean
	private WebController webController;
	
	@Before
	public void setup() {
		mockMvc =MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	public void contextLoads() {
	}
	
	@Test
	public void getMethodTestCase(){
		HttpHeaders header = new HttpHeaders();
		String name ="abc";
		
		try {
			mockMvc.perform(get("/sample/{name}",name).headers(header)).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
