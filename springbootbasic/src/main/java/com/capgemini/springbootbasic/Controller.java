package com.capgemini.springbootbasic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	@GetMapping("/customers/{page}/{size}")
	public List<Customer> getCustomerDetail(@PathVariable int page ,@PathVariable int size) {
		Page<Customer> p = cjpa.findAll(PageRequest.of(page, size)) ; 
		return p.getContent() ; // it will return 
	}
	
	@GetMapping("/get-customers/sorted/{page}/{size}") // for the sorting
	public List<Customer> getCustomers(@PathVariable int page , @PathVariable int size){
		Page<Customer> p = cjpa.findAll(PageRequest.of(page, size,Sort.by("id").descending())) ; 
		return p.getContent();
	}
	
	
	@GetMapping("/gets/id/{id}")
	public ResponseEntity<Customer> getById(@PathVariable int id)  {
		Optional<Customer > option = cjpa.findById(id) ; 
		Customer c = null ;
		if(option.isPresent()) {
			c = option.get(); 
			return new ResponseEntity<Customer>(c,HttpStatus.FOUND) ; 
		}
		else {
//			throw new CustomerNotFound("Data does not exists for thsi id") ;
//			return new ResponseEntity<Customer>(c,HttpStatus.NOT_FOUND) ;
			throw new CustomerNotFound("Customer with this id is not present the id is :- "+id) ;
		}
	}
	
}
