package Mapping;

import javax.persistence.Persistence;

public class User {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("postgres") ;
	}
}
