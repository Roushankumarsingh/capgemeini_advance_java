package com.example.LibraryManagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Entity.Loan;
import com.example.LibraryManagement.service.LoanService;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private LoanService ls ;
	
	@PostMapping("/create/{id1}/{id2}")
	public String create(@PathVariable Long id1 ,@PathVariable Long id2 ,@RequestBody LocalDate due) {
		return ls.issueBook(id1, id2, due) ;
	}
	
	@GetMapping("/get/{id}")
	public String getId(@PathVariable Long id) {
		Loan l = ls.getLoanById(id)  ; 
		if(l != null) {
			return l.toString() ; 
		}
		else {
			return "Not found" ; 
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteLoan(@PathVariable Long id) {
		return ls.returnBook(id) ;
	}
	
	@GetMapping("/get/all")
	
	public List<Loan> getAllLoan(){
		return ls.getAllLoans() ;
	}
}
