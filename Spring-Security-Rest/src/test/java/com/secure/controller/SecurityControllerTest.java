package com.secure.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.secure.entity.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({SecurityController.class})
@ActiveProfiles(value="true")
public class SecurityControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Value ("${employee.get.url}")
	String getURL;
	
	@Value ("${employee.post.url}")
	String postURL;
	
	@Value ("${employee.put.url}")
	String putURL;
	
	@Value ("${employee.delete.url}")
	String deleteURL;
	
	@Value ("${user.user1.username}")
	String username1;
	
	@Value ("${user.user1.password}")
	String password1;
	
	@Value ("${admin.user1.username}")
	String admin_name1;
	
	@Value ("${admin.user1.password}")
	String admin_password1;
	
	@Test
	public void testEmployeeGet() throws Exception {
		ResultActions  responseEntity = processAPIRequest("/get", HttpMethod.GET, null, null,"user123", "password");
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("Get employee", result);
	}
	
	@Test
	public void testEmployeePOST() throws Exception {
		Employee employee = new Employee("test","dev");
		ResultActions  responseEntity = processAPIRequest(postURL, HttpMethod.POST, null, employee,admin_name1, admin_password1);
		responseEntity.andExpect(status().isOk());
		ObjectMapper objectMapper = new ObjectMapper();
		
		Employee result = objectMapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(), 
				new TypeReference<Employee>() {
		});
		assertEquals("test", result);
		assertEquals("dev", result);
	}
	
	private Employee createEmployee(String name, String role) {
		return null;
	}

	private ResultActions processAPIRequest(String api, HttpMethod methodType, String name, Employee employee,
			String username, String password) {
		// TODO Auto-generated method stub
		ResultActions response = null;
		String secrete = "Basic" + Base64Utils.encodeToString((username+":"+password).getBytes());
		try {
			switch (methodType) {
			case GET: {
				//response = mockMVC.perform(get(api).header(HttpHeaders.AUTHORIZATION, secrete));
				response = mockMVC.perform(get(api).with(user(username).password(password).roles("USER")));
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
