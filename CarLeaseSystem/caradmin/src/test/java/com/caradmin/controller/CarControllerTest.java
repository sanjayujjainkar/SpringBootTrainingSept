package com.caradmin.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.caradmin.entity.Car;
import com.caradmin.repo.CarRepository;
import com.caradmin.service.CarService;
import com.caradmin.service.CarServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest({ CarController.class })

@ActiveProfiles(value = "true")
public class CarControllerTest {
	
	private static final Logger LOGGER = LogManager.getLogger();


	@Autowired
	private MockMvc mockMVC;
	
	@TestConfiguration 
	static class CarServiceImplTestContextConfiguration {
		  @Bean 
		  public CarService carService() { 
			  return new CarServiceImpl();
		  }
	}
	  
	@MockBean
	private CarRepository repository;
	
	@Autowired 
	private CarService carService;
	 
	private List<Car> cars = new ArrayList<Car>();
	

	@Test
	public void testGetCar() throws Exception {
		cars.add(new Car(1, "BMW", "Sport", "1.0", 4, 1000, 1200));
		when(carService.getCars()).thenReturn(cars);
		ResultActions responseEntity = processAPIRequest("/admin/getCars", HttpMethod.GET, "admin123", "password");
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		LOGGER.info("API Response:"+result);
		JSONObject carJson = stringToJsonObj(result);
		assertEquals(carJson.get("make"), "BMW");
	}

	private ResultActions processAPIRequest(String api, HttpMethod methodType, String username, String password) {
		// TODO Auto-generated method stub
		ResultActions response = null;
		String secrete = "Basic" + Base64Utils.encodeToString((username + ":" + password).getBytes());
		try {
			switch (methodType) {
			case GET: {
				response = mockMVC.perform(get(api).with(user(username).password(password).roles("ADMIN")));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
	
	private JSONObject stringToJsonObj(String strJson) {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj = new JSONArray(strJson).getJSONObject(0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}

}
