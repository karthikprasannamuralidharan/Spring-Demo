package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CommonController {
	@RequestMapping("/")
	public String hello() {
		return "first";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
