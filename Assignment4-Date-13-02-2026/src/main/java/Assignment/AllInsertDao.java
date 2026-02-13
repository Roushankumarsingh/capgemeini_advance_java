package Assignment;

import java.util.List;

import javax.persistence.*;


public class AllInsertDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public String insertAdhaar(Adhaar a ) {
		if(a != null) {
			et.begin(); 
			em.persist(a) ; 
			et.commit(); 
			em.close(); 
			emf.close();
			return "inserted" ; 
		}
		else {
			return "a is null" ;
		}
	} 
	public String insertHostel(Hostel h) {
		if(h != null) {
			et.begin();
			em.persist(h);
			et.commit(); 
			em.close(); 
			emf.close();
			return "inserted" ;
		}
		else {
			return "Hostel is null";
		}
	}
	public String insertStudent(Student s) {
		if(s != null) {
			et.begin();
			em.persist(s);
			et.commit();
			em.close() ; 
			emf.close(); 
			return "inserted" ;
		}
		else {
			return "Student is null" ;
		}
		
	}  
	public String fetchStudent() {
		String jpql = "select s from Student s" ; 
		Query query = em.createQuery(jpql) ; 
		List<Student> list = query.getResultList() ;
		for(Student s : list) {
			System.out.println(s);
		}
		return "fetched" ;
	}
	public String deleteStudent(int id) {
		Student s = em.find(Student.class, id) ; 
		if(s != null) {
			et.begin(); 
			s.setAdhaar(null);
			s.setHostel(null);
			em.remove(s); 
			et.commit();
			return "delted" ;
		}else {
			return "Student not found" ;
		}
	}
}
