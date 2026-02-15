package Assignment;

import java.util.*;
import javax.persistence.*;

@Entity 

public class User {
	@Id
	int userId ;
	String name ; 
	String email ; 
	@OneToOne
	private Profile p ; 
	@OneToMany
	private List<Purchase> list ;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Profile getP() {
		return p;
	}
	public void setP(Profile p) {
		this.p = p;
	}
	public List<Purchase> getList() {
		return list;
	}
	public void setList(List<Purchase> list) {
		this.list = list;
	}
	public String toString() {
		return userId + " " + name + " " + email ;
	}
	
}
