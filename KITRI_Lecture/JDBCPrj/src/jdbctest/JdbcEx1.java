package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx1 {
	public static void main(String[] args) {
		// ����
		String user = "madang";
		// ��й�ȣ
		String password = "madang";
		// url - ip, port, sid
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// connection - ����̹� �ε� (ojdbc.jar ������ Ȱ���Ͽ� DB ����)
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB ���� (���� �Ϸ�)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB ���� �Ϸ�");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar�� �����ϴ�. (����̹��� �������� �ʽ��ϴ�.)");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url, user, password �� DB�� ���� �ִ��� Ȯ���ϼ���.");
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("å �˻�: ");
		String bookNameVar = sc.nextLine();
		sc.close();
		
		try {
			// �������� �ۼ�
//			String SQL = "SELECT * FROM BOOK WHERE BOOKNAME LIKE '%" + bookNameVar + "%'";
			String SQL = "SELECT * FROM BOOK WHERE BOOKNAME LIKE ?";
			// DB ���� ������ ���� Statement, PreparedStatement�� ����
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" + bookNameVar + "%");
			// ���� ������ ����� ResultSet�� ��ƿ���
			rs =  pstmt.executeQuery();
			// ResultSet�� ���� ����� while���� ���� �ϳ��� ��������
			while(rs.next()) {
				int bookID = rs.getInt("BOOKID");
				String bookName = rs.getString("BOOKNAME");
				String publisher = rs.getString("PUBLISHER");
				int price = rs.getInt("PRICE");
				
				System.out.printf("å ��ȣ : %d, å �̸� : %s, ���ǻ� : %s, ���� : %d\n", bookID, bookName, publisher, price);
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
