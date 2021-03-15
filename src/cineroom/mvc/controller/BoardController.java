package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cineroom.mvc.model.dao.BoardDAOImpl;
import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;
import cineroom.mvc.view.TestBoardView;

public class BoardController {

	private static BoardService boardService = new BoardService();

	/**
	 * �Խ��� ��ü �˻�
	 */
	public static void boardSelectByAll() {

		try {
			List<Board> list = boardService.boardSelectAll();
			EndView.printBoardList(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * �帣��ȣ�� �ش��ϴ� �Խù� �˻�
	 */
	public static void boardSelectByGenre(int genreNo) {
		try {
			List<Board> list = boardService.boardSelectByGenre(genreNo);
			TestBoardView.printGenreBoardList(list);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * ID�� �ش��ϴ� �Խù� �˻�
	 */
	public static void boardSelectByID(String memberId) {
		try {
			List<Board> list = boardService.boardSelectByID(memberId);
			TestBoardView.printBoardList(list);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� �˻�
	 */
	public static void boardSelectByNo(Board board) {
		try {
			Board dto = boardService.boardSelect(board);
			EndView.printBoard(dto);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}

	}

	/**
	 * �Խù� ���
	 */
	public static void boardInsert(Board board) {
		try {
			//��ȭ �˻��޴��� ���� , ��ȭ ��ü�� �޾ƿ���
			
			boardService.boardInsert(board);
			TestBoardView.printMessage("��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * �Խù� ����
	 */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			TestBoardView.printMessage("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}

	}

}
