package Assessment;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml") ;
//		Person person = ioc.getBean("person" , Person.class) ;
//		System.out.println(person);
//		person.message() ;
		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml") ; 
		Employee e = ioc.getBean("employee",Employee.class) ; 
		System.out.println(e);
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getSalary());
	}
}
