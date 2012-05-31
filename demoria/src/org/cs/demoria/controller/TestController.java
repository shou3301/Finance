package org.cs.demoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/**")
public class TestController {
	
	@RequestMapping("test")
	public String test() {
		return "test";
	}
	
}
