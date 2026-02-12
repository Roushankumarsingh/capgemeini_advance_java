package com.connectDatabase;
import java.sql.*; 
import java.util.*; 

public class EmloyeeCRUd {
	public static void insert_user(Connection connect) {
		Scanner sc = new Scanner(System.in) ; 
		try {
			String insert_query = "insert into employee values(?,?,?)" ; 
			PreparedStatement ps = connect.prepareStatement(insert_query) ;
			System.out.println("Enter the id :- "); 
			int id = sc.nextInt() ; 
			sc.nextLine(); // consumes the next line 
			ps.setInt(1, id); 
			System.out.println("Enter the name of the employee");
			String name = sc.nextLine() ;
			System.out.println("Enter the salary"); 
			int sal = sc.nextInt() ; 
			sc.nextLine() ;
			ps.setString(2, name);
			ps.setInt(3, sal); 
			ps.execute() ; 
			connect.close(); 
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	public static void update_user(Connection connect) {
		Scanner sc = new Scanner(System.in) ; 
		try {
			String update = "update employee set sal = ? where id = ?" ; 
			PreparedStatement ps = connect.prepareStatement(update) ; 
			System.out.println("Enter the salary"); 
			int salary = sc.nextInt() ; 
			sc.nextLine() ; 
			System.out.println("Enter id :- ") ; 
			int id = sc.nextInt() ; 
			sc.nextLine() ; 
			ps.setInt(2, id);
			ps.setInt(1, salary);
			ps.execute() ; 
			connect.close(); 
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	public static void delete_user(Connection connect) {
		Scanner sc = new Scanner(System.in) ; 
		try {
			String delete = "delete from  employee where id = ?" ; 
			PreparedStatement ps = connect.prepareStatement(delete) ; 
			System.out.println("Enter id :- ") ; 
			int id = sc.nextInt() ; 
			sc.nextLine() ; 
			ps.setInt(1, id);
			ps.execute() ; 
			connect.close(); 
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	public static void read_allUser(Connection connect) {
		String allUser = "select * from employee" ; 
		try {
			Statement st = connect.createStatement() ; 
			ResultSet res = st.executeQuery(allUser) ; 
			while(res.next()) {
				System.out.println(res.getInt(1) + " | " + res.getString(2)  + " | " + res.getInt(3) )  ;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void read_from_id(Connection connect) {
		String allUser = "select * from employee where id = ?" ;
		Scanner sc = new Scanner(System.in) ; 
		try {
			PreparedStatement ps = connect.prepareStatement(allUser) ; 
			System.out.println("Enter the id :- ") ; 
			int id = sc.nextInt() ; 
			sc.nextLine() ; 
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery() ; 
			if(res.next()) {
				System.out.println(res.getInt(1) + " | " + res.getString(2) + " | " + res.getInt(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/college"  ; 
		String user = "postgres" ; 
		String pass = "root" ; 
		Scanner sc = new Scanner(System.in) ; 
		try {
			Class.forName("org.postgresql.Driver") ; 
			Connection connect = DriverManager.getConnection(url,user,pass) ; 
//			insert_user(connect) ; 
//			update_user(connect) ; 
//			delete_user(connect) ; 
//			read_allUser(connect) ; 
			read_from_id(connect) ;
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}
