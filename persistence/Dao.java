package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	public Connection con;
	public PreparedStatement stmt;
	public ResultSet rs;
	
	
	//usando banco mysql
	public void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nome do banco","root","senha");
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void close() {
		try {
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
