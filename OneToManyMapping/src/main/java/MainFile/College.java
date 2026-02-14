package MainFile;

import java.util.List;

import javax.persistence.*;


@Entity
@Table (name = "College_info") 
public class College {
	@Id 
	int cid ; 
	String name ; 
	String location ; 
	String pincode ;
	@OneToMany
	List<Student> list ;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
}
