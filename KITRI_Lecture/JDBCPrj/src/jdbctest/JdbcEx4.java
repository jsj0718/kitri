package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx4 {
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
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("책 번호: ");
		int bookID = sc.nextInt();
		sc.close();
		
		// 실행 쿼리
		String SQL = "DELETE FROM BOOK "
					+ "WHERE BOOKID = ?";
	
		int result = 0;
		try {
			// DB 쿼리 실행을 위한 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(SQL);
			
			// ? 에 값 넣기
			
			pstmt.setInt(1, bookID);
			
			// 쿼리 실행 및 결과값 저장
			result = pstmt.executeUpdate();

			if (result >= 1) {
				System.out.println(result + "개 값이 삭제되었습니다.");
			} else {
				System.out.println("삭제에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) pstmt.close();
				if (conn != null && !conn.isClosed()) conn.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
