package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.util.DBUtil;

public class BoardDAOImpl implements BoardDAO {
	
	private CommentsDAO commentsDAO = new CommentsDAOImpl();

	@Override
	public List<Board> boardSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from board join movie using (movie_no) order by board_no";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// 열 이동하면서 데이터 꺼내기...
				int boardNo = rs.getInt("board_no");
				String memberId = rs.getString("member_id");
				String movieTitle = rs.getString("movie_title");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");
				
				List<Comments> commentsList = commentsDAO.commentsSelectByBoardNo(boardNo);
				
				Board dto = new Board(boardNo, memberId, movieTitle ,boardTitle, boardContent, boardDate,commentsList);

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
		String sql = "select * from board join movie using (movie_no) where genre_no = ? order by board_no";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, genreNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int boardNo = rs.getInt("board_no");
				String memberId = rs.getString("member_id");
				String movieTitle = rs.getString("movie_title");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");

				List<Comments> commentsList = commentsDAO.commentsSelectByBoardNo(boardNo);
				
				Board dto = new Board(boardNo, memberId, movieTitle ,boardTitle, boardContent, boardDate,commentsList);

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
		String sql = "select * from board join movie using (movie_no) where member_id = ? order by board_no";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);

			rs = ps.executeQuery();
			while (rs.next()) {
				int boardNo = rs.getInt("board_no");
				String memberIds = rs.getString("member_id");
				
				String movieTitle = rs.getString("movie_title");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");

				List<Comments> commentsList = commentsDAO.commentsSelectByBoardNo(boardNo);
				
				Board dto = new Board(boardNo, memberIds, movieTitle ,boardTitle, boardContent, boardDate,commentsList);

				list.add(dto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public Board boardSelectByNo(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Board dto = null;
		String sql = "select board_no, member_id , movie_title, board_title, board_content, board_date from board join movie using (movie_no) where board_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);

			rs = ps.executeQuery();
			if (rs.next()) {
				int boardNos = rs.getInt("board_no");
				String memberIds = rs.getString("member_id");
				
				String movieTitle = rs.getString("movie_title");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				String boardDate = rs.getString("board_date");

				List<Comments> commentsList = commentsDAO.commentsSelectByBoardNo(boardNos);
				
				dto = new Board(boardNos, memberIds, movieTitle ,boardTitle, boardContent, boardDate,commentsList);
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
			commentsDeleteByBoardNo(con, boardNo);
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int commentsDeleteByBoardNo(Connection con ,int boardNo) throws SQLException {
		PreparedStatement ps = null;
		String sql = "delete from comments where board_no = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(null, ps);
		}

		return result;
	
	}

}
