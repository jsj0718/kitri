package booktest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// ��ü select
	public ArrayList<BookVO> select() {
		BookVO book = null;
		ArrayList<BookVO> blist = new ArrayList<>();
		
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "SELECT * FROM BOOK";
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// rs ����� ���
			ResultSet rs = pstmt.executeQuery();
			
			// list�� ��ü ���
			
			while (rs.next()) {
				book = new BookVO();
				
				book.setBookID(rs.getInt("BOOKID"));
				book.setBookName(rs.getString("BOOKNAME"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setPrice(rs.getInt("PRICE"));
				
				blist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return blist;
	}
	
	// �ϳ� select (bookID)
	public BookVO select(int bookID) {
		BookVO book = null;

		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "SELECT * FROM BOOK WHERE = ?";
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?�� ���ڰ� �ֱ�
			pstmt.setInt(1, bookID);
			
			// rs ����� ���
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				book = new BookVO();
				
				book.setBookID(rs.getInt("BOOKID"));
				book.setBookName(rs.getString("BOOKNAME"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setPrice(rs.getInt("PRICE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return book;
	}
	
	// Book Sequence ��������
	public int selectBookSeq() {
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "SELECT MAX(BOOKID) + 1 FROM BOOK";
		int result = 0;
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// rs ����� ���
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result = rs.getInt(1);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}
	
	public ArrayList<BookVO> select(String bookName) {
		BookVO book = null;
		ArrayList<BookVO> blist = new ArrayList<>();
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "SELECT * FROM BOOK WHERE BOOKNAME LIKE ?";
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?�� ���ڰ� �ֱ�
			pstmt.setString(1, "%"+bookName+"%");
			
			// rs ����� ���
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				book = new BookVO();
				
				book.setBookID(rs.getInt("BOOKID"));
				book.setBookName(rs.getString("BOOKNAME"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setPrice(rs.getInt("PRICE"));
				
				blist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return blist;
	}
	
	public ArrayList<BookVO> select(String item, String search) {
		BookVO book = null;
		ArrayList<BookVO> blist = new ArrayList<>();
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "SELECT * FROM BOOK WHERE 1 = 1 ";
		
		if (item.equals("å��ȣ")) {
			SQL += "AND BOOKID LIKE ?";
		} else if (item.equals("å�̸�")) {
			SQL += "AND BOOKNAME LIKE ?";
		} else if (item.equals("���ǻ�")) {
			SQL += "AND PUBLISHER LIKE ?";
		} else if (item.equals("����")) {
			SQL += "AND PRICE LIKE ?";
		}
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?�� ���ڰ� �ֱ�
//			if (item.equals("å��ȣ") || item.equals("����")) {
//				pstmt.setInt(1, Integer.parseInt(search));
//			} else if (item.equals("å�̸�") || item.equals("���ǻ�")) {
//				pstmt.setString(1, "%"+search+"%");
//			}
			
			pstmt.setString(1, "%"+search+"%");
			
			// rs ����� ���
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				book = new BookVO();
				
				book.setBookID(rs.getInt("BOOKID"));
				book.setBookName(rs.getString("BOOKNAME"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setPrice(rs.getInt("PRICE"));
				
				blist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return blist;
	}
	
	// insert
	public int insert(BookVO bvo) {
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER, PRICE) "
					+ "VALUES (BOOK_BOOKID_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?�� ���ڰ� �ֱ�
			pstmt.setString(1, bvo.getBookName());
			pstmt.setString(2, bvo.getPublisher());
			pstmt.setInt(3, bvo.getPrice());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		return -1;
	}
	
	// update (bookID)
	public int update(BookVO bvo) {
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "UPDATE BOOK "
					+ "SET BOOKNAME = ?,"
					+ "    PUBLISHER = ?,"
					+ "    PRICE = ? "
					+ "WHERE BOOKID = ?";
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?�� ���ڰ� �ֱ�
			pstmt.setString(1, bvo.getBookName());
			pstmt.setString(2, bvo.getPublisher());
			pstmt.setInt(3, bvo.getPrice());
			pstmt.setInt(4, bvo.getBookID());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		return -1;
	}

	// delete (bookID)
	public int delete(int bookID) {
		// DBConnection ����
		Connection conn = DBConnect.getInstance();
		
		// ���� ����
		String SQL = "DELETE FROM BOOK "
					+ "WHERE BOOKID = ?";
		
		try {
			// pstmt ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?�� ���ڰ� �ֱ�
			pstmt.setInt(1, bookID);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		return -1;
	}
	
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
}
