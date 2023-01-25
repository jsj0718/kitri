package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx3 {
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
//		ResultSet rs = null;
		
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
		
		System.out.print("å ��ȣ: ");
		int bookID = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("������ å �̸�: ");
		String bookName = sc.nextLine();
		System.out.print("������ ���ǻ�: ");
		String publisher = sc.nextLine();

		sc.close();
		// ���� ����
		String SQL = "UPDATE BOOK "
					+ "SET BOOKNAME = ?, "
					+ "	   PUBLISHER = ? "
					+ "WHERE BOOKID = ?";
	
		int result = 0;
		try {
			// DB ���� ������ ���� PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(SQL);
			
			// ? �� �� �ֱ�
			
			pstmt.setString(1, bookName);
			pstmt.setString(2, publisher);
			pstmt.setInt(3, bookID);
			
			// ���� ���� �� ����� ����
			result = pstmt.executeUpdate();

			if (result >= 1) {
				System.out.println("�����Ǿ����ϴ�.");
			} else {
				System.out.println("������ �����߽��ϴ�.");
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