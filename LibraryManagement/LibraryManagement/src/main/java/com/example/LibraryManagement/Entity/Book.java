package com.example.LibraryManagement.Entity;


import jakarta.persistence.*;
import java.util.*;

@Entity
public class Book {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // id start from 1 
	Long id ; 
	String title ; 
	String isbn ; 
	int year ; 
	int total ; 
	int available ; 
	String status ;
	
	@ManyToMany
	@JoinTable
	private List<Author> authors ;
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	@ManyToOne // unidirectional it is 
	private Category c ; 
	public Category getCategory() {
		return c ; 
	}
	public void setCategory(Category c) {
		this.c = c ;
	}
	
	@ManyToOne  // unidirectional
	private Branch b ; 
	public Branch getBranch() {
		return b ; 
	}
	public void setBranch(Branch b) {
		this.b = b; 
	}
	
	@OneToMany // unidirectional 
	private List<Loan> loans  ; 
	public List<Loan> getLoan(){
		return loans ; 
	}
	public void setLoan(List<Loan> loans) {
		this.loans = loans ;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", year=" + year + ", total=" + total
				+ ", available=" + available + ", status=" + status + "]";
	}
}
