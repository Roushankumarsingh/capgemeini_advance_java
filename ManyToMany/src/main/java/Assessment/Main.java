package Assessment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.* ;


public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ; 
//		Student s1 = new Student() ; 
//		s1.setBranch("CSE");
//		s1.setGender('M');
//		s1.setName("Harsha");
//		Subject a1 = new Subject() ; 
//		a1.setDays(20);
//		a1.setId(101);
//		a1.setName("Full stack");
//		Subject a2 = new Subject() ; 
//		a2.setDays(15);
//		a2.setId(102);
//		a2.setName("ML");
//		Student s2 = new Student() ; 
//		s2.setBranch("ML");
//		s2.setGender('M');
//		s2.setName("Yusuf");
//		List<Subject> list = new ArrayList<>() ; 
//		list.add(a1) ; 
//		list.add(a2) ;
//		s1.setS(list);
//		s2.setS(list);
//		et.begin();  
//		em.persist(a1) ;
//		em.persist(a2);
//		em.persist(s2);
//		em.persist(s1);
//		et.commit(); 
		// for delete query 
		
		et.begin();
		String jpql = "delete from studentsubject_subject where student_id = ?1" ; 
		String sql2 = "delete from studentsubject where id = ?1" ; 
		Query query = em.createNativeQuery(jpql) ; 
		Query query1 = em.createNativeQuery(sql2) ;
		query.setParameter(1, 1) ; 
		query1.setParameter(1, 1) ;
		query.executeUpdate() ; 
		query1.executeUpdate() ;
		et.commit(); 
	}
}
