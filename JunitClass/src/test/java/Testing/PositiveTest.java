package Testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Junit.PositiveProgram;

public class PositiveTest {
//	@ParameterizedTest
	@ValueSource (ints = {1,4,5,-1}) 
	public void isPositive(int num) {
		PositiveProgram p = new PositiveProgram() ;
		assertTrue(p.isPos(num));
	}
}
