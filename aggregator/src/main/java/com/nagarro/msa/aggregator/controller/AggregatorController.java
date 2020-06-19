package com.nagarro.msa.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping(value = "/orderdetails")
public class AggregatorController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.application.url}")
	String userApplicationUrl;
	
	@Value("${orders.application.url}")
	String ordersApplicationUrl;
	
	@GetMapping(value = "/{id}")
	String getResponse(@PathVariable(value = "id") Long userId) {
		String userData = restTemplate.getForObject(userApplicationUrl + userId, String.class);
		
		String ordersData = restTemplate.getForObject(ordersApplicationUrl + userId, String.class);
		
		JsonObject responseObject = new JsonObject();
		responseObject.add("userDetails", JsonParser.parseString(userData));
		responseObject.add("orders", JsonParser.parseString(ordersData).getAsJsonObject().get("orders"));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(responseObject);
	}

}
