package Assignment;

import javax.persistence.*;

@Entity 

public class Purchase {
	@Id 
	int purchaseId ; 
	String orderDate ;
	double totalAmount ;
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	} 
	public String toString() {
		return purchaseId + " " + orderDate + " " + totalAmount ; 
	}
}
