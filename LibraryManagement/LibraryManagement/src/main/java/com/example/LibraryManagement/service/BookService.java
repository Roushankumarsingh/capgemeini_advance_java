package com.example.LibraryManagement.service;


import java.util.*;

import com.example.LibraryManagement.Entity.Book;

public interface BookService {
	 public Book addBook(Book book);
	 public String getBookById(Long bookId);
	 public List<Book> getAllBooks();
	 public Book updateBook(Long bookId, Book updatedBook);
	 public boolean deleteOrDisableBook(Long bookId);
}
