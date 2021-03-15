package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.service.CommentsService;
import cineroom.mvc.view.TestBoardView;

public class CommentsController {

	private static CommentsService commentsService = new CommentsService();
	/**
	 * 게시글 번호에 해당하는 댓글 검색
	 * */
	public static void commentsSelectByBoardNo(int boardNo) {
		try {
			List<Comments> list = commentsService.commentsSelectByBoardNo(boardNo);
			TestBoardView.printComments(list);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ID에 해당하는 댓글 검색
	 */
	public static void commentsSelectByID(String memberId) {
		try {
			List<Comments> list = commentsService.commentsSelectByID(memberId);
			TestBoardView.printComments(list);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * 댓글 등록
	 */
	public static void commentsInsert(Comments comments) {
		try {
			commentsService.commentsInsert(comments);
			TestBoardView.printMessage("등록되었습니다.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * 댓글 삭제
	 */
	public static void commentsDelete(int commentsNo) {
		try {
			commentsService.commentsDelete(commentsNo);
			TestBoardView.printMessage("삭제되었습니다.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}
}
