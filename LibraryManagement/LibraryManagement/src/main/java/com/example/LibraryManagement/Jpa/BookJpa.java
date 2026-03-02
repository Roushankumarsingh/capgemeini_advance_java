package com.example.LibraryManagement.Jpa;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entity.Book;

public interface BookJpa extends JpaRepository<Book, Long>  {

}
