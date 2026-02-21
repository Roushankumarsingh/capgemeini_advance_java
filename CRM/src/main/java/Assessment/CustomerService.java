package Assessment;
import javax.persistence.*;
import java.util.*;

public class CustomerService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void register(Customer c) {
		et.begin() ;
		em.persist(c);
		et.commit();
//		em.clear();
		em.close();
		emf.close();
		System.out.println("Inserted");
	}
	public void update(int id, String email) {
		Customer c = em.find(Customer.class, id) ; 
		if(c != null) {
			et.begin() ;
			c.setEmail(email);
			em.merge(c);
			et.commit();
			em.close();
			emf.close();
			System.out.println("Updated");
		}
	}
	public void delete(int id) {
		String sql1 = "update lead set c_id = null  where c_id = ?1" ; 
		String sql2 = "delete from address where c_id = ?1 " ; 
		Query updateQuery = em.createNativeQuery(sql2) ;
		Query deleteLead = em.createNativeQuery(sql1) ; 
		et.begin();
		deleteLead.setParameter(1,id) ; 
		deleteLead.executeUpdate() ; 
		updateQuery.setParameter(1, id) ; 
		updateQuery.executeUpdate() ; 
		Customer c = em.find(Customer.class, id) ; 
		em.remove(c);
		System.out.println("Deleted");
		et.commit();
	}
}
