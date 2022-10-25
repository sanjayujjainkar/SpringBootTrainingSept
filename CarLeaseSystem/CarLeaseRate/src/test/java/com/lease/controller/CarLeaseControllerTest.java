package com.lease.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.google.gson.Gson;
import com.lease.entity.CarUsageContract;

@RunWith(SpringRunner.class)
@WebMvcTest({CarLeaseRateController.class})
@ActiveProfiles(value="true")
public class CarLeaseControllerTest {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	
	@Autowired
	private MockMvc mockMVC;

	@Test
	public void testLeaseRateAPI() throws Exception {
		String strResponse = processAPIRequest("/lease/rate", HttpMethod.POST);
		JSONObject responseJson = new JSONObject(strResponse);
		assertEquals(responseJson.get("leaserate"), 239.82143);
	}
	
	private String processAPIRequest(String api, HttpMethod methodType) {
		// TODO Auto-generated method stub
		String strResponse="";
		try {
			switch (methodType) {
			case POST: {
				
				String url = "/lease/rate";
			    CarUsageContract anObject = new CarUsageContract(45000, 60, (float)4.5, 63000);
			    
			    Gson gson = new Gson();
			    String requestJson = gson.toJson(anObject);
			    
			    // Send request body
				RequestBuilder requestBuilder = MockMvcRequestBuilders
						.post(url)
						.accept(MediaType.APPLICATION_JSON).content(requestJson)
						.contentType(MediaType.APPLICATION_JSON);

			    MvcResult result = mockMVC.perform(requestBuilder)
			        .andExpect(status().isOk())
			        .andReturn();
			    
			    strResponse = result.getResponse().getContentAsString();
			    System.out.println(strResponse);
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
		return strResponse;
	}
	
}
