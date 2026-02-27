package com.capgemini.springbootbasic;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface CarJpa extends JpaRepository<Car, Integer> { // this is a interface 
	public Car getByPrice(double price) ; 
	
	@Transactional
	@Modifying
//	@Query("delete from Car c where c.brand=:carbrand") // this is sql query 
	@Query(value = "delete from car where brand = :carbrand" , nativeQuery = true ) // we have to use this for the 
	public int deleteByBrand(@Param("carbrand")   String brand) ; 
}
