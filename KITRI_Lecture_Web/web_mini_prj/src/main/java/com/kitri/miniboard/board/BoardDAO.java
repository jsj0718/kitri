package com.kitri.miniboard.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kitri.miniboard.db.DBConnect;

public class BoardDAO {
	public void closeAll (Connection conn, PreparedStatement pstmt, ResultSet rs) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 로그인
	public ArrayList<BoardVO> selectBoard() {
		String SQL = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BREGDATE "
				+ "FROM BOARD "
				+ "ORDER BY BNO DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> blist = new ArrayList<>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBno(rs.getInt("BNO"));
				bvo.setBtitle(rs.getString("BTITLE"));
				bvo.setBcontent(rs.getString("BCONTENT"));
				bvo.setBwriter(rs.getString("BWRITER"));
				bvo.setBregDate(rs.getDate("BREGDATE"));
				
				blist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return blist;
	}
	
	// 게시글 등록
	public int insertBoard(String btitle, String bwriter, String bcontent) {
		String SQL = "INSERT INTO BOARD (BNO, BTITLE, BWRITER, BCONTENT) "
				+ "VALUES(BOARD_BNO_SEQ.NEXTVAL, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bwriter);
			pstmt.setString(3, bcontent);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		
		return -1;	// DB 오류
	}
	
	// 게시글 하나 내용 가져오기
	public BoardVO selectBoardContent(int bno) {
		String SQL = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BREGDATE "
				+ "FROM BOARD "
				+ "WHERE BNO = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBno(rs.getInt("BNO"));
				bvo.setBtitle(rs.getString("BTITLE"));
				bvo.setBcontent(rs.getString("BCONTENT"));
				bvo.setBwriter(rs.getString("BWRITER"));
				bvo.setBregDate(rs.getDate("BREGDATE"));	
				
				return bvo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	// 게시글 삭제
	public int deleteBoard(int bno) {
		String SQL = "DELETE FROM BOARD "
				+ "WHERE BNO = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bno);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return -1;	// DB 오류
	}
	
	// 게시글 업데이트
	public int updateBoard(int bno, String btitle, String bcontent) {
		String SQL = "UPDATE BOARD "
				+ "SET BTITLE = ?, "
				+ "BCONTENT = ? "
				+ "WHERE BNO = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setInt(3, bno);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return -1;	// DB 오류
	}
	
	public ArrayList<BoardVO> selectBoardPage(int start, int end) {
		String SQL = "SELECT * "
				+ "FROM (SELECT ROWNUM AS RNUM, A.* "
				+ "      FROM (SELECT * "
				+ "            FROM BOARD "
				+ "            ORDER BY BNO DESC) A "
				+ "      ) "
				+ "WHERE RNUM BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> blist = new ArrayList<>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBno(rs.getInt("BNO"));
				bvo.setBtitle(rs.getString("BTITLE"));
				bvo.setBcontent(rs.getString("BCONTENT"));
				bvo.setBwriter(rs.getString("BWRITER"));
				bvo.setBregDate(rs.getDate("BREGDATE"));	
				
				blist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return blist;
	}
	
	public int selectBoardCnt() {
		String SQL = "SELECT COUNT(*) "
				+ "FROM BOARD";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return -1;
	}
}
