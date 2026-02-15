package Assignment;

import java.util.List;

import javax.persistence.*;
public class OrderDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction();
	public String saveOrder(Purchase p) {
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
	public String findOrder(int id) {
		Purchase p = em.find(Purchase.class, id) ;
		if(p != null) {
			System.out.println(p);
			return "fetched" ; 
		}
		else {
			return "Not found " ;
		}
	}
	public String findOrderByUser(int id) {
		et.begin();
		String jpql = "select * from user_purchase where id = ?1" ; 
		Query query = em.createNativeQuery(jpql) ; 
		query.setParameter(1,id) ; 
		List<User> l = query.getResultList() ; 
		System.out.println(l.get(0));
		et.commit();
		return "fetched" ;
	}
}
