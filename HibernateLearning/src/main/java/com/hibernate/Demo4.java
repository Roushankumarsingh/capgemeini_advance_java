package com.hibernate;
import java.util.*;
import javax.persistence.*; 

public class Demo4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ; 
		
		String fetch = "Select s from Students s" ; 
		Query query = em.createQuery(fetch) ; 
		List<Students> list = query.getResultList() ; 
		for(Students s : list) {
			System.out.println(s) ; 
		}
	}
}
