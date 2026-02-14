package AssessMent;


import javax.persistence.*;

@Entity 


public class Patient {
	@Id 
	int pid ;
	String pname ; 
	int page ; 
	String contact ;
	@OneToOne  // one to one mapping 
	private MedicalRecord md ;  
	public MedicalRecord getMedical() {
		return md ; 
	}
	public void setMedical(MedicalRecord md) {
		this.md = md ;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	} 
	public String toString() {
		return pid + " " + pname + " " + page + " " + contact + " " ;
	}
}
