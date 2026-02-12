package com.practice;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table (name="Person_details") 
public class Person {
	@Id
	@Column (name="PersonId") 
	int id ; 
	@Column (name="Name") 
	String name ; 
	@Column (name="Address") 
	String address ; 
	@Column (name="PinCode")
	int pin ; 
	public int getId() {
		return id ; 
	}
	public void setId(int id) {
		this.id= id ;
	}
	public String getName() {
		return name ; 
	}
	public void setName(String name) {
		this.name = name ; 
	}
	public String getAdd() {
		return address  ; 
	}
	public void setAdd(String address) {
		this.address = address ; 
	}
	public int getPin() {
		return pin ; 
	}
	public void setPin(int pin) {
		this.pin = pin ; 
	}
	public String toString() {
		return id + " " + name + " " + address + " " + pin ; 
	}
}