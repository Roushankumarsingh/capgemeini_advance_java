package com.example.LibraryManagement.Entity;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity

public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq", sequenceName = "loan_sequence", initialValue = 2500, allocationSize = 1)
	Long id;
	LocalDate issueDate;
	LocalDate dueDate;
	LocalDate returnDate;
	String loanStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	@Override
	public String toString() {
		return "Loan [id=" + id + ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate
				+ ", loanStatus=" + loanStatus + "]";
	}
}
