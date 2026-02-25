package Task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class)  ; 
		OrderService service = ioc.getBean(OrderService.class) ;
		service.placeOrder("12345");

	}
}
