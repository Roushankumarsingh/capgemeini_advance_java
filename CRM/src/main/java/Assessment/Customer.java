package Assessment;

import javax.persistence.*;
import java.util.*;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	String name ; 
	String email ; 
	String phone ;
	@OneToOne(mappedBy = "c")
	private Lead l ; 
	public Lead getL() {
		return l;
	}
	public void setL(Lead l) {
		this.l = l;
	}
	@OneToOne(mappedBy = "c")
	private Address a ; 
	public Address getA() {
		return a;
	}
	public void setA(Address a) {
		this.a = a;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	} 
	
}
