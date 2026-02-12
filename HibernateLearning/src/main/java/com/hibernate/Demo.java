package com.hibernate;
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
		
		Students s = new Students() ; 
		s.setId(3);
		s.setName("Rohit Sharma"); 
		s.setPercentage(85); 
		et.begin();  
		em.persist(s);
		et.commit();
		emf.close(); 
	}
}
