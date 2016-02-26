package com.npu.myproject.exceptions;

public class FlightNotFound extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FlightNotFound(String msg){
		super(msg);
	}

}
