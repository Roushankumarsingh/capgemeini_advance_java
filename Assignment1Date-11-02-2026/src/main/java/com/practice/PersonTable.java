package com.practice;

import javax.persistence.*;

public class PersonTable {
	public static void main(String[] args) {
//		Persistence.createEntityManagerFactory("postgres") ;  // to create table first
		// 1 . add dependency of hibernate , junit test , jdbc 
		// 2. Add persistence.xml in the src/main/resource crate folder and add persistence.xml
		
		PersonDao p = new PersonDao() ;
//		Person p1 = new Person() ; 
//		p1.setId(103);
//		p1.setAdd("Nawada"); 
//		p1.setName("Golaki");
//		p1.setPin(4568); 
//		p.insertPerson(p1) ; 
//		p.updatePerson(102, "Patna") ; 
//		p.deletePerson(103) ; 
//		p.fetchById(102) ;
//		p.fetchAll();
		
	}
}
