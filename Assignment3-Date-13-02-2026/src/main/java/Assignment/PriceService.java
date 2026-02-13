package Assignment;

public class PriceService {
	String code ; 
	double price ; 
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double calculateFinal(String code , double price) {
//		double finalRes = 0.0  ; 
//		double discount = 0.0 ;
//		if(code.equals("MOB") && price >= 1000 ) {
//			 discount = (price * 10.0) / 100.0 ; 
//		}
//		else if(code.equals("LAP" ) && price >= 2000) {
//			discount = (price * 20.0) / 100.0 ; 
//		}
//		else {
//			discount = 0.0 ; 
//		}
//		finalRes = price - discount ;
//		return finalRes ;
		return 0 ; 
	}
}
