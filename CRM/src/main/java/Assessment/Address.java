package Assessment;

import javax.persistence.*;
import java.util.*;

@Entity 

public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "add_seq") 
	@SequenceGenerator(name = "add_seq" , sequenceName = "add_sequence" , initialValue = 100 , allocationSize = 1 )
	int id ; 
	String city ; 
	String state ;
	String pincode ;
	@OneToOne
	@JoinColumn
	private Customer c ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	} 
	
}
