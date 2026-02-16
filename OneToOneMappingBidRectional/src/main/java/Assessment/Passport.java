package Assessment;
import javax.persistence.*;

@Entity

public class Passport {
	@Id
	int id ; 
	String name ; 
	String dob; 
	@OneToOne(mappedBy="p")
	private Person p ;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	} 
	
	
}
