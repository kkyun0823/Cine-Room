package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.service.CommentsService;
import cineroom.mvc.view.TestBoardView;

public class CommentsController {

	private static CommentsService commentsService = new CommentsService();
	/**
	 * �Խñ� ��ȣ�� �ش��ϴ� ��� �˻�
	 * */
	public static void commentsSelectByBoardNo(int boardNo) {
		try {
			List<Comments> list = commentsService.commentsSelectByBoardNo(boardNo);
			TestBoardView.printCommentsList(list);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ID�� �ش��ϴ� ��� �˻�
	 */
	public static List<Comments> commentsSelectByID(String memberId) {
		try {
			List<Comments> list = commentsService.commentsSelectByID(memberId);
			TestBoardView.printCommentsList(list);
			return list;
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * ��� ���
	 */
	public static void commentsInsert(Comments comments) {
		try {
			commentsService.commentsInsert(comments);
			TestBoardView.printMessage("��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * ��� ����
	 */
	public static void commentsDelete(int commentsNo) {
		try {
			commentsService.commentsDelete(commentsNo);
			TestBoardView.printMessage("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}
	/**
	 * �Է¹��� �۹�ȣ�� commentsNo�� �ٲ��ش�.
	 * */
	public static int getBoardNoByList (List<Comments> list, int no) {
		int commentsNo = list.get(no-1).getCommentsNo();
		return commentsNo;
	}
}
