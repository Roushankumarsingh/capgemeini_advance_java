package Assessment;
import java.util.* ; 

import javax.persistence.*;

@Entity 

public class SalesEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sales_seq" )
	@SequenceGenerator(name = "sales_seq" , sequenceName = "sales_sequence" , initialValue = 11000 , allocationSize = 1)
	
	int id ; 
	String name ; 
	String department ; 
	@ManyToOne
	private Address a ; 
	@ManyToOne
	@JoinColumn
	private Lead li ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Address getA() {
		return a;
	}
	public void setA(Address a) {
		this.a = a;
	}
	public Lead getL() {
		return li;
	}
	public void setL(Lead li) {
		this.li = li;
	} 
	
}
