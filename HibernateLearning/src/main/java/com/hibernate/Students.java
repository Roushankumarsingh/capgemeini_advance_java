package com.hibernate;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "student_info") 
public class Students {
	@Id
	@Column (name="student_id") 
	private int id ; 
	@Column(name="student_name") 
	private String name ; 
	@Column (name = "student_percentage")
	private double percentage ; 
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
	public double getPercentage() {
		return percentage ; 
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage ; 
	}
	public String toString() {
		return id + " " + name + " " + percentage ; 
	}
}
