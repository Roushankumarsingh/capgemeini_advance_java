package com.example.LibraryManagement.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entity.Branch;

public interface BranchJpa  extends JpaRepository<Branch, Long>  {

}
