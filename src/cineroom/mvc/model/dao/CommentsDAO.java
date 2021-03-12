package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.dto.Member;

public interface CommentsDAO {
	/**
	 * ����ڰ� �� ��� ��ƺ���
	 * */
	public List<Comments> commentsSelectByID(Member member) throws SQLException;
	
	/**
	 * ��� �߰��ϱ�
	 * */
	public int commentsAdd(Comments comments) throws SQLException;
	
	/**
	 * ��� �����ϱ�
	 * */
	public int commentsDelete(int commentsNo) throws SQLException;
}
