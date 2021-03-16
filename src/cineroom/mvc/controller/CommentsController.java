package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.service.CommentsService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;


public class CommentsController {

	private static CommentsService commentsService = new CommentsService();
	/**
	 * �Խñ� ��ȣ�� �ش��ϴ� ��� �˻�
	 * */
	public static List<Comments> commentsSelectByBoardNo(int boardNo) {
		try {
			List<Comments> list = commentsService.commentsSelectByBoardNo(boardNo);
			
			return list;
		} catch (SQLException e) {
			
			return null;
		}
	}
	
	/**
	 * ID�� �ش��ϴ� ��� �˻�
	 */
	public static List<Comments> commentsSelectByID(String memberId) {
		try {
			List<Comments> list = commentsService.commentsSelectByID(memberId);
			EndView.printCommentsListById(list);
			return list;
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * ��� ���
	 */
	public static void commentsInsert(Comments comments) {
		try {
			commentsService.commentsInsert(comments);
			EndView.printMessage("��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * ��� ����
	 */
	public static void commentsDelete(int commentsNo) {
		try {
			commentsService.commentsDelete(commentsNo);
			EndView.printMessage("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	/**
	 * �Է¹��� �۹�ȣ�� commentsNo�� �ٲ��ش�.
	 * */
	public static int getCommentsNoByList (List<Comments> list, int no) {
		int commentsNo = list.get(no-1).getCommentsNo();
		return commentsNo;
	}
	
	public static List<Comments> commentsSelectAll() {
		try {
			List<Comments> list = commentsService.commentsSelectAll();
			return list;
		} catch (SQLException e) {
			return null;
		}
	}
}
