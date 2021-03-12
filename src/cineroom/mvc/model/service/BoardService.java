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
		if(list==null || list.size()==0 || list.isEmpty()) { 
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return list;
	}
}
