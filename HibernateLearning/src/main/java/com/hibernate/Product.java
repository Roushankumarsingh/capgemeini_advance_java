package com.hibernate;
import javax.persistence.*;

@Entity 
@Table (name="Product_table") 

public class Product {
	@Id 
	@Column (name = "Product_Id") 
	int id ; 
	@Column (name = "Product_Name")
	String name ; 
	@Column (name = "Product_Quantity")
	int quantity ; 
	@Column (name = "Product_Price")
	double price ; 
	public int getId() {
		return id ; 
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
	public int getQuan() {
		return quantity ; 
	}
	public void setQuan(int quantity) {
		this.quantity = quantity ; 
	}
	public double getPrice() {
		return price ; 
	}
	public void setPrice(double price) {
		this.price = price ; 
	}
	public String toString() {
		return  "Id :- " +   id + " Name " + name + " quantity " + quantity + " Price :- " + price ; 
	}
}
