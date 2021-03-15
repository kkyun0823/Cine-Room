package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {

	//�α���
	
	@Override
	public Member login(String memberId, String memberPassword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select*from Member where member_id = ? and member_pwd = ?");
			ps.setString(1, memberId);
			ps.setString(2, memberPassword);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		}finally {
			DBUtil.dbClose(con,ps,rs);
		}
		return member;
	}

	//ȸ������ 
	@Override
	public int signUp(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into member values (?, ?, ?, ?, ?)";
		int result = 0;		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getMemberPassword());
			ps.setString(3, member.getMemberName());
			ps.setString(4, member.getMemberBirth());
			ps.setInt(5, member.getMemberState());
	
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	//ȸ������ ����  
	@Override
	public int memberUpdate(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update into member values (?, ?, ?, ?, ?)";
		int result = 0;  //���� �� �����ϴ���  �𸣰��� 
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getMemberPassword());
			ps.setString(3, member.getMemberName());
			ps.setString(4, member.getMemberBirth());
			ps.setInt(5, member.getMemberState());
	
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	
	//ȸ������ ����  
	@Override
	public int memberDelete(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update member set member_state = 0 where member_id = ?";
		int result = 0;		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
	
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	
	
}