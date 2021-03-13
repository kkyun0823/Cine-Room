package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.util.DBUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<Board> boardSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from board";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// �� �̵��ϸ鼭 ������ ������...
				int boardNo = rs.getInt("board_no");
				String memberId = rs.getString("member_id");
				int movieNo = rs.getInt("movie_no");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");

				Board dto = new Board(boardNo, memberId, movieNo, boardTitle, boardContent, boardDate);

				list.add(dto);

			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public List<Board> boardSelectByGenre(int genreNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = "select board_no, member_id , movie_no, board_title, board_content, board_date from board join movie using (movie_no) where genre_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, genreNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int boardNo = rs.getInt("board_no");
				String memberId = rs.getString("member_id");
				int movieNo = rs.getInt("movie_no");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");

				Board dto = new Board(boardNo, memberId, movieNo, boardTitle, boardContent, boardDate);

				list.add(dto);
			}

		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public List<Board> boardSelectByID(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from board where member_id = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);

			rs = ps.executeQuery();
			while (rs.next()) {
				int boardNo = rs.getInt("board_no");
				String memberIds = rs.getString("member_id");
				int movieNo = rs.getInt("movie_no");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");

				Board dto = new Board(boardNo, memberIds, movieNo, boardTitle, boardContent, boardDate);

				list.add(dto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public Board boardSelect(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Board dto = null;
		String sql = "select * from board where board_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);

			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new Board(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return dto;
	}

	@Override
	public int boardInsert(Board board) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into board values (board_seq.nextval, ?, ?, ?, ?, sysdate)";
		int result = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getMemberId());
			ps.setInt(2, board.getMovieNo());
			ps.setString(3, board.getBoardTitle());
			ps.setString(4, board.getBoardContent());

			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from board where board_no = ?";
		int result = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

}
