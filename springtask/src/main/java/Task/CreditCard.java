package Task;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy

public class CreditCard implements PaymentService {
	
	private Logger logger ;
	
	public CreditCard(Logger logger) {
		this.logger = logger;
	}
	
	public void processPayment(double amount) {
		System.out.println("Total amount is :- " + amount);
		logger.logger();
	}

}
