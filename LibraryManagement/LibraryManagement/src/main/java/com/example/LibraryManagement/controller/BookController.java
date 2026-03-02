package com.example.LibraryManagement.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private final BookService bs ; 
	public BookController(BookService bs) {
		this.bs = bs ; 
	}
	@PostMapping("/create")
	public String create(@RequestBody Book b) {
		Book b1 = bs.addBook(b) ; 
		return "Inserted" ;
	}
	@GetMapping("/get/{id}")
	public String getId(@PathVariable Long id) {
		return bs.getBookById(id ) ; 
	}
	@GetMapping("/get/all")
	public List<Book> getAll(){
		return bs.getAllBooks() ; 
	}
	
	@PutMapping("/update/{id}")
	public String updateId(@PathVariable Long id , @RequestBody Book Updated) {
		Book b = bs.updateBook(id, Updated) ; 
		if(b != null) {
			return b.toString() ; 
		}
		else {
			return "Not found" ;
		}
	}
	@DeleteMapping("/delete/{id}")
	public String deleteId(@PathVariable Long id) {
		boolean res = bs.deleteOrDisableBook(id) ;
		if(res) {
			return "Deleted"  ; 
		}
		else {
			return "Not found" ;
		}
	}
}
