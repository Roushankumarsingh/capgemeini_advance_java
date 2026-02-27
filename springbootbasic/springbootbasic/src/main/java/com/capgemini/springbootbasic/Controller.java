package com.capgemini.springbootbasic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController

public class Controller {
	@Autowired
	private CustomerJpa cjpa ;
	
	@PostMapping("/create/customer")
	public String createCustomer(@RequestBody Customer c) {
		cjpa.save(c) ;
		return "Created" ;
	}
	
	@GetMapping("/email/{email}")
	public String CustomerEmail(@PathVariable String email) {
		Customer c = cjpa.findByEmail(email) ; 
		if(c != null) {
			return c.toString() ;
		}
		else {
			return "Data doesn't exist" ;
		}
	}
	
	@GetMapping("/email/{name}/{email}")
	public String CustomerDetail(@PathVariable String name , @PathVariable String email) {
		Customer c  = cjpa.findByNameAndEmail(name, email) ; 
		if(c != null) {
			return c.toString() ;
		}
		else {
			return "Data is not present" ;
		}
	}
	
	@GetMapping("/id-between/{start}/{end}")
	public void getByIdBetween(@PathVariable int start ,@PathVariable int end) {
		List<Customer> list = cjpa.findByIdBetween(start, end) ; 
		System.out.println(list) ;
	}
	
	@GetMapping("/age-greater/{age}")
	public List<Customer>  getAgeGreater(@PathVariable int age) {
		List<Customer> list = cjpa.findByAgeGreaterThan(age) ; 
		System.out.println(list);
		return list ;
	}
	
	@GetMapping("/age-less/{age}")
	public List<Customer> getAgeLesser(@PathVariable int age) {
		List<Customer> list = cjpa.findByIdLessThan(age ) ; 
		System.out.println(list);
		return list ;
	}
	
	@GetMapping("/email-not-null")
	public List<Customer> getEmailNotNull(){
		List<Customer> list = cjpa.findByEmailIsNotNull() ; 
		return list ;
	}
	@GetMapping("/name-contain/{name}")
	public List<Customer> containName(@PathVariable String name){
		List<Customer> list = cjpa.findByNameContaining(name) ; 
		return list ;
	}
	
	@GetMapping("/name-start/{name}")
	public List<Customer> nameStartWith(@PathVariable String name){
		List<Customer > list = cjpa.findByNameStartingWith(name)   ; 
		return list ;
	}
	
	@GetMapping("/name-end/{name}")
	public List<Customer> nameEndsWith(@PathVariable String name){
		List<Customer> list = cjpa.findByNameEndingWith(name)  ; 
		return list ;
	}
	
	@GetMapping("/name-ignore/{name}")
	public List<Customer> nameIgnoreCase(@PathVariable String name){
		List<Customer> list = cjpa.findByNameIgnoreCase(name) ; 
		return list;
	}
	
	@GetMapping("/sorted")
	public List<Customer> sortedId(){
		List<Customer> list = cjpa.findTopByOrderByIdDesc() ; 
		return list;
	}
	
	@GetMapping("/find-first/{name}")
	public List<Customer> findFirst(@PathVariable String name){
		List<Customer> list = cjpa.findFirst3ByName(name) ; 
		return list ;
	}
	
	
}
