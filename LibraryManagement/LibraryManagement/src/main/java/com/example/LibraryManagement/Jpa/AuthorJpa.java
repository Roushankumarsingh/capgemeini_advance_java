package com.example.LibraryManagement.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entity.Author;

public interface AuthorJpa extends JpaRepository<Author, Long>   {

}
