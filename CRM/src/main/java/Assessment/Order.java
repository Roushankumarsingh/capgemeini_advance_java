package Assessment;
import javax.persistence.*;
import java.util.*;

@Entity 

@Table (name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "order_seq")
	@SequenceGenerator(name = "order_seq" , sequenceName = "order_sequence" , initialValue = 10000 , allocationSize = 1)
	int id ; 
	String date ; 
	double amount ; 
	@ManyToOne
	@JoinColumn
	private Lead l ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToMany(mappedBy = "ol")
	List<Product> ps ; 
	
	public List<Product> getPs() {
		return ps;
	}
	public void setPs(List<Product> ps) {
		this.ps = ps;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Lead getL() {
		return l;
	}
	public void setL(Lead l) {
		this.l = l;
	} 
	
}
