package com.college.emp;

import javax.persistence.Persistence;

public class Demo1 {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("postgres") ;
	}
}
