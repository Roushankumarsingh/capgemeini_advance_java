package Assessment;
import javax.persistence.*;
import java.util.*;

@Entity 

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ; 
	String name ; 
	String branch ;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	List<Subject> l ;
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
	public List<Subject> getL() {
		return l;
	}
	public void setL(List<Subject> l) {
		this.l = l;
	}
}
