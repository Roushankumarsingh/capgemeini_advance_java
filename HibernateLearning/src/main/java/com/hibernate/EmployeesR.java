package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeesR {
	@Id
	int id ; 
	String name ; 
	int sal ; 
	public int getId() {
		return id   ; 
	}
	public void setId(int id ) {
		this.id = id ; 
	}
	public String getName() {
		return name ; 
	}
	public void setName(String name) {
		this.name = name ; 
	}
	public int getSal() {
		return sal ; 
	}
	public void setSal(int sal) {
		this.sal = sal ;
	}
}
