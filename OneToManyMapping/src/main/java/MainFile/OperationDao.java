package MainFile;

import javax.persistence.Persistence;
import javax.persistence.*;
import java.util.*;

public class OperationDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public String createNewCollege(College c) {
		if(c != null) {
			et.begin();  
			em.persist(c) ;
			et.commit();  
			return "inserted" ;
		}
		else {
			return "null" ;
		}
	}
	public String updateCollege(Student s , int id) { // college id
		College c = em.find(College.class, id) ; 
		if(c != null) { // means it is present
			et.begin();
			List<Student> list = c.getList() ;
			list.add(s)  ;
			c.setList(list) ; 
			em.persist(s); 
			em.merge(c) ; 
 			et.commit(); 
 			return "inserted inside college" ;
		}
		else {
			return "no college" ;
		}
	}
	public String createStudent(Student s) {
		if(s != null) {
			et.begin();  
			em.persist(s);
			et.commit(); 
			return "inserted" ;
		}
		else {
			return "null" ;
		}
	}
	public String deleteStudent(int id) {
		et.begin(); 
		String jpql = "delete from college_info_student_table where list_student_id = ?1" ;
		Query query = em.createNativeQuery(jpql) ;
		query.setParameter(1, id) ;
		query.executeUpdate() ;
		Student s = em.find(Student.class, id) ; 
		em.remove(s); 
		et.commit(); 
		return "deleted" ; 
	}
	public String deleteCollege(int id) {
		College c = em.find(College.class, id) ; 
		if(c != null) {
			et.begin();  
			c.setList(null);
			em.remove(c);
			et.commit();   
			return "deleted" ; 
		}
		else {
			return "null" ; 
		}
	}
}
