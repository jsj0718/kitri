package com.kitri.visitor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kitri.visitor.dbconn.DBConnection;
import com.kitri.visitor.vo.VisitorVO;

// DAO용 Component
@Repository
public class VisitorDAOImpl implements VisitorDAO {
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
	
	@Override
	public ArrayList<VisitorVO> selectVisitors() {
		String SQL = "SELECT * FROM VISITOR";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<VisitorVO> vlist = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VisitorVO vvo = new VisitorVO();
				vvo.setVno(rs.getInt(1));
				vvo.setNickname(rs.getString(2));
				vvo.setContent(rs.getString(3));
				vvo.setRegdate(rs.getDate(4));
				
				vlist.add(vvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return vlist;
	}

	@Override
	public int insertVisitor(VisitorVO vvo) {
		String SQL = "INSERT INTO VISITOR(VNO, NICKNAME, CONTENT, REGDATE) "
				+ "VALUES (VISITOR_VNO_SEQ.NEXTVAL, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vvo.getNickname());
			pstmt.setString(2, vvo.getContent());
			pstmt.setDate(3, (Date) vvo.getRegdate());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return -1;
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {
		String SQL = "UPDATE VISITOR "
				+ "SET CONTENT = ? "
				+ "WHERE VNO = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vvo.getContent());
			pstmt.setInt(2, vvo.getVno());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return -1;
	}

	@Override
	public int deleteVisitor(int vno) {
		String SQL = "DELETE FROM VISITOR "
				+ "WHERE VNO = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vno);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return -1;
	}
	
}
