package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.*;

import org.junit.jupiter.api.Test;

import Assignment.Adhaar;
import Assignment.AllInsertDao;
import Assignment.Hostel;
import Assignment.Student;

public class StudentTest {
	AllInsertDao al = new AllInsertDao() ;
	@Test
	public void insertHostel() {
		Hostel h = new Hostel() ; 
		h.setId(152) ;
		h.setPrice(5000.0);
		String res = al.insertHostel(h) ; 
		assertEquals("inserted" , res) ;
	}
	@Test
	public void insertHostel2() {
		String res = al.insertHostel(null) ; 
		assertEquals("Hostel is null" , res) ;
	}
	@Test
	public void insertAdhaar() {
		Adhaar a = new Adhaar() ; 
		a.setAdd("Rajasthan");
		a.setId(10150);
		a.setName("Allen"); 
		String res = al.insertAdhaar(a) ; 
		assertEquals("inserted" , res) ;
	}
	@Test
	public void insertAdhaar2() {
		String res = al.insertAdhaar(null) ; 
		assertEquals("a is null" , res) ;
	}
	@Test
	public void insertStudent() {
		Student s = new Student() ;
		Adhaar a = new Adhaar() ; 
		a.setAdd("Rajasthan");
		a.setId(10150);
		a.setName("Allen"); 
		Hostel h = new Hostel() ; 
		h.setId(152) ;
		h.setPrice(5000.0);
		s.setAdhaar(a);
		s.setHostel(h);
		s.setId(14589623);
		s.setName("Allen");
		String res = al.insertStudent(s)  ; 
		assertEquals("inserted" , res) ; 
	}
	@Test
	public void insertStudent2() {
		Student s = null ; 
		String res = al.insertStudent(s)  ; 
		assertEquals("Student is null" , res) ;
	}
	@Test
	public void fetchStudent() {
		String res = al.fetchStudent() ; 
		assertEquals("fetched" , res) ;
	}
	@Test
	public void deleteStudent() {
		int id = 1458965 ; 
		String res = al.deleteStudent(id) ; 
		assertEquals("deleted",res) ;
	}
	@Test
	public void deleteStud() {
		int id = 9854 ; 
		String res = al.deleteStudent(id) ; 
		assertEquals("Student not found" , res) ;
	}
}
