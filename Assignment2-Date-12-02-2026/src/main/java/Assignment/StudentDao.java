package Assignment;
import javax.persistence.*;
import java.util.*;

public class StudentDao {
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
//	EntityManager em = emf.createEntityManager(); 
//	EntityTransaction et = em.getTransaction() ;
	private EntityManager em ;
	public StudentDao(EntityManager em) {
		this.em = em ;
	}
	public String saveStudent(Student s) {
		EntityTransaction et = em.getTransaction() ;
		if(s != null) {
			et.begin(); 
			em.persist(s);
			et.commit();
			return "Student saved";
		}else {
			return "Student is null" ;
		}
	}
	public String updateStudent(int id , double marks) {
		EntityTransaction et = em.getTransaction() ;
		Student s = em.find(Student.class, id) ;
		if(s != null) {
			et.begin(); 
			s.setMarks(marks);
			em.merge(s) ;
			et.commit();
			return "Updated User" ; 
		}
		else {
			return "User not found" ;
		}
	}
	public String deleteStudent(int id) {
		EntityTransaction et = em.getTransaction() ;
		Student s = em.find(Student.class, id) ; 
		if(s != null) {
			et.begin(); 
			em.remove(s); 
			et.commit();
			return "User deleted" ; 
		}
		else {
			return "User not found";
		}
	}
	public String fetchStudent(int id) {
		EntityTransaction et = em.getTransaction() ;
		Student s = em.find(Student.class, id) ; 
		if(s != null) {
			System.out.println(s);
			return "User fetched" ;
		}
		else {
			return "User not found" ;
		}
	}
	public String fetchAll() {
		EntityTransaction et = em.getTransaction() ;
		String jpql = "select s from Student s" ; 
		Query query = em.createQuery(jpql) ; 
		List<Student>  list = query.getResultList() ;
		for(Student s : list) {
			System.out.println(s);
		}
		return "User fetched" ;
	}
	public int totalCount() {
		EntityTransaction et = em.getTransaction() ;
		String jpql = "select s from Student s" ; 
		Query query = em.createQuery(jpql) ; 
		List<Student> list = query.getResultList() ; 
		return list.size() ;
	}
}
