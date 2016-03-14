package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	
	
	 public  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 public  static final String DB_URL = "jdbc:mysql://localhost:3306/etudiants";
	 private static final String USER = "root";
	 private static final String PASS = "";
	 
	
	@SuppressWarnings("finally")
	public static Connection createConnection () throws Exception {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			
		} catch (Exception e ){
			e.printStackTrace();
		} 
		
		return con;
	}
	
	
	
	
	

}