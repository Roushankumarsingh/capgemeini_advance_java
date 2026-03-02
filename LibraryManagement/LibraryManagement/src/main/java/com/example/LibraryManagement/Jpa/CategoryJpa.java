package com.example.LibraryManagement.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entity.Category;

public interface CategoryJpa  extends JpaRepository<Category, Long>  {

}
