package Assignment;

import javax.persistence.*;

public class PaymentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction();
	public String savePayment(Payment p) {
		if(p != null) {
			et.begin();   
			em.persist(p);
			et.commit() ; 
			return "inserted" ; 
		}
		else {
			return "Null" ;
		}
	}
	public String findPayment(int id) {
		Payment p = em.find(Payment.class, id) ; 
		if(p != null) {
			System.out.println(p); 
			return "fetched" ; 
		}
		else {
			return "Null" ;
		}
	}
}
