package com.example.LibraryManagement.service;

import java.util.*;

import com.example.LibraryManagement.Entity.Author;


public interface AuthorService {
	 Author addAuthor(Author author);

	 Author getAuthorById(Long id);

	 List<Author> getAllAuthors();

	 Author updateAuthor(Long id, Author updated);

	 void deleteAuthor(Long id);
}
