package Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component


public class Restaurant {
	@Autowired
	private DeliveryService ds ; 
	public void setDelivery(DeliveryService ds) {
		this.ds = ds ;
	}
	public void prepare(String id) {
		System.out.println("Preparing order :- " + id);
		ds.delivered("Order " + id + " is placed");
	}
}
