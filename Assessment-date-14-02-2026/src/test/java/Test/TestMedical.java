package Test;

import javax.persistence.*;

import org.junit.jupiter.api.Test;

import AssessMent.UserService;

public class TestMedical {
	UserService us = new UserService() ;
	@Test
	public void oneToOneTest() {
		us.registerPatient(); 
	}
	@Test
	public void oneToManytest() {
		us.addDoctor(); 
	}
	@Test
	public void updateTest() {
		us.updateAppointFee();
	}
	@Test
	public void deleteTest() {
		us.deleteTest();
	}
}
