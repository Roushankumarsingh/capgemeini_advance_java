package Assignment;

public class PriceMain {
	public static void main(String[] args) {
		PriceService ps = new PriceService() ; 
		ps.setCode("MOB");
		ps.setPrice(1000.0);
		PriceDao pd = new PriceDao(ps) ;
	}
}
