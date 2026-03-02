package com.example.LibraryManagement.service;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Entity.Category;
import com.example.LibraryManagement.Jpa.CategoryJpa;

import java.util.*;

@Service
public class CategoryServiceImp implements CategoryService {
	
	private final CategoryJpa cjpa ;
	public CategoryServiceImp(CategoryJpa cjpa) {
		this.cjpa = cjpa ;
	}
	
	public void addCategory(Category cat) {
		cjpa.save(cat) ;
		System.out.println("Inserted");
	}
	
	public  Category getCategoryById(Long id) {
		Optional<Category> option = cjpa.findById(id) ; 
		if(option.isPresent()) {
			return option.get() ;
		}
		else {
			return null ; 
		}
	}
	
	public List<Category> getAllCategories(){
		return cjpa.findAll() ;
	}

    public Category updateCategory(Long id, Category updated) {
    		Optional<Category> cat = cjpa.findById(id) ; 
    		if(cat.isPresent()) {
    			Category c = cat.get() ; 
    			c.setDescription(updated.getDescription()) ; 
    			c.setName(updated.getName());
    			cjpa.save(c) ;
    			return c ; 
    		}
    		else {
    			return null ;
    		}
    }

    public void deleteCategory(Long id) {
    		Optional<Category> option = cjpa.findById(id) ; 
    		if(option.isPresent()) {
    			cjpa.delete(option.get());
    			System.out.println("Deleted");
    		}
    		else {
    			System.out.println("Not deleted");
    		}
    }
	
}
