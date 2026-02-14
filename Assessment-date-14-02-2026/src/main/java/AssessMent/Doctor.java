package AssessMent;

import javax.persistence.*;
import java.util.*;
@Entity 

public class Doctor {
	@Id
	int id ; 
	String dname  ; 
	String speical ;
	@OneToMany
	private List<Appointment> list ; 
	public List<Appointment> getAppoint(){
		return list ; 
	}
	public void setAppoint(List<Appointment> list) {
		this.list = list ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSpeical() {
		return speical;
	}
	public void setSpeical(String speical) {
		this.speical = speical;
	}
	public String toString() {
		return id + " " + dname + " " + speical  ; 
	}
	 
}
