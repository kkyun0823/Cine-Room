package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;

public interface BoardDAO {
	/**
	 * 전체 글 목록 검색 -> 관리자 메뉴에서 이용
	 * 
	 * @return List<Board> 전체 글을 리스트로 출력
	 */
	public List<Board> boardSelectAll() throws SQLException;

	/**
	 * 장르에 맞는 글 목록 검색
	 * 
	 * @return List<Board> 전체 글을 리스트로 출력
	 */
	public List<Board> boardSelectByGenre(int genreNo) throws SQLException;

	/**
	 * 사용자가 작성한 글 목록 검색
	 * 
	 * @return List<Board> 전체 글을 리스트로 출력
	 */
	public List<Board> boardSelectByID(String memberId) throws SQLException;

	/**
	 * 선택한 글 검색
	 * 
	 * @return Board 선택한 하나의 글을 출력
	 */
	public Board boardSelect(Board board) throws SQLException;

	/**
	 * 게시판에 글 등록
	 */
	public int boardInsert(Board board) throws SQLException;

	/**
	 * 게시판에 글 삭제
	 */
	public int boardDelete(int boardNo) throws SQLException;
}
