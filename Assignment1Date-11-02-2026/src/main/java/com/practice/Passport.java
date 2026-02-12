package com.practice;

import javax.persistence.*;


@Entity 
@Table (name = "Passport_Details") 
public class Passport {
	@Id
	@Column (name = "Passport_number")
	int id ; 
	@Column (name = "Passport_name")
	String name ; 
	@Column (name="Gender")
	char gender ; 
	@Column (name="Address") 
	String add  ;
	public int getId() {
		return id ; 
	}
	public void setId(int id) {
		this.id = id ; 
	}
	public String getName() {
		return name ; 
	}
	public void setName(String name) {
		this.name = name ; 
	}
	public String getAdd() {
		return add  ; 
	}
	public void setAdd(String add) {
		this.add = add ; 
	}
	public char getGender() {
		return gender ; 
	}
	public void setGender(char gender) {
		this.gender = gender ;
	}
	public String toString() {
		return id + " " + name + " " + gender + " " + add ;
	}
}
