package com.capgemini.springbootbasic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Car {
	@Id
	int id ; 
	public String brand ; 
	public double price ; 
	public int getId() {
		return id ;
	}
	public void setId(int id) {
		this.id = id ; 
	}
	public String getBrand() {
		return brand ; 
	}
	public void setBrand(String brand) {
		this.brand = brand ; 
	}
	public double getPrice() {
		return price ; 
	}
	public void setPrice(double price) {
		this.price = price ;
	}
//	public Car(String brand , double price , Engine e) {
//		this.brand = brand ; 
//		this.price = price ; 
//		this.e = e ;
//	}       if we have set all the variables public then no need of the constructors if we use constructors simply use and can access it 
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", e=" + "]";
	}
	
}
