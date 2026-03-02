package com.example.LibraryManagement.service;

import com.example.LibraryManagement.Entity.Author;
import com.example.LibraryManagement.Jpa.AuthorJpa;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp implements AuthorService {
	
	private final AuthorJpa ajpa ;
	public AuthorServiceImp(AuthorJpa ajpa) {
		this.ajpa = ajpa ; 
	}
	
	public Author addAuthor(Author author) {
		return ajpa.save(author) ;
	}
	public Author getAuthorById(Long id) {
		Optional<Author> option = ajpa.findById(id) ; 
		if(option.isPresent()) {
			Author author = option.get() ; 
			return author ;
		}
		else {
			return null ; // data doesnot exist
		}
	}
	public List<Author> getAllAuthors(){
		return ajpa.findAll() ;
	}
	public Author updateAuthor(Long id, Author updated) {
		Optional<Author> option = ajpa.findById(id) ; 
		if(option.isPresent()) {
			Author a = option.get() ; 
			a.setName(updated.getName()) ;
			a.setBooks(updated.getBooks());
			return a ;
		}
		else {
			return null ; 
		}
	}
	public void deleteAuthor(Long id) {
		Optional<Author> option = ajpa.findById(id) ; 
		if(option.isPresent()) {
			Author a = option.get() ; 
			a.setBooks(null) ; 
			ajpa.save(a) ;  // first save it and then delete it 
			ajpa.delete(a); 
		}
		else {
			System.out.println("Not found");
		}
	}
}
