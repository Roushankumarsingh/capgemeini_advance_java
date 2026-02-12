package com.hibernate;
import java.util.List;

import javax.persistence.*;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; // to load the driver class and the alter table  
		EntityManager em = emf.createEntityManager() ; // to access the crud operation 
		// save persist 
		// all the four crud operation we need to commit it as auto commit is off made it on 
		// delete remove 
		// Entity transaction is basically used to do the transaction 
		// find is used to find the data by using the primary key 
		EntityTransaction et = em.getTransaction() ; 
//		String jpql = "select p from Product p where p.price>=?1" ; 
		
//		Query query = em.createQuery(jpql ) ; 
//		query.setParameter(1,100.0) ; 
//		List<Product> list = query.getResultList() ; 
//		list.forEach(e->System.out.println(e.getName()));
		
//		String jpql1 = "select p from Product p where p.name = 'Pencil' " ;
//		Query query1 = em.createQuery(jpql1) ; 
//		List<Product> list1 = query1.getResultList() ;
//		list1.forEach(e -> System.out.println(e));
		
//		String jpql2 = "select p from Product p where p.price >= ?1 and p.quantity >= ?2" ; 
//		Query query = em.createQuery(jpql2) ; 
//		query.setParameter(1, 600.0) ; 
//		query.setParameter(2, 300) ; 
//		List<Product> list = query.getResultList() ; 
//		list.forEach(System.out::println);
//		JPLQ -> 1 createQuery(query)  for select statement   2. executeUpdate for data manipulation we use executeUpdate
		String jpql = "select p from Product p where p.price >= :a and p.quantity >= :b"  ; 
		Query query = em.createQuery(jpql) ; 
		query.setParameter("a", 14521.0) ; 
		query.setParameter("b", 400 )  ; 
		
		List<Product> list = query.getResultList(); 
		list.forEach(System.out::println);
		
	}
}
