package com.connectDatabase;
import java.sql.*; 
public class FindStudentData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/college" ; 
		String user = "postgres" ; 
		String pass = "root" ; 
		try {
			Class.forName("org.postgresql.Driver") ; 
			Connection connect = DriverManager.getConnection(url,user,pass) ; 
			System.out.println("Connection created"); 
			Statement st = connect.createStatement() ; 
			String query = "select * from student" ; 
			ResultSet res = st.executeQuery(query)  ;
			while(res.next()) {
				int id = res.getInt("id") ; 
				String name = res.getString("name") ; 
				String branch = res.getString("branch") ; 
				System.out.println(id + " | " + name + " | " + branch); 
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		catch(SQLException e) {
			e.printStackTrace(); 
		}
	}
}
