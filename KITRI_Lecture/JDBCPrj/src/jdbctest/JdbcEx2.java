package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx2 {
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
		
		System.out.print("å �̸�: ");
		String bookName = sc.nextLine();
		System.out.print("���ǻ�: ");
		String publisher = sc.nextLine();
		System.out.print("����: ");
		int price = sc.nextInt();

		sc.close();
		// ���� ����
		String SQL = "INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER, PRICE) "
					+ "VALUES (?, ?, ?, ?)";
		
		
		int result = 0;
		try {
			// DB ���� ������ ���� PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(SQL);
			
			// ? �� �� �ֱ�
			
			pstmt.setInt(1, bookID);
			pstmt.setString(2, bookName);
			pstmt.setString(3, publisher);
			pstmt.setInt(4, price);
			
			// ���� ���� �� ����� ����
			result = pstmt.executeUpdate();

			if (result >= 1) {
				System.out.println("��ϵǾ����ϴ�.");
			} else {
				System.out.println("��Ͽ� �����߽��ϴ�.");
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
