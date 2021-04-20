package com.te.springmvc.customeexception;

public class EmployeeExp extends RuntimeException {
	public EmployeeExp(String msg) {
		super(msg);
	}
}
