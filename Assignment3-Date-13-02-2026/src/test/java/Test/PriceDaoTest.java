package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Assignment.PriceDao;
import Assignment.PriceService;

public class PriceDaoTest {
	@Test
	public void priceTest() {
		// step 1 : create mock object 
		PriceService ps = mock(PriceService.class) ; 
		// step 2 : also return result 
		when(ps.calculateFinal("MOB", 1000.0)).thenReturn(900.0) ; 
		// step 3 : now create with the dao class 
		PriceDao pd = new PriceDao(ps) ; 
		double finalPrice = pd.priceService("MOB" , 1000.0) ; 
		assertEquals(900.0,finalPrice) ;
	}
	@Test
	public void priceTest2() {
		PriceService ps = mock(PriceService.class) ;  // create mock object 
		// operation 
		when(ps.calculateFinal("LAP", 2000.0)).thenReturn(1600.0) ;
		PriceDao pd  = new PriceDao(ps) ;
		double res = pd.priceService("LAP", 2000.0)  ; 
		assertEquals(1600,res); 
	}
	@Test
	public void priceTest3() {
		PriceService ps = mock(PriceService.class) ; 
		when(ps.calculateFinal("MAP", 1500.0)).thenThrow(new RuntimeException("Invalid Price")) ;
		PriceDao pd = new PriceDao(ps) ; 
		assertThrows(RuntimeException.class , () -> {
			pd.priceService("MAP", 1500.0)  ; 
		}) ;
	}
}
