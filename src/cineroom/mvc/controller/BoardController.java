package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.view.TestBoardView;

public class BoardController {

	private static BoardService boardService = new BoardService();

	/**
	 * 게시판 전체 검색
	 */
	public static void boardSelectByAll() {

		try {
			List<Board> list = boardService.boardSelectAll();
			TestBoardView.printBoardList(list);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * 장르번호에 해당하는 게시물 검색
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
	 * ID에 해당하는 게시물 검색
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
	 * 글번호에 해당하는 게시물 검색
	 */
	public static void boardSelectByNo(int boardNo) {
		try {
			Board dto = boardService.boardSelectByNo(boardNo);
			TestBoardView.printBoard(dto);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}

	}

	/**
	 * 게시물 등록
	 */
	public static void boardInsert(Board board) {
		try {
			boardService.boardInsert(board);
			TestBoardView.printMessage("등록되었습니다.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}
	}

	/**
	 * 게시물 삭제
	 */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			TestBoardView.printMessage("삭제되었습니다.");
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}

	}

}
