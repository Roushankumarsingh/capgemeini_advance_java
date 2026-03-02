package com.example.LibraryManagement.Entity;
import jakarta.persistence.*;

@Entity


public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "bran_seq")
	@SequenceGenerator(name="bran_seq" , sequenceName = "bran_sequence" , initialValue = 1500 , allocationSize = 1)
	Long id ;
	String name ; 
	String location ; 
	String contact ;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact + "]";
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
