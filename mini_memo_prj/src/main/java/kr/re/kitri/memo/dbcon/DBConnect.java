package kr.re.kitri.memo.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		String user = "web";
		String password = "web";
		
		// url - ip, port, sid
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
