package Assignment;

import javax.persistence.*;

@Entity 

public class Payment {
	@Id
	int paymentId ;
	String mode ; 
	double amount ; 
	@ManyToOne
	private Purchase p ;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Purchase getP() {
		return p;
	}
	public void setP(Purchase p) {
		this.p = p;
	} 
	public String toString() {
		return paymentId + " " + mode + " " + amount ;
	}
}
