package Assignment;

import javax.persistence.*;

@Entity
@Table(name = "Adhar_card")

public class Adhaar {
	@Id
	int id ; 
	String name ; 
	String add ;
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
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	} 
	public String toString() {
		return id + " " + name + " " + add ;
	}
}
