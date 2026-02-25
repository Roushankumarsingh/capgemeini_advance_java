package Assessment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.*;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class) ; 
//		Employee e = ioc.getBean(Employee.class) ;
//		System.out.println(e);
//		System.out.println(e.getId());
//		System.out.println(e.getName());
//		System.out.println(e.getSal());
//		Person p = ioc.getBean(Person.class) ;
//		System.out.println(p);
//		System.out.println(p.getMobile());
//		System.out.println(p.getScan());
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class) ;
		Demo d = ioc.getBean(Demo.class) ; 
		System.out.println(d.getList());
		System.out.println(d.getMobile());
	}
}