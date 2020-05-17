package com.iss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hi")
	public String index()
	{
		return "<h1>hello Spring boot!</h1>";
	}
}
