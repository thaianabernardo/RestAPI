package com.thaiana.restapi;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RestAPIApplication.class })
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TerminalControllerTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mvc;

	@BeforeAll
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void postTerminalTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.post("/v1/terminal")
				.content("44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN")
				.contentType(MediaType.TEXT_HTML_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
