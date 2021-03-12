package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.dto.Member;

public interface CommentsDAO {
	/**
	 * 사용자가 쓴 댓글 모아보기
	 * */
	public List<Comments> commentsSelectByID(Member member) throws SQLException;
	
	/**
	 * 댓글 추가하기
	 * */
	public int commentsAdd(Comments comments) throws SQLException;
	
	/**
	 * 댓글 삭제하기
	 * */
	public int commentsDelete(int commentsNo) throws SQLException;
}
