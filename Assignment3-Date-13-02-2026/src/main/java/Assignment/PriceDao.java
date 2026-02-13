package Assignment;

public class PriceDao {
	PriceService ps ; 
	public PriceDao(PriceService ps) {
		this.ps = ps ;
	}
	public double priceService(String code , double price ) {
		return ps.calculateFinal(code,price) ; 
	}
}
