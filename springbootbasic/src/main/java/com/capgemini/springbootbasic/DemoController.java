package com.capgemini.springbootbasic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController // if we are using it then there is no need of @ResponseBody so that we can get that easily

//@Controller

// controller always search for view but if we want data we have to use @ResponseBody or @RestController on the top so that we can get it 

public class DemoController {
	
	
	@Autowired
	private CarJpa carJpa ;
	
	
	@GetMapping("/a")
//	@ResponseBody // for html we donot need any responsebody 
	public List<String> hello() {
		return new ArrayList<>(Arrays.asList("Miller" , "Brevis" , "Quniton")); 
	}
	@PostMapping("/b")
	public String hello2() {
		return "Hello this is for post mapping" ;
	}
	
	@PostMapping("/add")
	public String createPlayer(@RequestBody Cricketer c) {
		System.out.println(c);
		return c.toString();
	}
	
	@PostMapping("/nested")
	public String createdCar(@RequestBody Car c) {
		System.out.println(c);
		return c.toString() ;
	}
	
	@PostMapping("/list")
	public String createList(@RequestBody Person p) {
		System.out.println(p);
		return p.toString() ; 
	}
	
	@PostMapping("/student")
	public String createStudent(@RequestBody University u) {
		System.out.println(u);
		return u.toString();
	}
	
	@PostMapping("/create/car")
	public String create(@RequestBody Car c ) {
		System.out.println(c); 
		carJpa.save(c) ;
		return "Car is created" ;
	}
	
	@GetMapping("/find-id")
//	http:localhost:9999/delete-id?id=1; // for the requestParam
	public Car getById(@RequestParam Integer id) throws DataNotExist {
		Optional<Car> option = carJpa.findById(id) ; 
//		return option.isPresent() ? option.get().toString() : "Data does not exists" ;
		if(option.isPresent()) {
			Car c = option.get() ; 
			return c ; 
		}
		else {
//			return null ;
			throw new DataNotExist("Data does not exist") ;
		}
	}
	
	
	@DeleteMapping("/delete-id/{id}")
	// http:localhost:9999/delete-id/1 // for the path variable
	public boolean deleteCar(@PathVariable int id) {
		Optional<Car> option = carJpa.findById(id) ;
		if(option.isPresent()) {
			carJpa.delete(option.get());
			return true ;
		}
		else {
			return false ;
		}
	}
	
	
	@PutMapping("/update-car/{id}")
	
	public boolean updateCar(@PathVariable int id ,@RequestBody Car c ) {
		Optional<Car> option = carJpa.findById(id)  ; 
		if(option.isPresent()) {
			Car car = option.get() ; 
			car.setBrand(c.getBrand());
			car.setPrice(c.getPrice());
			carJpa.save(car) ;
			return true ;
		}
		else {
			return false ;
		}
	}
	
	@PatchMapping("/update-car/{id}")
	public boolean updateCarData(@PathVariable int id , @RequestBody Car c ) {
		Optional<Car> option = carJpa.findById(id) ; 
		if(option.isPresent()) {
			Car car = option.get() ; 
			if(c.getBrand() != null) {
				car.setBrand(c.getBrand());
			}
			else if(c.getPrice() != 0.0) {
				car.setPrice(c.getPrice());
			}
			carJpa.save(car) ;
			return true ;
		}
		else {
			return false ;
		}
	}
	
	@GetMapping("/find-price/{price}")
	public Car getCarByPrice(@PathVariable double price) {
		return carJpa.getByPrice(price) ;
	}
	
	@DeleteMapping("/delete-brand/{brand}")
	public void deleteMethod(@PathVariable String brand) {
		carJpa.deleteByBrand(brand);
	}
	
	
	
	
}
