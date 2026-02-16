package MainFile;

import javax.persistence.Persistence;

import java.util.Arrays;

import javax.persistence.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ;
		College c = new College() ; 
		c.setCid(1);
		c.setLocation("Punjab");
		c.setName("LPU");
		c.setPincode("4568");
		Student s1 = new Student() ; 
		s1.setId(101);
		s1.setC(c);
		s1.setName("Roushan");
		s1.setBranch("CSE");
		Student s2 = new Student() ; 
		s2.setBranch("ML");
		s2.setId(102);
		s2.setId(102);
		s2.setName("Harsha Shrivastava");
		s2.setC(c);
		List<Student> list = new ArrayList<>() ; 
		list.add(s2) ; 
		list.add(s1) ; 
		c.setList(list);
		et.begin();  
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		et.commit(); 
	}
}
