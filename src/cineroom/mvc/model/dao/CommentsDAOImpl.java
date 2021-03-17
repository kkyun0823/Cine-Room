package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.util.DBUtil;

public class CommentsDAOImpl implements CommentsDAO {
	@Override
	public List<Comments> commentsSelectByBoardNo(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comments> list = new ArrayList<Comments>();
		String sql = "select * from comments where board_no = ? order by comments_no";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);

			rs = ps.executeQuery();
			while (rs.next()) {
				int commentsNo = rs.getInt("comments_no");
				int boardNos = rs.getInt("board_no");
				String memberId = rs.getString("member_id");
				String commentsContent = rs.getString("comments_content");
				String commentsDate = rs.getString("comments_date");

				Comments dto = new Comments(commentsNo, boardNos, memberId, commentsContent, commentsDate);
				list.add(dto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public List<Comments> commentsSelectByID(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comments> list = new ArrayList<Comments>();
		String sql = "select * from comments where member_id = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);

			rs = ps.executeQuery();
			while (rs.next()) {
				int commentsNo = rs.getInt("comments_no");
				int boardNo = rs.getInt("board_no");
				String memberIds = rs.getString("member_id");
				String commentsContent = rs.getString("comments_content");
				String commentsDate = rs.getString("comments_date");

				Comments dto = new Comments(commentsNo, boardNo, memberIds, commentsContent, commentsDate);
				list.add(dto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int commentsInsert(Comments comments) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into comments values (comments_seq.nextval, ?, ? ,?, sysdate)";
		int result = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, comments.getBoardNo());
			ps.setString(2, comments.getMemberId());
			ps.setNString(3, comments.getCommentsContent());

			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int commentsDelete(int commentsNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from comments where comments_no = ?";
		int result = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, commentsNo);
			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	//@Override
//	public List<Comments> commentsSelectAll() throws SQLException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<Comments> list = new ArrayList<Comments>();
//		String sql = "select * from comments";
//		try {
//			con = DBUtil.getConnection();
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				int commentsNo = rs.getInt("comments_no");
//				int boardNos = rs.getInt("board_no");
//				String memberId = rs.getString("member_id");
//				String commentsContent = rs.getString("comments_content");
//				String commentsDate = rs.getString("comments_date");
//			
//				Comments dto = new Comments(commentsNo, boardNos, memberId, commentsContent, commentsDate);
//				list.add(dto);
//			
//			
//			
//			}
//		} finally {
//			DBUtil.dbClose(con, ps, rs);
//		}
//		return list;
//		
//	}

}
