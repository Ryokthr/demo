package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public String hello() {
		return "Hello";
	}

}
