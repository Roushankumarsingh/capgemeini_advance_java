package Assignment;

import javax.persistence.*;

@Entity
@Table (name="student_info")

public class Student {
	@Id
	@Column (name="StudentId")
	int id ; 
	@Column (name="StudentName")
	String name ; 
	@Column (name="Email" , unique = true)
	String email ; 
	@Column (name = "StudentMarks")
	double marks ;
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
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String toString() {
		return id + " " + name + " "  + email + " " + marks ; 
	}
}
