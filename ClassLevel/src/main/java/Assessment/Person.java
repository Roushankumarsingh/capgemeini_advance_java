package Assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;

@Component
public class Person {
	@Autowired
	private Mobile mobile ;  // null , reference null 
	
	@Autowired
	private Scanner scan ; // null 
	
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	public void message() {
		System.out.println("Hii");
	}
	public Mobile getMobile() {
		return mobile ;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile ;
	}
}
