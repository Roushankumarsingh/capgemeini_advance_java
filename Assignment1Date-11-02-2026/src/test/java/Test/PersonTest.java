package Test;

import com.practice.Person;
import com.practice.PersonDao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test; 

public class PersonTest {
	PersonDao pd = new PersonDao() ; 
	
	@Test
	public void insertPerson1() {
		Person p = new Person() ; 
		p.setId(101) ; 
		p.setAdd("India") ; 
		p.setName("Dingaas");
		p.setPin(487520); 
		String ans = pd.insertPerson(p) ; 
		assertEquals("data inserted" , ans) ;
	}
	@Test
	public void insertPerson2() {
		Person p = new Person() ; 

		p.setId(10545) ; 
		p.setAdd("India") ; 
		p.setName("Dingaas");
		p.setPin(487520); 
		String ans = pd.insertPerson(null) ; 
		assertEquals("data exists" , ans) ;
	}
	@Test
	public void deletePerson1() {
		String ans = pd.deletePerson(10545) ; 
		assertEquals("User deleted" , ans) ;
	}
	@Test
	public void deletePerson2() {
		String ans = pd.deletePerson(1001) ; 
		assertEquals("User not found" , ans) ; 
	}
	@Test
	public void updatePerson1() {
		int id = 102  ;
		String add = "India" ; 
		String ans = pd.updatePerson(id, add) ; 
		assertEquals("Updated User" , ans) ;
	}
	@Test
	public void updatePerson2() {
		int id = 52001  ;
		String add = "India" ; 
		String ans = pd.updatePerson(id, add) ; 
		assertEquals("User not found" , ans) ;
	}
	@Test
	public void fetch() {
		int id = 103 ; 
		String ans = pd.fetchById(id) ;
		assertEquals("User fetched" , ans) ;
	}
	@Test
	public void fetch1() {
		int id = 103015 ; 
		String ans = pd.fetchById(id) ;
		assertEquals("User not found" , ans) ;
	}
	@Test
	public void fetch2() {
		String ans = pd.fetchAll() ; 
		assertEquals("fetched" , ans) ;
	}
}
