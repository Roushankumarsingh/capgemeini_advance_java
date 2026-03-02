package com.example.LibraryManagement.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.LibraryManagement.Entity.Loan;

import jakarta.transaction.Transactional;

public interface LoanJpa  extends JpaRepository<Loan, Long> {
	@Modifying
	@Transactional
	@Query(value = "delete from book_loans where loans_id = :loanId" , nativeQuery = true ) 
	public void deleteFromBook(@Param("loanId") Long loanId) ;
	
	@Modifying
	@Transactional
	@Query(value = "delete from member_loans where loans_id = :loanId" , nativeQuery = true ) 
	public void deleteFromMember(@Param("loanId") Long loanId) ;
	
}
