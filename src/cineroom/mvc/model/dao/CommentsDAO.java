package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;

public interface CommentsDAO {
//	/**
//	 * ��� ��� ��������
//	 * */
//	public List<Comments> commentsSelectAll () throws SQLException;
	
	
	/**
	 * �θ�۹�ȣ�� ���� ��� ���� �˻��ϱ�
	 * */
	public List<Comments> commentsSelectByBoardNo(int boardNo) throws SQLException;
	
	/**
	 * ����ڰ� �� ��� ��ƺ���
	 */
	public List<Comments> commentsSelectByID(String memberId) throws SQLException;

	/**
	 * ��� ����ϱ�
	 */
	public int commentsInsert(Comments comments) throws SQLException;

	/**
	 * ��� �����ϱ�
	 */
	public int commentsDelete(int commentsNo) throws SQLException;
}
