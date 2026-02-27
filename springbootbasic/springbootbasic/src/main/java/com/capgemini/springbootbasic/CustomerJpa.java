package com.capgemini.springbootbasic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpa extends JpaRepository<Customer,Integer>  {
	
	public Customer findByEmail(String email) ; 
	public Customer findByNameAndEmail(String name , String email) ;
	public List<Customer> findByIdBetween(int start , int end) ;
	public List<Customer> findByAgeGreaterThan(int age) ;
	public List<Customer> findByIdLessThan(int id) ;
	
	public List<Customer> findByEmailIsNotNull() ;
	public List<Customer> findByNameStartingWith(String name )  ; 
	public List<Customer> findByNameContaining(String name) ; 
	public List<Customer> findByNameEndingWith(String name) ; 
	public List<Customer> findByNameIgnoreCase(String name) ;
	
	public List<Customer > findTopByOrderByIdDesc() ; 
	public List<Customer> findFirst3ByName(String name) ;
}
