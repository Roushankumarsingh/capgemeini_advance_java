package ManyPack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_info")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	int eid;
	String ename;
	double esalary;
	String edesign;
	@ManyToOne
	private Department d ; 
	public Department getDepart() {
		return d ; 
	}
	public void setDepart(Department d) {
		this.d = d ;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public String getEdesign() {
		return edesign;
	}
	public void setEdesign(String edesign) {
		this.edesign = edesign;
	}
}
