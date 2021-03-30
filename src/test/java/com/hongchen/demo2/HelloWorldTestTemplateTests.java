package com.hongchen.demo2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 使用TestRestTemplate测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloWorldTestTemplateTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void test() {
		String body = this.restTemplate.getForObject("/hello", String.class);
		System.out.println(body);
	}

}
