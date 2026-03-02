package com.example.LibraryManagement.service;

import java.util.List;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Entity.Author;
import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Entity.Branch;
import com.example.LibraryManagement.Entity.Category;
import com.example.LibraryManagement.Jpa.AuthorJpa;
import com.example.LibraryManagement.Jpa.BookJpa;
import com.example.LibraryManagement.Jpa.BranchJpa;
import com.example.LibraryManagement.Jpa.CategoryJpa;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	private  BookJpa bjpa ; 
	@Autowired
	private CategoryJpa cjpa ;
	@Autowired
	private BranchJpa brjpa ;
	@Autowired
	private AuthorJpa ajpa;
	 public Book addBook(Book book) {
//		 Optional<Category> option = cjpa.findById(categoryId) ; 
//		 Category c = null ; 
//		 Branch b = null ; 
//		 if(option.isPresent()) {
//			 c = option.get() ; 
//		 }
//		 Optional<Branch> optionb = brjpa.findById(branchId) ; 
//		 if(optionb.isPresent()) {
//			 b = optionb.get() ; 
//		 }
//		 List<Author> list = new ArrayList<>() ;
//		 for(Long id : authorIds) {
//			 Optional<Author> optiona = ajpa.findById(id) ; 
//			 if(option.isPresent())list.add(optiona.get()) ;
//		 }
////		 book.setAuthors(list);
//		 List<Author> authors = ajpa.findAllById(authorIds);
//		 book.setAuthors(authors); 
//		 book.setBranch(b);
//		 book.setCategory(c);
//		 book.setLoan(null);
		 return bjpa.save(book) ;
 	 } 
	 public String getBookById(Long bookId) {
		 Optional<Book> option = bjpa.findById(bookId) ; 
		 if(option.isPresent()) {
			 return option.get().toString() ; 
		 }
		 return "Data doesn't exist" ;
	 }
	 public Book updateBook(Long bookId, Book updated) {
		 Optional<Book> option = bjpa.findById(bookId); 
		 if(option.isPresent()) {
			 Book b = option.get() ; 
			 b.setAuthors(updated.getAuthors());
			 b.setAvailable(updated.getAvailable());
			 b.setBranch(updated.getBranch());
			 b.setCategory(updated.getCategory());
			 b.setIsbn(updated.getIsbn());
			 b.setLoan(updated.getLoan());
			 b.setStatus(updated.getStatus());
			 b.setTitle(updated.getTitle());
			 b.setTotal(updated.getTotal());
			 b.setYear(updated.getYear());
			 return bjpa.save(b)  ; 
		 }else {
			 return null ;
		 }
	 }
	 public boolean deleteOrDisableBook(Long bookId) {
		 Optional<Book> option = bjpa.findById(bookId); 
		 if(option.isPresent()) {
			 bjpa.delete(option.get());
			 return true ;
		 }
		 else {
			 return false ;
		 }
	 }
	 public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bjpa.findAll() ;
	 }
}
