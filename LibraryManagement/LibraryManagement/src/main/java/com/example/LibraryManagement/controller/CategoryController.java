package com.example.LibraryManagement.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.example.LibraryManagement.Entity.Category;
import com.example.LibraryManagement.service.CategoryService;
import com.example.LibraryManagement.service.CategoryServiceImp; 

@RestController
@RequestMapping("/category")
public class CategoryController {
	private final CategoryService cs ; 
	public CategoryController(CategoryService cs) {
		this.cs = cs ;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Category cat) {
		if(cat != null) {
			cs.addCategory(cat) ;
			return "Inserted" ;
		}
		else {
			return "Invalid" ;
		}
	}
	
	@GetMapping("/get/{id}")
	public String getId(@PathVariable Long id) {
		Category c = cs.getCategoryById(id) ; 
		if(c != null) {
			return c.toString() ;
		}
		else {
			return "data doesn't exist" ;
		}
	}
	
	@GetMapping("/get/all")
	public List<Category> getAll(){
		return cs.getAllCategories() ;
	}
	
	@PutMapping("/update/{id}")
	public String updateId(@PathVariable Long id , @RequestBody Category updated) {
		Category c = cs.updateCategory(id, updated) ; 
		if(c != null) {
			return "updated" ; 
		}
		else {
			return "Not found" ;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		cs.deleteCategory(id) ; 
	}
	
}
