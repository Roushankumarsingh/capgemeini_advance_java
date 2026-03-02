package com.example.LibraryManagement.service;

import java.time.LocalDate;
import java.util.*;

import com.example.LibraryManagement.Entity.Loan;

public interface LoanService {
	public String issueBook(Long memberId,Long bookId,LocalDate dueDate) ; 
	public String returnBook(Long loanId) ; 
	public Loan getLoanById(Long loanId) ; 
	public List<Loan> getAllLoans() ; 
}
