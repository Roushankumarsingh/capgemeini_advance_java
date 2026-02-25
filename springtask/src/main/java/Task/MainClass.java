package Task;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(ConfigureClass.class) ;
//		UpiPayment up = ioc.getBean(UpiPayment.class) ;
//		up.processPayment(500.0);
		PaymentProcessor ps = ioc.getBean(PaymentProcessor.class) ; 
		ps.makePayment(5000.0);
	}
}
