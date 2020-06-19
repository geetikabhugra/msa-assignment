package com.nagarro.msa.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nagarro.msa.orders.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(value = "/{id}")
	String getOrders(@PathVariable(name = "id") Long userId) {
		return listToJson(orderService.getOrdersByUserId(userId));
	}
	
	private String listToJson(List<?> list) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	    String jsonString = gson.toJson(list);
	    
	    JsonObject jsonObject = new JsonObject();
	    jsonObject.add("orders", JsonParser.parseString(jsonString));
	    
	    Gson gsonBuild = new GsonBuilder().setPrettyPrinting().create();
	    return gsonBuild.toJson(jsonObject);
	}

}
