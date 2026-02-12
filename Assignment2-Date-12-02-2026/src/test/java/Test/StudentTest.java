package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Assignment.Student;
import Assignment.StudentDao;               

import javax.persistence.*;

public class StudentTest {
	
	StudentDao sd ; 
	static EntityManagerFactory emf ;
	EntityManager em  ;
	@BeforeAll 
	public static void initEmf() {
		emf = Persistence.createEntityManagerFactory("postgres") ;
//		sd = new StudentDao(emf) ;
	}
	
	@BeforeEach
	public void initEm() {
		em = emf.createEntityManager();
		sd = new StudentDao(em) ;
	}
	
	@Test
	public void testSaveStudent() {
		Student s = new Student() ;
		s.setId(106);
		s.setEmail("efgk@gmail.com");
		s.setMarks(95.0);
		s.setName("Golaki");
		String ans = sd.saveStudent(s)  ;
		assertEquals("Student saved",ans) ;
	}
	@Test
	public void testSaveStudentNot() {
		Student s  = null ; 
		String ans = sd.saveStudent(s) ; 
		assertEquals("Student is null",ans) ;
	}
	@Test
	public void testFindStudentById() {
		int id = 101 ; 
		String ans = sd.fetchStudent(id) ;
		assertEquals("User fetched" ,ans) ; 
	}
	@Test
	public void testFindStudentByIdNot() {
		int id = 1080 ;
		String ans = sd.fetchStudent(id) ; 
		assertEquals("User not found",ans) ;
	}
	@Test
	public void testUpdateStudent() {
		int id = 101 ; 
		double marks = 50.0 ; 
		String ans = sd.updateStudent(id, marks) ; 
		assertEquals("Updated User",ans) ;
	}
	@Test
	public void testUpdateStudentNot() {
		int id = 1040 ; 
		double marks = 50.0 ; 
		String ans = sd.updateStudent(id, marks) ; 
		assertEquals("User not found",ans) ;
	}
	@Test
	public void deleteStudent() {
		int id = 104 ; 
		String ans = sd.deleteStudent(id) ;
		assertEquals("User deleted" , ans) ; 
	}
	@Test
	public void deleteStudentNot() {
		int id = 1040 ; 
		String ans = sd.deleteStudent(id  ) ; 
		assertEquals("User not found" , ans) ;
	}
	@Test
	public void testStudentCount() {
		int num = 3 ; 
		int count = sd.totalCount() ; 
		assertEquals(num,count) ;
	}
	@Test
	public void fetchAll() {
		String ans = sd.fetchAll() ;
		assertEquals("User fetched",ans) ;
	}
	
	@AfterEach 
	public void closeEm() {
		em.close(); 
	}
	
	@AfterAll
	public static void closeEmf() {
		emf.close();
	}
}
