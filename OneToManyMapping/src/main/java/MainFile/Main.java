package MainFile;

import javax.persistence.Persistence;

import java.util.Arrays;

import javax.persistence.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
//		EntityManager em = emf.createEntityManager() ; 
//		EntityTransaction et = em.getTransaction() ;
//		
//		Student s1 = new Student() ; 
//		s1.setS_name("Rohit");
//		s1.setStudent_id(101);
//		s1.setB_name("CSE");
//		
//		Student s2 = new Student() ; 
//		s2.setStudent_id(102);
//		s2.setS_name("Miller");
//		s2.setB_name("ECE"); 
//		
//		Student s3 = new Student() ; 
//		s3.setStudent_id(103);
//		s3.setS_name("Virat Kohli");
//		s3.setB_name("CSE");
//		
//		College c = new College() ;
//		c.setCid(1001);
//		c.setName("ABC");
//		c.setLocation("Delhi");
//		c.setPincode("0001");
//		List<Student> list = new ArrayList<>(Arrays.asList(s1,s2,s3)) ; 
//		c.setList(list);
//		et.begin();
//		em.persist(c);
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);
//		et.commit(); 
		OperationDao od = new OperationDao() ; 
//		College c = new College() ; 
//		c.setCid(120);
//		c.setName("LPU");
//		c.setLocation("Phagwara");
//		c.setPincode("141414") ; 
//		c.setList(new ArrayList<>()) ; 
//		System.out.println(od.createNewCollege(c)) ;
		Student s = new Student() ; 
//		s.setB_name("MEC");
//		s.setS_name("Harsha");
//		s.setStudent_id(1221); 
//		System.out.println(od.updateCollege(s, 120) );
		s.setStudent_id(127); 
		s.setB_name("CSE");
		s.setS_name("Yusufs");
//		System.out.println(od.createStudent(s));
//		System.out.println(od.updateCollege(s,120));
//		System.out.println(od.deleteStudent(127));
		System.out.println(od.deleteCollege(120));
		
	}
}
