package com.caradmin.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;



@RunWith(SpringRunner.class)
@WebMvcTest({CarController.class})
@ActiveProfiles(value="true")
public class CarControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	
	@Test
	public void testEmployeeGet() throws Exception {
		ResultActions  responseEntity = processAPIRequest("/admin/getCars", HttpMethod.GET, "admin123", "password");
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("car details", result);
	}
	
	
	private ResultActions processAPIRequest(String api, HttpMethod methodType, String username, String password) {
		// TODO Auto-generated method stub
		ResultActions response = null;
		String secrete = "Basic" + Base64Utils.encodeToString((username+":"+password).getBytes());
		try {
			switch (methodType) {
			case GET: {
				response = mockMVC.perform(get(api).with(user(username).password(password).roles("ADMIN")));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}

	

}
