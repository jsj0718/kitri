package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx1Customer {
	public static void main(String[] args) {
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
		ResultSet rs = null;
		
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
		
		Scanner sc = new Scanner(System.in);
		System.out.print("고객 검색: ");
		String customerNameVar = sc.nextLine();
		sc.close();
		
		try {
			// 실행쿼리 작성
//			String SQL = "SELECT * FROM BOOK WHERE BOOKNAME LIKE '%" + bookNameVar + "%'";
			String SQL = "SELECT * FROM CUSTOMER WHERE NAME LIKE ?";
			// DB 쿼리 실행을 위해 Statement, PreparedStatement를 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" + customerNameVar + "%");
			// 쿼리 실행한 결과를 ResultSet에 담아오기
			rs =  pstmt.executeQuery();
			// ResultSet에 담은 결과를 while문을 통해 하나씩 꺼내오기
			while(rs.next()) {
				int custID = rs.getInt("CUSTID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				
				System.out.printf("책 번호 : %d, 책 이름 : %s, 출판사 : %s, 번호 : %s\n", custID, name, address, phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed()) rs.close();
//				if (stmt != null && !stmt.isClosed()) stmt.close();
				if (pstmt != null && !pstmt.isClosed()) pstmt.close();
				if (conn != null && !conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
