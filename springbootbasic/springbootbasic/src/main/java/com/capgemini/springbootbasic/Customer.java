package com.capgemini.springbootbasic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity



public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ; 
	
	String name ;
	String phone ; 
	String email ; 
	int age ; 
	char gender ;
	String dob ;
	public int getId() {
		return id;
	}
	public String getName() {
		return name ; 
	}
	public void setName(String name) {
		this.name = name ;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + "]";
	}
	
}
