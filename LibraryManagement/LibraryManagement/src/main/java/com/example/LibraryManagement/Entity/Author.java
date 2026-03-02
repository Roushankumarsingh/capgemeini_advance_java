package com.example.LibraryManagement.Entity;

import jakarta.persistence.*;

import java.util.*;
@Entity

public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="author_seq" )
	@SequenceGenerator(name="author_seq" , sequenceName="author_sequence" , initialValue = 500 , allocationSize = 1) 
	Long id ; 
	String name ;
	
	@ManyToMany(mappedBy="authors")
	private List<Book> books ; 
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
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
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	} 
}
