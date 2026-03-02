package com.example.LibraryManagement.Entity;

import jakarta.persistence.*;
@Entity

@Table(name="categories")

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "cat_seq")
	@SequenceGenerator(name="cat_seq" , sequenceName="cat_sequence" , initialValue = 1000 , allocationSize = 1)
	Long id ; 
	String name ; 
	String description ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	} 
}
