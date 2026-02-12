package com.connectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.* ; 

public class StepsToConnectDataBase {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/college" ; 
		String user = "postgres" ; 
		String pass = "root" ; 
		try {
			Class.forName("org.postgresql.Driver") ;
			Connection connect = DriverManager.getConnection(url,user,pass) ; 
			System.out.println("Connection created!"); 
//			String insert_query = "insert into student values(105 , 'Gaurav' , 'CSE')" ; 
			Statement st = connect.createStatement() ; 
//			st.execute(insert_query) ; 
			String update_query = "update student set branch = 'ECE' where id = 105 " ; 
			st.execute(update_query) ; 
			String allRes = "select * from student" ; 
			ResultSet res = st.executeQuery(allRes) ; 
			while(res.next()) {
				int id = res.getInt("id") ; 
				String name = res.getString("name") ; 
				String branch = res.getString("branch") ; 
				System.out.println(id + " | " + name + " | " + branch); 
			}
			res.close(); 
			st.close(); 
			connect.close(); 
		} catch (ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
