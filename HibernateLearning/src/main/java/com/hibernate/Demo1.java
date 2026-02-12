package com.hibernate;

import javax.persistence.*;

public class Demo1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ;
		
		// create the transaction on it 
		EntityTransaction et = em.getTransaction() ;
		
		Students s = em.find(Students.class, 2)  ;
		System.out.println(s);        
		et.begin() ; 
		em.remove(s);
		et.commit(); 
		emf.close(); 
	}
}
