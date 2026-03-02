package com.example.LibraryManagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Entity.Branch;
import com.example.LibraryManagement.service.BranchService;
import org.springframework.web.bind.annotation.* ; 

import java.util.*;

@RestController
@RequestMapping("/branch")
public class BranchController {
	private  final BranchService bs ;
	public BranchController(BranchService bs) {
		this.bs = bs ;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Branch br) {
		Branch b = bs.addBranch(br) ; 
		if(b != null) {
			return "inserted" ;
		}
		else {
			return "Invalid" ; 
		}
	}
	
	@GetMapping("/get/{id}")
	public String getById(@PathVariable Long id) {
		Branch b = bs.getBranchById(id) ; 
		if(b != null) {
			return b.toString() ; 
		}
		else {
			return "Not found" ;
		}
	}
	@GetMapping("/get/all")
	public List<Branch> getAllBranch(){
		return bs.getAllBranches() ; 
	}
	
	@PutMapping("/update/{id}") // fully updated
	public String updateId(@PathVariable Long id , @RequestBody Branch updated) {
		Branch b = bs.updateBranch(id, updated) ; 
		if(b != null) {
			return "Updated" ; 
		}
		else {
			return "Not found" ;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteId(@PathVariable Long id) {
		boolean res = bs.deleteBranch(id) ; 
		if(res) {
			return "deleted"  ; 
		}
		else {
			return "not found" ;
		}
	}
}
