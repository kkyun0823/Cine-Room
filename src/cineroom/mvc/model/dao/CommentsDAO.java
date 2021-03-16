package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;

public interface CommentsDAO {
//	/**
//	 * 모든 댓글 가져오기
//	 * */
//	public List<Comments> commentsSelectAll () throws SQLException;
	
	
	/**
	 * 부모글번호에 대한 댓글 정보 검색하기
	 * */
	public List<Comments> commentsSelectByBoardNo(int boardNo) throws SQLException;
	
	/**
	 * 사용자가 쓴 댓글 모아보기
	 */
	public List<Comments> commentsSelectByID(String memberId) throws SQLException;

	/**
	 * 댓글 등록하기
	 */
	public int commentsInsert(Comments comments) throws SQLException;

	/**
	 * 댓글 삭제하기
	 */
	public int commentsDelete(int commentsNo) throws SQLException;
}
