package Assignment;

import javax.persistence.*;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction();
	public String saveUser(User u) {
		if(u != null) {
			et.begin();   
			em.persist(u);
			et.commit();  
			return "inserted" ; 
		}
		else {
			return "null" ;
		}
	}
	public String findUser(int id) {
		User u = em.find(User.class, id) ;
		if(u != null) {
			System.out.println(u);
			return "fetched" ;
		}
		else {
			return "Null" ;
		}
	}
	public String deleteUser(int id) {
		User u = em.find(User.class, id) ; 
		if(u != null) {
			u.setList(null);
			u.setP(null)   ;
			et.begin(); 
			em.remove(u);
			et.commit();
			return "Deleted" ; 
		}
		else {
			return "Not found" ;
		}
	}
	public String updateUser(int id , String email) {
		User u = em.find(User.class, id) ;
		if(u != null) {
			et.begin();  
			u.setEmail(email);
			em.merge(u) ;
			et.commit(); 
			return "Updated" ; 
		}
		else {
			return "Null" ;
		}
	}
}
