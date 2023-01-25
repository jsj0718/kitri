package orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcon.DBconnect;

public class OrdersDAO {
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//��ü select
	public ArrayList<OrdersVO> selectOrder(String custId){
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "SELECT O.ORDERID, B.BOOKNAME, O.SALEPRICE, O.COUNT, O.ORDERDATE "
				+ "FROM ORDERS O , BOOK B "
				+ "WHERE O.BOOKID = B.BOOKID "
				+ "AND O.CUSTID = ? "
				+ "ORDER BY O.ORDERID";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrdersVO> olist = new ArrayList<OrdersVO>();
		//preparedstatement ��ü ����
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custId);
			// ? ���ڰ� �־��ֱ�
			//Resultset ����� ���
			rs = pstmt.executeQuery();
			//List�� ����� ���
			OrdersVO ovo = null;
			while(rs.next()) {
				ovo = new OrdersVO();
				ovo.setOrderId(rs.getInt(1));
				ovo.setBookName(rs.getString(2));
				ovo.setSalePrice(rs.getInt(3));
				ovo.setCount(rs.getInt(4));
				ovo.setOrderDate(rs.getDate(5));
				olist.add(ovo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return olist;
	}
	
	
	//insert
	public int insertOrders(OrdersVO ovo) {
		Connection conn = DBconnect.getInstance();
		String sql = "INSERT INTO ORDERS (ORDERID, CUSTID, BOOKID, SALEPRICE, ORDERDATE, COUNT) "
				+ "VALUES (ORDERS_ORDERID_SEQ.NEXTVAL,?,?,?,SYSDATE,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ovo.getCustId());
			pstmt.setInt(2, ovo.getBookId());
			pstmt.setInt(3, ovo.getSalePrice());
			pstmt.setInt(4, ovo.getCount());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return result;
	}
	
	//update (bookid)
	public int updateBook(OrdersVO ovo) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "UPDATE BOOK "
				+ "SET BOOKNAME = ?, "
				+"     PUBLISHER = ?, "
				+ "    PRICE = ? "
				+ "WHERE BOOKID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
//			pstmt.setString(1, bvo.getBookName());
//			pstmt.setString(2, bvo.getPublisher());
//			pstmt.setInt(3, bvo.getPrice());
//			pstmt.setInt(4, bvo.getBookId());
			
			//Resultset ����� ���
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return result;
	}
	
	//delete
	public int deleteOrders(int orderId) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "DELETE FROM ORDERS "
				+ "WHERE ORDERID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			pstmt.setInt(1, orderId);
			
			//Resultset ����� ���
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
