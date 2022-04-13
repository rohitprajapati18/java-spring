package com.deqode.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/v1")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api")
	public String sayHello() {
		return "Swagger Hello World";
	}
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
}
