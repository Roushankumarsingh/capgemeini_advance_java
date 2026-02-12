package com.hibernate;

import javax.persistence.*;

public class UpdatePrice {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ; 
		
		String jpql = "update Product p set p.price =?1 where p.price=?2" ;
		Query query = em.createQuery(jpql) ;
		et.begin(); 
		query.setParameter(1,80.0) ; 
		query.setParameter(2, 250.0) ; 
		query.executeUpdate() ; 
		et.commit();
		em.close() ; 
		emf.close(); 
	}
}
