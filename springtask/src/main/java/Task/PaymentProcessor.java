package Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class PaymentProcessor {
	
	private PaymentService ps ; 
	
	@Autowired
	private Logger logger ;
	
	public PaymentProcessor(PaymentService ps) {
		this.ps = ps ; 
	}
	public void makePayment(double amount) {
		ps.processPayment(amount);
		logger.logger();
	}
}
