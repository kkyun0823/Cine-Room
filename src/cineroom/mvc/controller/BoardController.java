package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;

public class BoardController {

	private static BoardService boardService = new BoardService();

	/**
	 * �Խ��� ��ü �˻�
	 */
	public static List<Board> boardSelectByAll() {

		try {
			List<Board> list = boardService.boardSelectAll();
			
			return list;
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * �帣��ȣ�� �ش��ϴ� �Խù� �˻�
	 */
	public static List<Board> boardSelectByGenre(int genreNo) {
		try {
			List<Board> list = boardService.boardSelectByGenre(genreNo);
			
			return list;
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * ID�� �ش��ϴ� �Խù� �˻�
	 */
	public static List<Board> boardSelectByID(String memberId) {
		try {
			List<Board> list = boardService.boardSelectByID(memberId);
			
			return list;
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� �˻�
	 */
	public static void boardSelectByNo(int boardNo) {
		try {
			Board dto = boardService.boardSelectByNo(boardNo);
			EndView.printBoardByNo(dto);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}

	}

	/**
	 * �Խù� ���
	 */
	public static void boardInsert(Board board) {
		try {
			//��ȭ �˻��޴��� ���� , ��ȭ ��ü�� �޾ƿ���
			
			boardService.boardInsert(board);
			EndView.printMessage("��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * �Խù� ����
	 */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			EndView.printMessage("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}

	}
	/**
	 * �Է¹��� �۹�ȣ�� boardNo�� �ٲ��ش�.
	 * */
	public static int getBoardNoByList (List<Board> list, int no) {
		try {
		int boardNo = list.get(no-1).getBoardNo();
		return boardNo;
		}catch(IndexOutOfBoundsException e) {
			
			return -1;
		}
	}
}
