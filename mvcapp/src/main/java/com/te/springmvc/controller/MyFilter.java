package com.te.springmvc.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		System.out.println("inside do filter");
		System.out.println("url    :"+req.getRequestURL());
		System.out.println("uri    :"+req.getRequestURI());
		System.out.println("method :"+req.getMethod());
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
		
	}

}
