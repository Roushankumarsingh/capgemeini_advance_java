package com.capgemini.springbootbasic;

public class Cricketer {
	private String name ; 
	private String role ; 
	private int runs ; 
	private int mathces ; 
	double average ; 
	public Cricketer(String name , String role , int runs , int matches , double average) {
		this.name = name ; 
		this.role = role ; 
		this.runs = runs  ; 
		this.mathces = matches ; 
		this.average = average ;
	}
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", role=" + role + ", runs=" + runs + ", mathces=" + mathces + ", average="
				+ average + "]";
	}
	
}
