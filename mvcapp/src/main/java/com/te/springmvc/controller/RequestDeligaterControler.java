package com.te.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligaterControler {

	@GetMapping("/redirect")
	public String redirectRequest() {
		return "redirect:https://google.com";
	}
	
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:/emplogin";
	}
	
}
