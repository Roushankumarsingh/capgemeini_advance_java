package com.capgemini.employee.demo;

import java.util.*;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/employee")

public class EmployeeController {
	
	
	private final EmployeeJpa ejpa ; 
	public EmployeeController(EmployeeJpa ejpa) {
		this.ejpa = ejpa ;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Employee e) {
		ejpa.save(e) ; 
		return "Inserted" ;
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return ejpa.findAll() ; 
	}
	
	//fetch by id  update it delete it 
	
	@GetMapping("/find-id/{id}")
	public String getbyId(@PathVariable int id) {
		Optional<Employee> option = ejpa.findById(id) ; 
		if(option.isPresent()) {
			return option.get().toString() ; 
		}
		else {
			return "Data doesn't exist" ; 
		}
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id , @RequestBody Employee e) {
		Optional<Employee> option = ejpa.findById(id) ; 
		if(option.isPresent()) {
			Employee et = option.get();
			et.setEmail(e.getEmail()) ; 
			et.setName(e.getName())  ; 
			et.setPhone(e.getPhone()) ; 
			et.setSal(e.getSal()) ;
			ejpa.save(et) ;
			return "Updated" ; 
		}
		else {
			return "data not exists" ;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteId(@PathVariable int id) {
		Optional<Employee> option = ejpa.findById(id) ; 
		if(option.isPresent()) {
			Employee e = option.get()  ; 
			ejpa.delete(e) ; 
			return "deleted" ; 
		}
		else {
			return "Data donot exist" ;
		}
	}
	
	@GetMapping("/find-all-emp")
	public List<Employee> findGreater(@PathVariable double sal){
		return ejpa.findBySalGreaterThan(sal) ;
	}
	
	@GetMapping("/count-emp")
	public int countEmp() {
		List<Employee> list = ejpa.findAll() ; 
		return list.size() ;
	}
}
