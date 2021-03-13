package cineroom.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dao.BoardDAO;
import cineroom.mvc.model.dao.BoardDAOImpl;
import cineroom.mvc.model.dto.Board;

public class BoardService {

	private BoardDAO boardDAO = new BoardDAOImpl();

	public List<Board> boardSelectAll() throws SQLException {
		List<Board> list = boardDAO.boardSelectAll();
		if (list == null || list.size() == 0 || list.isEmpty()) {
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return list;
	}

	public List<Board> boardSelectByGenre(int genreNo) throws SQLException {
		List<Board> list = boardDAO.boardSelectByGenre(genreNo);
		if (list == null || list.size() == 0 || list.isEmpty()) {
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return list;
	}

	public List<Board> boardSelectByID(String memberId) throws SQLException {
		List<Board> list = boardDAO.boardSelectByID(memberId);
		if (list == null || list.size() == 0 || list.isEmpty()) {
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return list;
	}

	public Board boardSelectByNo(int boardNo) throws SQLException {
		Board dto = boardDAO.boardSelect(boardNo);
		if (dto == null) {
			throw new SQLException(boardNo + "에 해당하는 게시물은 없습니다.");
		}
		return dto;
	}

	public void boardInsert(Board board) throws SQLException {
		int result = boardDAO.boardInsert(board);
		if (result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}

	}

	public void boardDelete(int boardNo) throws SQLException {
		int result = boardDAO.boardDelete(boardNo);
		if (result == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}

	}

}
