package Task;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeliveryService  {
	@PostConstruct
	public void initialise() {
		System.out.println("Print Delivery Service Ready");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Delivery Service closed");
	}
	public void delivered(String msg) {
		System.out.println("Delivering order " + msg); 
	}
}
