package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.practice.Passport;
import com.practice.PassportDao;
import com.practice.Person;


public class PassportTest {
	PassportDao pd = new PassportDao() ; 
	
	@Test
	public void insertPerson1() {
		Passport p = new Passport() ; 
		p.setId(10545) ; 
		p.setAdd("India") ; 
		p.setName("Dingaas");
		p.setGender('M'); 
		String ans = pd.insertPass(p) ; 
		assertEquals("Passport inserted" , ans) ;
	}
	@Test
	public void insertPerson2() {
		String ans = pd.insertPass(null) ; 
		assertEquals("Passport not found" , ans) ;
	}
	@Test
	public void deletePerson1() {
		String ans = pd.deletePassport(101) ; 
		assertEquals("Passport deleted" , ans) ;
	}
	@Test
	public void deletePerson2() {
		String ans = pd.deletePassport(1001) ; 
		assertEquals("Passport not found" , ans) ; 
	}
	@Test
	public void updatePerson1() {
		int id = 102  ;
		String add = "India" ; 
		String ans = pd.updatePassport(id, add) ; 
		assertEquals("Updated Passport" , ans) ;
	}
	@Test
	public void updatePerson2() {
		int id = 52001  ;
		String add = "India" ; 
		String ans = pd.updatePassport(id, add) ; 
		assertEquals("Passport not found" , ans) ;
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
