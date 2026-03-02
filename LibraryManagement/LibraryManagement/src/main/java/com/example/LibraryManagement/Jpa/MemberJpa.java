package com.example.LibraryManagement.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entity.Member;

public interface MemberJpa extends JpaRepository<Member, Long>  {

}
