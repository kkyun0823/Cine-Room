package cineroom.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dao.CommentsDAO;
import cineroom.mvc.model.dao.CommentsDAOImpl;
import cineroom.mvc.model.dto.Comments;

public class CommentsService {

	private CommentsDAO commentsDAO = new CommentsDAOImpl();

	public List<Comments> commentsSelectByBoardNo(int boardNo) throws SQLException {
		List<Comments> list = commentsDAO.commentsSelectByBoardNo(boardNo);
		if (list == null || list.size() == 0 || list.isEmpty()) {
			throw new SQLException("�˻��� ������ �����ϴ�.");
		}

		return list;
	}
	
	public List<Comments> commentsSelectByID(String memberId) throws SQLException {
		List<Comments> list = commentsDAO.commentsSelectByID(memberId);
		if (list == null || list.size() == 0 || list.isEmpty()) {
			throw new SQLException("�˻��� ������ �����ϴ�.");
		}

		return list;
	}

	public void commentsInsert(Comments comments) throws SQLException {
		int result = commentsDAO.commentsInsert(comments);
		if (result == 0) {
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		}
	}

	public void commentsDelete(int commentsNo) throws SQLException {
		int result = commentsDAO.commentsDelete(commentsNo);
		if (result == 0) {
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		}
	}

}
