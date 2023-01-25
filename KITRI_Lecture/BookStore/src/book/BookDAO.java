package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcon.DBconnect;

public class BookDAO {
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
	public ArrayList<BookVO> selectAllBook(){
		//DB connection ����
		Connection conn = DBconnect.getInstance(); 
		//��������
		String sql = "SELECT * FROM BOOK";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookVO> blist = new ArrayList<BookVO>();
		//preparedstatement ��ü ����
		try {
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			//Resultset ����� ���
			rs = pstmt.executeQuery();
			//List�� ����� ���
			BookVO bvo = null;
			while(rs.next()) {
				bvo = new BookVO();
				bvo.setBookId(rs.getInt("BOOKID"));
				bvo.setBookName(rs.getString("BOOKNAME"));
				bvo.setPublisher(rs.getString("PUBLISHER"));
				bvo.setPrice(rs.getInt("PRICE"));
				bvo.setImgPath(rs.getString("IMGPATH"));
				blist.add(bvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return blist;
	}
	
	
	//�ϳ� select (bookid)
	public BookVO selectBook(int bookId) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "SELECT * FROM BOOK WHERE BOOKID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVO bvo = null;
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			pstmt.setInt(1, bookId);
			//Resultset ����� ���
			rs = pstmt.executeQuery();
			//List�� ����� ���
			while(rs.next()) {
				bvo = new BookVO();
				bvo.setBookId(rs.getInt("BOOKID"));
				bvo.setBookName(rs.getString("BOOKNAME"));
				bvo.setPublisher(rs.getString("PUBLISHER"));
				bvo.setPrice(rs.getInt("PRICE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
			
		}
		return bvo;
	}
	
	public int selectBookSeq() {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "SELECT MAX(BOOKID) FROM BOOK";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//Resultset ����� ���
			rs = pstmt.executeQuery();
			//List�� ����� ���
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
			
		}
		return result;
	}
	
	
	
	
	public ArrayList<BookVO> selectBook(String bookName) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "SELECT * FROM BOOK WHERE BOOKNAME LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVO bvo = null;
		ArrayList<BookVO> blist = new ArrayList<BookVO>();
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			pstmt.setString(1, "%"+bookName+"%");
			//Resultset ����� ���
			rs = pstmt.executeQuery();
			//List�� ����� ���
			while(rs.next()) {
				bvo = new BookVO();
				bvo.setBookId(rs.getInt("BOOKID"));
				bvo.setBookName(rs.getString("BOOKNAME"));
				bvo.setPublisher(rs.getString("PUBLISHER"));
				bvo.setPrice(rs.getInt("PRICE"));
				blist.add(bvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
			
		}
		return blist;
	}
	
	public ArrayList<BookVO> selectBook(String item, String search) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "SELECT * FROM BOOK "
				+ "WHERE 1=1 ";
		if(item.equals("å��ȣ"))	{
			sql += "AND BOOKID = ?";
		}else if(item.equals("å�̸�")) {
			sql += "AND BOOKNAME LIKE ?";
		}else if(item.equals("���ǻ�")) {
			sql += "AND PUBLISHER LIKE ?";
		}else {
			sql += "AND PRICE LIKE ?";
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVO bvo = null;
		ArrayList<BookVO> blist = new ArrayList<BookVO>();
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			if(item.equals("å��ȣ")) {
				pstmt.setInt(1, Integer.parseInt(search));
			}else {
				pstmt.setString(1, "%"+search+"%");
			}
			
			
			//Resultset ����� ���
			rs = pstmt.executeQuery();
			//List�� ����� ���
			while(rs.next()) {
				bvo = new BookVO();
				bvo.setBookId(rs.getInt("BOOKID"));
				bvo.setBookName(rs.getString("BOOKNAME"));
				bvo.setPublisher(rs.getString("PUBLISHER"));
				bvo.setPrice(rs.getInt("PRICE"));
				blist.add(bvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
			
		}
		return blist;
	}
	
	
	//insert
	public int insertBook(BookVO bvo) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER, PRICE) "
				+ "VALUES (book_bookid_seq.nextval,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			pstmt.setString(1, bvo.getBookName());
			pstmt.setString(2, bvo.getPublisher());
			pstmt.setInt(3, bvo.getPrice());
			
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
	
	//update (bookid)
	public int updateBook(BookVO bvo) {
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
			pstmt.setString(1, bvo.getBookName());
			pstmt.setString(2, bvo.getPublisher());
			pstmt.setInt(3, bvo.getPrice());
			pstmt.setInt(4, bvo.getBookId());
			
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
	
	//delete (bookid)
	public int deleteBook(int bookId) {
		//DB connection ����
		Connection conn = DBconnect.getInstance();
		//��������
		String sql = "DELETE FROM BOOK "
				+ "WHERE BOOKID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? ���ڰ� �־��ֱ�
			pstmt.setInt(1, bookId);
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
