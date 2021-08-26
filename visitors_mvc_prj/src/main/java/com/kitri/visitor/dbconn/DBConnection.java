package com.kitri.visitor.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		String user = "web";
		String password = "web";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc lib 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url, user, password 오류");
			e.printStackTrace();
		}
		return conn;
	}
	
}
