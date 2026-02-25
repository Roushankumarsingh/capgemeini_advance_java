package Task;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



public interface PaymentService {
	public void processPayment(double amount) ;
}
