package com.connectDatabase;

import java.sql.SQLException;
import java.sql.* ; 

public class CrudJdbcEmp {
	public static void insertData(Connection connect) throws SQLException {
		String insert_query = "insert into employee values(106,'Harsha' , 25000)" ; 
		Statement st = connect.createStatement() ; 
		st.execute(insert_query) ; 
		System.out.println("Query inserted"); 
	}
	public static void deleteData(Connection connect) throws SQLException {
		String delete_query = "delete from employee where id = 102" ; 
		Statement st = connect.createStatement() ; 
		st.execute(delete_query) ; 
		System.out.println("Query deleted"); 
	}
	public static void updateData(Connection connect) throws SQLException{
		String query = "update employee set sal = 12500 where id = 101" ; 
		Statement st = connect.createStatement() ; 
		st.execute(query) ; 
		System.out.println("Updated Salary") ; 
	}
	public static void showData(Connection connect ) throws SQLException{
		String query = "select * from employee" ; 
		Statement st  = connect.createStatement() ; 
		ResultSet res = st.executeQuery(query ) ; 
		while(res.next()) {
			System.out.println(res.getInt(1) + " | " + res.getString(2) + " | " + res.getInt(3)); 
		}
	}
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/college" ; 
		String user = "postgres" ; 
		String pass = "root" ; 
		try {
			Class.forName("org.postgresql.Driver") ; 
			Connection connect = DriverManager.getConnection(url,user,pass)  ; 
			System.out.println("Connection created") ;
			insertData(connect) ; 
			updateData(connect)  ; 
			deleteData(connect) ; 
			showData(connect) ;
		}
		catch(SQLException e) {
			e.printStackTrace(); 
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
