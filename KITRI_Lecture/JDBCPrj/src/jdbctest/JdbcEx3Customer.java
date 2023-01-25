package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx3Customer {
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
		
		System.out.print("�� ��ȣ: ");
		int custID = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("������ �� �̸�: ");
		String name = sc.nextLine();
		System.out.print("������ �ּ�: ");
		String address = sc.nextLine();
		System.out.print("������ ��ȣ: ");
		String phone = sc.nextLine();

		sc.close();
		// ���� ����
		String SQL = "UPDATE CUSTOMER "
					+ "SET NAME = ?, "
					+ "	   ADDRESS = ?, "
					+ "    PHONE = ? "
					+ "WHERE CUSTID = ?";
	
		int result = 0;
		try {
			// DB ���� ������ ���� PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(SQL);
			
			// ? �� �� �ֱ�
			
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, phone);
			pstmt.setInt(4, custID);
			
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
