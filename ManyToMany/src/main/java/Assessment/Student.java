package Assessment;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "StudentSubject")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id  ; 
	String name ; 
	char gender ; 
	String branch ;
	@ManyToMany
	private List<Subject> s ; 
	public List<Subject> getS() {
		return s;
	}
	public void setS(List<Subject> s) {
		this.s = s;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
}
