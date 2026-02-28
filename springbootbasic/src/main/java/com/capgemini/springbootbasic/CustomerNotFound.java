package com.capgemini.springbootbasic;

public class CustomerNotFound extends RuntimeException {

	public CustomerNotFound(String msg) {
		super(msg) ;
	}
}
