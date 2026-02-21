package Assessment;
import javax.persistence.*;
import java.util.*;

public class MainService {
	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("postgres") ;
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction et = em.getTransaction() ;
		Student s1 = new Student() ; 
		s1.setName("Miller") ; 
		s1.setBranch("CSE");
		
		Student s2 = new Student() ; 
		s2.setName("Rohit");
		s2.setBranch("ECE") ;
		
		Subject sub1 = new Subject() ; 
		sub1.setId(101);
		sub1.setName("Micro-porcessor"); 
		sub1.setDays(15);
		
		Subject sub2 = new Subject() ; 
		sub2.setId(102);
		sub2.setName("Machine Learning");
		sub2.setDays(25);
		
		Subject sub3 = new Subject() ; 
		sub3.setId(103);
		sub3.setName("Software Engineering");
		sub3.setDays(30);
		
		List<Student> studentList = new ArrayList<>() ; 
		studentList.add(s1) ;
		studentList.add(s2) ;
		
		List<Subject> subjectList = new ArrayList<>()  ; 
		subjectList.add(sub1)  ; 
		subjectList.add(sub1)  ; 
		subjectList.add(sub1)  ; 
		
		// student --> subject 
		s1.setL(subjectList);
		s2.setL(subjectList);
		
		// subject --> student 
		sub1.setList(studentList);
		sub2.setList(studentList);
		sub3.setList(studentList);
		
		et.begin(); 
		em.persist(s1);
		em.persist(s2);
		et.commit();
		em.close();
		emf.close();
		
	}
}
