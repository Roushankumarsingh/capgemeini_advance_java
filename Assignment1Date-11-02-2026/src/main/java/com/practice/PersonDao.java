package com.practice;
import javax.persistence.*; 
import java.util.*;

public class PersonDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction() ; 
	public String insertPerson(Person p) {
		if(p != null) {
			et.begin(); 
			em.persist(p); 
			et.commit(); 
			emf.close(); 
			return "data inserted" ; 
		}
		else {
			return "data exists" ; 
		}
	}
	public String updatePerson(int id , String add) {
		Person p = em.find(Person.class, id) ;
		if(p != null) {
			et.begin(); 
			p.setAdd(add) ; 
			em.merge(p) ;
			et.commit();
			emf.close();
			return "Updated User" ; 
		}
		else {
			return "User not found" ; 
		}
	}
	public String deletePerson(int id) {
		Person p = em.find(Person.class, id) ; 
		if(p != null) {
			et.begin(); 
			em.remove(p);
			et.commit();
			emf.close(); 
			return "User deleted" ; 
		}
		else {
			return "User not found" ;
		}
	}
	public String fetchById(int id) {
		Person p = em.find(Person.class, id) ; 
		if(p != null) {
			System.out.println(p);
			return "User fetched" ; 
		}
		else {
			return "User not found" ;
		}
	}
	public String fetchAll() {
		String fetch = "Select p from Person p" ; 
		Query query = em.createQuery(fetch) ; 
		List<Person> list = query.getResultList() ; 
		for(Person p : list) {
			System.out.println(p);
		}
		return "fetched" ;
	}
}
