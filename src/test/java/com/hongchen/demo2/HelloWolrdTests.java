package com.hongchen.demo2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class HelloWolrdTests {
	
	@Autowired
	private MockMvc mvc;

	@Test
	void test() throws Exception {
		mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("Hello World"));
		MvcResult result = mvc.perform(get("/new/user")).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		
	}

}
