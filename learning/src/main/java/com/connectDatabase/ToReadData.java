package com.connectDatabase;
import java.sql.* ; 

import java.util.* ; 

public class ToReadData {
	public static void main(String[] args) {
		System.out.println("We are going to insert from the user input");
		String url = "jdbc:postgresql://localhost:5433/college" ; 
		String user = "postgres" ; 
		String pass = "root" ; 
		Scanner sc = new Scanner(System.in); 
		try {
			Class.forName("org.postgresql.Driver") ;
			Connection connect = DriverManager.getConnection(url,user,pass ) ; 
			System.out.println("Connection created !...");
			String insert_query = "insert into student values(?,?,?)" ; 
			PreparedStatement ps = connect.prepareStatement(insert_query) ; 
			System.out.println("Enter id :- " ) ; 
			int id  = sc.nextInt()  ; 
			sc.nextLine(); // consumes all the 
			ps.setInt(1, id);
			System.out.println("Enter name :- "); 
			String name = sc.nextLine() ;
			
			ps.setString(2, name); 
			System.out.println("Enter the value of the branch");
			String branch = sc.nextLine();
			ps.setString(3, branch);
			ps.execute() ; 
			connect.close(); 
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}
