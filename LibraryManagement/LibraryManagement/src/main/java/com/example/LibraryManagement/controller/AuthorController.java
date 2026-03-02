package com.example.LibraryManagement.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.LibraryManagement.Entity.Author;
import com.example.LibraryManagement.service.AuthorServiceImp;



@RequestMapping("/author")
@RestController
public class AuthorController {
	private  final AuthorServiceImp as ; 
	public AuthorController(AuthorServiceImp as) {
		this.as = as ;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Author a) {
		Author b = as.addAuthor(a) ;
		if(b != null) {
			System.out.println("added");
			return "Inserted" ;
		}
		return "Invalid" ;
	}
	
	@GetMapping("/get/{id}")
	public String findId(@PathVariable Long id) {
		Author a = as.getAuthorById(id);
		if(a != null) {
			return a.toString() ;
		}
		else {
			return "Data doesnot exist" ;
		}
	}
	
	@PutMapping("/update/{id}")
	public String updateId(@PathVariable Long id , @RequestBody Author updated ) {
		Author a = as.updateAuthor(id, updated) ; 
		if(a != null) {
			return "Updated" ;
		}
		else {
			return "Data not found" ; 
		}
	}
	@GetMapping("/get/all-authors")
	public List<Author> getAll() {
		System.out.println(as.getAllAuthors());
		return as.getAllAuthors() ;
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		as.deleteAuthor(id) ;
	}
}
