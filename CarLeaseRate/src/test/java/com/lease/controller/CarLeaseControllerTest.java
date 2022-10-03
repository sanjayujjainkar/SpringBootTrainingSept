package com.lease.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.bouncycastle.asn1.anssi.ANSSIObjectIdentifiers;
import org.json.JSONException;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

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
		ResultActions  responseEntity = processAPIRequest("/lease/rate", HttpMethod.POST);
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		System.out.println("Response received is :" + result);
		assertEquals(result, ObjectToJsonString());
	}
	
	private ResultActions processAPIRequest(String api, HttpMethod methodType) {
		// TODO Auto-generated method stub
		ResultActions response = null;
		//String secrete = "Basic" + Base64Utils.encodeToString((username+":"+password).getBytes());
		try {
			switch (methodType) {
			case POST: {
				
				String url = "/lease/rate";
			    CarUsageContract anObject = new CarUsageContract();
			    anObject.setMileage(45000);
			    anObject.setDuration(60);
			    anObject.setRoi((float) 4.5);
			    anObject.setNetprice(63000);
			    
			    Gson gson = new Gson();
			    String requestJson = gson.toJson(anObject);

			    mockMVC.perform(post(url).contentType(APPLICATION_JSON_UTF8)
			        .content(requestJson))
			        .andExpect(status().isOk())
			        .andReturn();
				         
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
	
	private String ObjectToJsonString() {
		
		JSONObject obj=new JSONObject();  
		
		try {
			obj.put("mileage", 45000.0);
			obj.put("duration", 60);
			obj.put("roi", 4.5);
			obj.put("netprice", 63000);
			obj.put("leaserate", 239.82143);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj.toString();
		
		
	}
	
}
