package Assessment;
import javax.persistence.*;
import java.util.*;

@Entity 

public class SupportTicket {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "support_seq")
	@SequenceGenerator(name = "support_seq" , sequenceName = "support_sequence" , allocationSize = 1 , initialValue = 12000 )
	int id ;
	String issue ; 
	String status ;
	@OneToOne
	private Order o ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(mappedBy = "st")
	private Product p ;
	
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order getO() {
		return o;
	}
	public void setO(Order o) {
		this.o = o;
	} 
}
