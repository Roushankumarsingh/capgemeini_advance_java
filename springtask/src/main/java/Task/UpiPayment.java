package Task;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("regular")
@Scope("prototype")
public class UpiPayment implements PaymentService {
	
	private Logger logger ; 
	public UpiPayment(Logger logger) {
		this.logger = logger ;
	}
	
	public void processPayment(double amount) {
		System.out.println("Amount is good");
		logger.logger();
	}

}
