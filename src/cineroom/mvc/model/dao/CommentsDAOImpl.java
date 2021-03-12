package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.dto.Member;

public class CommentsDAOImpl implements CommentsDAO {

	@Override
	public List<Comments> commentsSelectByID(Member member) throws SQLException {
		return null;
	}

	@Override
	public int commentsAdd(Comments comments) throws SQLException {
		return 0;
	}

	@Override
	public int commentsDelete(int commentsNo) throws SQLException {
		return 0;
	}

}
