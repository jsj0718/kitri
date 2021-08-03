package kr.re.kitri.memo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.re.kitri.memo.dbcon.DBConnect;
import kr.re.kitri.memo.vo.MemoVO;

public class MemoDAO {
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
	
	public int memoRegist(MemoVO mvo) {
		String SQL = "INSERT INTO MEMO (NO, MDATE, ID, TITLE, MEMO)"
				+ "VALUES (MEMO_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setDate(1, (Date) mvo.getMdate());
			pstmt.setString(2, mvo.getId());
			pstmt.setString(3, mvo.getTitle());
			pstmt.setString(4, mvo.getMemo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return -1;	// DB 오류
	}
	
	public ArrayList<MemoVO> allMemo() {
		String SQL = "SELECT NO, MDATE, ID, TITLE, MEMO "
				+ "FROM MEMO";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemoVO> mlist = new ArrayList<>();
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemoVO mvo = new MemoVO();
				mvo.setNo(rs.getInt("NO"));
				mvo.setMdate(rs.getDate("MDATE"));
				mvo.setId(rs.getString("ID"));
				mvo.setTitle(rs.getString("TITLE"));
				mvo.setMemo(rs.getString("MEMO"));
				
				mlist.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return mlist;	// DB 오류
	}
}
