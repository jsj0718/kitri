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
				+ "FROM BOARD";
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
}
