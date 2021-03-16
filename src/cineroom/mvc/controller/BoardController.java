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
	 * 게시판 전체 검색
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
	 * 장르번호에 해당하는 게시물 검색
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
	 * ID에 해당하는 게시물 검색
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
	 * 글번호에 해당하는 게시물 검색
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
	 * 게시물 등록
	 */
	public static void boardInsert(Board board) {
		try {
			//영화 검색메뉴를 띄우고 , 영화 객체를 받아오기
			
			boardService.boardInsert(board);
			EndView.printMessage("등록되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 게시물 삭제
	 */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			EndView.printMessage("삭제되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}

	}
	/**
	 * 입력받은 글번호를 boardNo로 바꿔준다.
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
