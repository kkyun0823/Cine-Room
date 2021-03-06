package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {

	/**
	 * 회원정보 전체 검색
	 */

	public List<Member> memberSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "select*from member ";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("member_state") == 1) {
					String memberId = rs.getString("member_id");
					String name = rs.getString("member_name");
					String birth = rs.getString("member_birth");
					Member dto = new Member(memberId, null, name, birth, 0);
					list.add(dto);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/**
	 * 로그인
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
	 * 회원가입
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
	 * 아이디 중복확인
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
	 * 회원정보 수정 - 비밀번호 변경
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
	 * 회원정보 삭제
	 */
	@Override
	public int memberDelete(String targetId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update member set member_state = 0 where member_id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, targetId);
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 선호장르 변경 -
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