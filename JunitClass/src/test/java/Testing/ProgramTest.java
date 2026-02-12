package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import Junit.EvenOrOdd;
import Junit.Program;

public class ProgramTest {
//	@ParameterizedTest
//	@ValueSource (strings = {"tenet" , "radar" , "aba" , "abcd"}) 
	public void isPalindromeTest(String str) {
		Program p = new Program() ;
		assertTrue(p.isPalindrome(str)) ; 
	}
	@ParameterizedTest
	@CsvSource({
		"1,2,3" , 
		"4,3,7" , 
		"5,4,9"
	})
	public void addTest(int a , int b , int result) {
		Program p = new Program() ; 
		int actualRes = p.add(a, b) ; 
		assertEquals(result,actualRes) ;
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/Extension.csv" , numLinesToSkip = 1 )  // here we have to give the relative path 
	public void evenOrOddTest(String input , String expected) {
		EvenOrOdd eoo = new EvenOrOdd() ;
		String actualres = eoo.evenOrOdd(Integer.parseInt(input)) ; 
		assertEquals(expected , actualres) ;
	}
}
