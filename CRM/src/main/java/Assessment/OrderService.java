package Assessment;
import javax.persistence.*;
import java.util.*;

public class OrderService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void register(Order o) {
		et.begin() ;
		em.persist(o);
		et.commit();
		System.out.println("Inserted");
	}
	public void totalCalculation() {
		String sql = "select o from Order o" ;
		Query query = em.createQuery(sql) ;
		List<Order> list = query.getResultList() ;
		double total = 0.0 ; 
		for(Order o : list) {
			total += o.amount ; 
		}
		System.out.println("Total amount is :- " + total);
	}
}
