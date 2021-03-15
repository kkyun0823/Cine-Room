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
	 * 게시판 전체 검색
	 */
	public static List<Board> boardSelectByAll() {

		try {
			List<Board> list = boardService.boardSelectAll();
			EndView.printBoardList(list);
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
			TestBoardView.printGenreBoardList(list);
			return list;
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * ID에 해당하는 게시물 검색
	 */
	public static List<Board> boardSelectByID(String memberId) {
		try {
			List<Board> list = boardService.boardSelectByID(memberId);
			TestBoardView.printBoardList(list);
			return list;
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * 글번호에 해당하는 게시물 검색
	 */
	public static void boardSelectByNo(int boardNo) {
		try {
			Board dto = boardService.boardSelectByNo(boardNo);
			TestBoardView.printBoardByNo(dto);
		} catch (SQLException e) {
			TestBoardView.printMessage(e.getMessage());
		}

	}

	/**
	 * 게시물 등록
	 */
	public static void boardInsert(Board board) {
		try {
			//영화 검색메뉴를 띄우고 , 영화 객체를 받아오기
			
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
	/**
	 * 입력받은 글번호를 boardNo로 바꿔준다.
	 * */
	public static int getBoardNoByList (List<Board> list, int no) {
		int boardNo = list.get(no-1).getBoardNo();
		return boardNo;
	}
}
