package com.practice;
import java.util.List;

import javax.persistence.*;

public class PassportDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction()  ; 
	public String insertPass(Passport p) {
		if(p != null) {
			et.begin(); 
			em.persist(p) ;
			et.commit(); 
			emf.close(); 
			return "Passport inserted" ; 
		}
		else {
			return "Passport not found" ;
		}
	}
	public String updatePassport(int id , String add) {
		Passport p = em.find(Passport.class, id) ;
		if(p != null) {
			et.begin(); 
			p.setAdd(add) ; 
			em.merge(p) ; 
			et.commit();
			emf.close();
			return "Updated Passport" ; 
		}
		else {
			return "Passport not found" ; 
		}
	}
	public String deletePassport(int id) {
		Passport p = em.find(Passport.class, id) ; 
		if(p != null) {
			et.begin(); 
			em.remove(p);
			et.commit();
			emf.close(); 
			return "Passport deleted" ; 
		}
		else {
			return "Passport not found" ;
		}
	}
	public String fetchById(int id) {
		Passport p = em.find(Passport.class, id) ; 
		if(p != null) {
			System.out.println(p);
			return "User fetched" ; 
		}
		else {
			return "User not found" ;
		}
	}
	public void fetchAll() {
		String fetch = "Select p from Passport p" ; 
		Query query = em.createQuery(fetch) ; 
		List<Passport> list = query.getResultList() ; 
		for(Passport p : list) {
			System.out.println(p);
		}
	}
}
