package kr.re.kitri.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.re.kitri.memo.dbcon.DBConnect;

public class MemberDAO {
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
	public String login(String id, String pw) {
		String SQL = "SELECT ID "
				+ "FROM MMEMBER "
				+ "WHERE ID = ? "
				+ "AND PW = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result = rs.getString("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}
}
