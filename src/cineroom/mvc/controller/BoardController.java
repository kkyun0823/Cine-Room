package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.view.EndView;

public class BoardController {

	private static BoardService boardService = new BoardService();
	
	/**
	 * 게시판 전체 검색
	 * */
	public static void boardSelectByAll() {
		
		try {
			List<Board> list = boardService.boardSelectAll();
			//EndView.printBoardList(list);
		}catch (SQLException e) {
			//EndView.printMessage(e.getMessage());
		}
	}
}
