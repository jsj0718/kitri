package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		// 계정
		String user = "madang";
		// 비밀번호
		String password = "madang";
		// url - ip, port, sid
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// connection - 드라이버 로딩 (ojdbc.jar 파일을 활용하여 DB 연결)
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		
		// DB 연결 (연결 완료)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar가 없습니다. (드라이버가 존재하지 않습니다.)");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url, user, password 및 DB가 켜져 있는지 확인하세요.");
			e.printStackTrace();
		}
		
		return conn;
	}
}
