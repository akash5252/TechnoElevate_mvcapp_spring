package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvc.customeexception.EmployeeExp;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeExp.class)
	public String handlerExp(EmployeeExp exp,HttpServletRequest req) {
		req.setAttribute("err", exp.getMessage());
		return "errPage";
	}
	
}
