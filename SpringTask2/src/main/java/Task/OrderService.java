package Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class OrderService {
	@Autowired
	private DeliveryService ds ; 
	public OrderService(DeliveryService ds) {
		this.ds = ds ;
	}
	@Autowired
	private Restaurant r ; 
	public void placeOrder(String id) {
		System.out.println(id);
		r.prepare(id);
	}
}
