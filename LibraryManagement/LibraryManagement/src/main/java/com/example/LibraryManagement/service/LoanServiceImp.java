package com.example.LibraryManagement.service;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Entity.Loan;
import com.example.LibraryManagement.Entity.Member;
import com.example.LibraryManagement.Jpa.BookJpa;
import com.example.LibraryManagement.Jpa.LoanJpa;
import com.example.LibraryManagement.Jpa.MemberJpa;


@Service
public class LoanServiceImp implements LoanService {
	@Autowired
	private LoanJpa ljpa ;
	
	@Autowired
	private MemberJpa mjpa  ; 
	
	@Autowired
	private BookJpa bjpa ;
	
	public String issueBook(Long memberId, Long bookId, LocalDate dueDate) {
		Optional<Member> option = mjpa.findById(memberId) ;
		Optional<Book> books = bjpa.findById(bookId) ;
		Loan l = new Loan() ; 
		l.setDueDate(dueDate);
		l.setIssueDate(LocalDate.now());
		l.setLoanStatus("Active");
		l.setReturnDate(dueDate);
		if(option.isPresent()) {
			Member m = option.get(); 
			m.setLoan(new ArrayList<> (Arrays.asList(l)) ) ;;
		}
		else {
			return "Not inserted" ; 
		}
		if(books.isPresent()) {
			Book b = books.get();
			if(b.getAvailable() >= 1) {
				b.setAvailable(b.getAvailable() - 1); // subtract the number of the book 
			}
			b.setLoan(new ArrayList<>(Arrays.asList(l)));
//			bjpa.save(b) ;
		}
		else {
			return "Not found" ; 
		}
		
		ljpa.save(l) ;
		return "inserted"; 
	}

	public String returnBook(Long loanId) {
		Optional<Loan> option = ljpa.findById(loanId) ; 
		Loan l = null ; 
		if(option.isPresent()) {
			l = option.get() ; 
			ljpa.deleteFromBook(loanId);
			ljpa.deleteFromMember(loanId);
			ljpa.delete(l); // delete from everywhere
		}
		return "Returned" ;
	}

	
	public Loan getLoanById(Long loanId) {
		Optional<Loan> option = ljpa.findById(loanId) ; 
		return option.get();
	}

	
	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		return ljpa.findAll();
	}
}
