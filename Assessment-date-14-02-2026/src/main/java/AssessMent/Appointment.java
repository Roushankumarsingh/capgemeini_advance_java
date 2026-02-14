package AssessMent;

import javax.persistence.*;  

@Entity 

public class Appointment {
	@Id
	int aid ; 
	String visitDate ; 
	double fee  ; 
	@ManyToOne 
	private Patient p ; 
	public Patient getPatient() {
		return p ; 
	}
	public void setPatient(Patient p) {
		this.p = p ; 
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String toString() {
		return aid + " " + visitDate + " " + fee ; 
	}
}
