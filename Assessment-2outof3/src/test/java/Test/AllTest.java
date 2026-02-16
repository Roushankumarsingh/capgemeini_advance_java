package Test;

import javax.persistence.*;

import org.junit.jupiter.api.Test;

import Assignment.UserService;

public class AllTest {
	UserService us = new UserService() ;
	@Test
	public void testRegister() {
		us.RegisterUser();
	}
	@Test
	public void addPayment() {
		us.addPayment(); 
	}
	@Test
	public void fetchOrders() {
		us.fetchUserWithOrder(); 
	}
	@Test
	public void updateAmount() {
		us.updateAmount();
	}
	@Test 
	public void deleteAmount() {
		us.deleteUser();
	}
	
}
