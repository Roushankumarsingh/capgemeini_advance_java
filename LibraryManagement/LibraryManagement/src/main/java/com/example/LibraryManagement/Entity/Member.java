package com.example.LibraryManagement.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import java.util.*;

@Entity

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "mem_seq") 
	@SequenceGenerator(name="mem_seq" , sequenceName = "mem_sequence" , initialValue = 2000 , allocationSize = 1 )
	Long id ; 
	String name ; 
	String email  ; 
	String phone ; 
	LocalDate memberSince ; 
	String status ;
	
	@OneToMany 
	private List<Loan> loans ; 
	public List<Loan> getLoan(){
		return loans ;
	}
	public void setLoan(List<Loan>loans) {
		this.loans = loans ;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", memberSince="
				+ memberSince + ", status=" + status + "]";
	}
}
