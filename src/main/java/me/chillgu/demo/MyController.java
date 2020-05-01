package me.chillgu.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	@GetMapping("/my")
	public String my() {
		
		return "my";
	}
}
