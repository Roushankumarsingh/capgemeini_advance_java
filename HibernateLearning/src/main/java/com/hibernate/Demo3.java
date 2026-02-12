package com.hibernate;
import javax.persistence.*;

public class Demo3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ; 
		Students s = em.find(Students.class, 2) ; 
		if(s!= null) {
			s.setPercentage(100); 
			et.begin(); 
			em.merge(s) ;
			et.commit(); 
		}
	}
}
