package Assessment;

import javax.persistence.*;

@Entity

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ; 
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	String name ; 
	String phone ; 
	String email ;                                           
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Passport p  ; 
	public Passport getP() {
		return p;
	}
	public void setP(Passport p) {
		this.p = p;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
