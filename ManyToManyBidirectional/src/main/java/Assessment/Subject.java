package Assessment;
import java.util.List;

import javax.persistence.*;

@Entity 

public class Subject {
	@Id 
	int id ; 
	String name ; 
	int days ;
	@ManyToMany(mappedBy = "l")
	List<Student> list ; 
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
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
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	} 
}
