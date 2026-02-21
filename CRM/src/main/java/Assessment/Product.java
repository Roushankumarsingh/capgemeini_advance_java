package Assessment;

import javax.persistence.*;
import java.util.*;


@Entity

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "product_seq")
	@SequenceGenerator(name = "product_seq" , sequenceName = "product_sequence" , initialValue = 10500 , allocationSize = 1)
	int id ; 
	String name ; 
	double amount ;
	@ManyToMany
	@JoinTable
	private List<Order> ol ;
	
	@ManyToMany
	private List<SalesEmployee> se ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@OneToOne
	@JoinColumn
	private SupportTicket st ;	

	public SupportTicket getSt() {
		return st;
	}

	public void setSt(SupportTicket st) {
		this.st = st;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Order> getOl() {
		return ol;
	}

	public void setOl(List<Order> ol) {
		this.ol = ol;
	}

	public List<SalesEmployee> getSe() {
		return se;
	}

	public void setSe(List<SalesEmployee> se) {
		this.se = se;
	} 
	
}
