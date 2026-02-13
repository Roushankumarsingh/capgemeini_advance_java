package Assignment;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;


@Entity
@Table 

public class Student {
	@Id
	@Column(name = "StudentId")
	int id;
	String name;
	@OneToOne // one to one mapping
	private Adhaar adhar ;
	public Adhaar getAdhaar() {
		return adhar ; 
	}
	public void setAdhaar(Adhaar adhar) {
		this.adhar = adhar ;
	}
	@OneToOne 
	private Hostel h ; 
	public Hostel getHostel() {
		return h ; 
	}
	public void setHostel(Hostel h) {
		this.h = h ; 
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
	public String toString() {
		return id + " "  + name +  " Adhaar" + adhar.getId() + " Hostel Id " + h.getId()  ; 
	}
}
