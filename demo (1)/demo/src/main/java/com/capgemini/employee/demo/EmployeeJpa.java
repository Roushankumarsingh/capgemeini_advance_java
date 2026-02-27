package com.capgemini.employee.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;


public interface EmployeeJpa extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findBySalGreaterThan(double sal) ;
	
	
//	@Query("select e from Employee e where e.sal > (select avg(e2.sal) from Employee e2 )")  // this is jpa query
	@Query(value = "select * from employee where sal > (select avg(sal) from employee)" , nativeQuery = true)
	
	public List<Employee> findBySalAboveAvg(double sal) ; 
	
	@Query("select e from Employee e where e.department = :department")
	public List<Employee> findByDepartment(@Param("department")String department) ; 
	
	
}
