package Assessment;

import java.util.List;
import java.util.*; 

import javax.persistence.*;

@Entity
@Table(name = "users_info") 

public class Users {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ; 
	String name ; 
	String password ; 
	String email ; 
	@OneToMany
	private List<Post> list ;
	@OneToMany
	private List<Comments> l ;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Post> getList() {
		return list;
	}
	public void setList(List<Post> list) {
		this.list = list;
	}
	public List<Comments> getL() {
		return l;
	}
	public void setL(List<Comments> l) {
		this.l = l;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
}
