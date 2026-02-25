package Task;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.* ;
import javax.annotation.PreDestroy;

@Component

public class Logger {
	@PostConstruct
	public void initialise() {
		System.out.println("Logger initialised") ;
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Logger destroyed");
	}
	public void logger() {
		System.out.println("logger is logged") ;
	}
}
