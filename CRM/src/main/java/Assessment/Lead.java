package Assessment;
import javax.persistence.*;
import java.util.*;

@Entity 

public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "lead_seq")
	@SequenceGenerator(name = "lead_seq" , sequenceName = "lead_sequence" , initialValue = 1000 , allocationSize = 1)
	int id ;
	String source ; 
	String status ;
	@OneToOne
	@JoinColumn
	private Customer c ; 
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	
	@OneToMany(mappedBy = "l")
	private List<Order> o ; 
	
	
	public List<Order> getO() {
		return o;
	}
	public void setO(List<Order> o) {
		this.o = o;
	}
	
	@OneToMany(mappedBy = "li")
	private List<SalesEmployee> list ; 
	
	
	public List<SalesEmployee> getList() {
		return list;
	}
	public void setList(List<SalesEmployee> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
