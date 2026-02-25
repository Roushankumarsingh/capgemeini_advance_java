package Assessment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.*;

// class level annotation

@Configuration
@ComponentScan(basePackages = "Assessment")
public class DemoConfiguration {
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in) ; 
	}
	@Bean
	public List<String> getList(){
		return new ArrayList<>() ;
	}
}
