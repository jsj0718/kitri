package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFunction {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// ��Ʈ�� �ݴ� �޼ҵ� ���� - 1
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) rs.close();
			if (pstmt != null && !pstmt.isClosed()) pstmt.close();
			if (conn != null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ��Ʈ�� �ݴ� �޼ҵ� ���� - 2
	public void closeAll(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null && !pstmt.isClosed()) pstmt.close();
			if (conn != null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// custID�� �� ���� �� ��ȸ
	public CustomerVO selectCustomer(int CUSTID) {
		String SQL = "SELECT * FROM CUSTOMER WHERE CUSTID = ?";
		CustomerVO cvo = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, CUSTID);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cvo = new CustomerVO();

				cvo.setCustID(rs.getInt("CUSTID"));
				cvo.setName(rs.getString("NAME"));
				cvo.setAddress(rs.getString("ADDRESS"));
				cvo.setPhone(rs.getString("PHONE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return cvo;
	}
	
	public ArrayList<CustomerVO> selectCustomer(int item, String search) {
		String SQL = "SELECT * FROM CUSTOMER WHERE 1 = 1 ";
		
		if (item == 1) {	// custID
			SQL += "AND CUTID = ?";
		} else if (item == 2) {	// name
			SQL += "AND NAME LIKE ?";
		} else if (item == 3) {	// address
			SQL += "AND ADDRESS LIKE ?";
		} else if (item == 4) {	// phone
			SQL += "AND PHONE LIKE ?";
		}
		
		CustomerVO cvo = null;
		ArrayList<CustomerVO> vlist = new ArrayList<CustomerVO>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			if (item == 1) {
				pstmt.setInt(1, Integer.parseInt(search));
			} else {
				pstmt.setString(1, search);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cvo = new CustomerVO();

				cvo.setCustID(rs.getInt("CUSTID"));
				cvo.setName(rs.getString("NAME"));
				cvo.setAddress(rs.getString("ADDRESS"));
				cvo.setPhone(rs.getString("PHONE"));
				
				vlist.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return vlist;
	}
	
	// ��ü �� ��ȸ (customer ���̺� ��ü ��ȸ)
	public ArrayList<CustomerVO> selectCustomer() {
		String SQL = "SELECT * FROM CUSTOMER ORDER BY CUSTID";
		ArrayList<CustomerVO> clist = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			clist = new ArrayList<CustomerVO>();
			while(rs.next()) {
				CustomerVO cvo = new CustomerVO();

				cvo.setCustID(rs.getInt("CUSTID"));
				cvo.setName(rs.getString("NAME"));
				cvo.setAddress(rs.getString("ADDRESS"));
				cvo.setPhone(rs.getString("PHONE"));
				
				clist.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return clist;
	}
	
	// insert
	public int insertCustomer(int custID, String name, String address, String phone) {
		String SQL = "INSERT INTO CUSTOMER (CUSTID, NAME, ADDRESS, PHONE) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			// DBConnect�κ��� conn ��ü �޾ƿ���
			conn = DBConnect.getConnection();
			// DB ���� ������ ���� PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(SQL);
						
			// ? �� �� �ֱ�
			pstmt.setInt(1, custID);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			
			// ���� ���� �� ����� ����
			return pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		
		return -1;
	}
	
	// update
	public int updateCustomer(int custID, String name, String address, String phone) {
		// ���� ����
		String SQL = "UPDATE CUSTOMER SET";
		
		if (name != null) {
			SQL += " NAME = ?,";
		} 
		if (address != null) {
			SQL += " ADDRESS = ?,";
		} 
		if (phone != null) {
			SQL += " PHONE = ?,";
		}
		
		SQL = SQL.substring(0, SQL.length()-1);
		SQL += " WHERE CUSTID = ?";
		
		System.out.println(SQL);
		try {
			// DBConnect�κ��� conn ��ü �޾ƿ���
			conn = DBConnect.getConnection();
			// DB ���� ������ ���� PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(SQL);
			
			if (name != null && address == null && phone == null) {
					pstmt.setString(1, name);					
					pstmt.setInt(2, custID);
			} else if (address != null && name == null && phone == null) {
					pstmt.setString(1, address);									
					pstmt.setInt(2, custID);
			} else if (phone != null && name == null && address == null) {
					pstmt.setString(1, phone);									
					pstmt.setInt(2, custID);
			} else {
				// ? �� �� �ֱ�						
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, phone);
				pstmt.setInt(4, custID);
			}
						
			
			// ���� ���� �� ����� ����
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		
		return -1;
	}
	
	
	
	// delete
	public int deleteCustomer(int custID) {
		String SQL = "DELETE FROM CUSTOMER "
				+ "WHERE CUSTID = ?";
		try {					
			// DBConnect�κ��� conn ��ü �޾ƿ���
			conn = DBConnect.getConnection();

			// DB ���� ������ ���� PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(SQL);
			
			// ? �� �� �ֱ�
			pstmt.setInt(1, custID);
			
			// ���� ���� �� ����� ����
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		
		return -1;
	}
}
