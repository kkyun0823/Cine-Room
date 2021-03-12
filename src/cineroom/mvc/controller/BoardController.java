package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.view.EndView;

public class BoardController {

	private static BoardService boardService = new BoardService();
	
	/**
	 * �Խ��� ��ü �˻�
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
