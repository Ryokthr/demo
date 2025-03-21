package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/demo/hello")
public class ControllerSample {
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public String hello() {
		
		return "Hello";
	}
}
