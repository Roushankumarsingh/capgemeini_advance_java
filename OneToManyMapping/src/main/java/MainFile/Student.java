package MainFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity 
@Table (name = "student_table")

public class Student {
	@Id
	int id; 
	String name ; 
	String branch ; 
	@ManyToOne
	@JoinColumn
	private College c ;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public College getC() {
		return c;
	}
	public void setC(College c) {
		this.c = c;
	} 
	
}
