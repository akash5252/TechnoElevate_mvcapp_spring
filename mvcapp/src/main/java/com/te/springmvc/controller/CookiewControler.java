package com.te.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/cookie")
public class CookiewControler {
	
	@GetMapping("/cookies")
	public String getCookies() {
		
		return "cookies";
	}
	
	@GetMapping("/createCookie")
	public String name(HttpServletResponse response,ModelMap map) {
		Cookie cookie=new Cookie("empName", "ash");
		response.addCookie(cookie);
		map.addAttribute("msg", "created cookie");
		return "cookies";
	}
	
	@GetMapping("/showCookies")
	public String showCookies(@CookieValue(name="empName",required = false)String name,ModelMap map) {
		
		map.addAttribute("cookie", name);
		return "cookies";
	}

}
