package com.nagarro.msa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nagarro.msa.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/{id}")
	String getUser(@PathVariable(value = "id") Long userId) {
		return objectToJson(userService.getUserById(userId));
	}
	
	private String objectToJson(Object list) {
		Gson gsonBuild = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	    return gsonBuild.toJson(list);
	}

}
