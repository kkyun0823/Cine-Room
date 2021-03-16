package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {

	/**
	 * �α���
	 */

	@Override
	public Member login(String memberId, String memberPassword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Member where member_id = ? and member_password = ?");
			ps.setString(1, memberId);
			ps.setString(2, memberPassword);

			rs = ps.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return member;
	}

	/**
	 * ȸ������
	 */
	@Override
	public int signUp(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into member values (?, ?, ?, ?, default)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getMemberPassword());
			ps.setString(3, member.getMemberName());
			ps.setString(4, member.getMemberBirth());

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * ���̵� �ߺ�Ȯ��
	 */
	@Override
	public boolean duplicateByMemberId(String memberId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "Select*from member where member_id = ? ";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();

			if (rs.next())
				result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * ȸ������ ���� - ��й�ȣ ����
	 */

	@Override
	public int memberUpdate(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update member set member_password = ? where member_id = ?  ";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMemberPassword());
			ps.setString(2, member.getMemberId());

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * ȸ������ ����
	 */
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

	/**
	 * ��ȣ�帣 ���� -
	 */
	public int changeFavNo(String memberId, List<Integer> favorList) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete member_genre where member_id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		result = setFav(memberId, favorList);
		return result;
	}

	@Override
	public int setFav(String memberId, List<Integer> favorList) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into member_genre values(member_genre_seq.nextval, ?, ?)";
		for (int i = 0; i < favorList.size(); i++) {
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, favorList.get(i));
				ps.setString(2, memberId);
				result += ps.executeUpdate();
			} finally {
				DBUtil.dbClose(con, ps);
			}
		}
		return result;
	}
}