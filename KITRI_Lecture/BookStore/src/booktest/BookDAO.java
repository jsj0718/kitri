package booktest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 전체 select
	public ArrayList<BookVO> select() {
		BookVO book = null;
		ArrayList<BookVO> blist = new ArrayList<>();
		
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "SELECT * FROM BOOK";
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// rs 결과값 담기
			ResultSet rs = pstmt.executeQuery();
			
			// list에 객체 담기
			
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
	
	// 하나 select (bookID)
	public BookVO select(int bookID) {
		BookVO book = null;

		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "SELECT * FROM BOOK WHERE = ?";
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?에 인자값 넣기
			pstmt.setInt(1, bookID);
			
			// rs 결과값 담기
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
	
	// Book Sequence 가져오기
	public int selectBookSeq() {
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "SELECT MAX(BOOKID) + 1 FROM BOOK";
		int result = 0;
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// rs 결과값 담기
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
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "SELECT * FROM BOOK WHERE BOOKNAME LIKE ?";
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?에 인자값 넣기
			pstmt.setString(1, "%"+bookName+"%");
			
			// rs 결과값 담기
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
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "SELECT * FROM BOOK WHERE 1 = 1 ";
		
		if (item.equals("책번호")) {
			SQL += "AND BOOKID LIKE ?";
		} else if (item.equals("책이름")) {
			SQL += "AND BOOKNAME LIKE ?";
		} else if (item.equals("출판사")) {
			SQL += "AND PUBLISHER LIKE ?";
		} else if (item.equals("가격")) {
			SQL += "AND PRICE LIKE ?";
		}
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?에 인자값 넣기
//			if (item.equals("책번호") || item.equals("가격")) {
//				pstmt.setInt(1, Integer.parseInt(search));
//			} else if (item.equals("책이름") || item.equals("출판사")) {
//				pstmt.setString(1, "%"+search+"%");
//			}
			
			pstmt.setString(1, "%"+search+"%");
			
			// rs 결과값 담기
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
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER, PRICE) "
					+ "VALUES (BOOK_BOOKID_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?에 인자값 넣기
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
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "UPDATE BOOK "
					+ "SET BOOKNAME = ?,"
					+ "    PUBLISHER = ?,"
					+ "    PRICE = ? "
					+ "WHERE BOOKID = ?";
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?에 인자값 넣기
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
		// DBConnection 연결
		Connection conn = DBConnect.getInstance();
		
		// 실행 쿼리
		String SQL = "DELETE FROM BOOK "
					+ "WHERE BOOKID = ?";
		
		try {
			// pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			// ?에 인자값 넣기
			pstmt.setInt(1, bookID);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		return -1;
	}
	
	// 스트림 닫는 메소드 선언 - 1
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) rs.close();
			if (pstmt != null && !pstmt.isClosed()) pstmt.close();
			if (conn != null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 스트림 닫는 메소드 선언 - 2
	public void closeAll(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null && !pstmt.isClosed()) pstmt.close();
			if (conn != null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
