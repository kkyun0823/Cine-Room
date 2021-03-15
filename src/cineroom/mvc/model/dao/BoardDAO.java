package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;

public interface BoardDAO {
	/**
	 * ��ü �� ��� �˻� -> ������ �޴����� �̿�
	 * 
	 * @return List<Board> ��ü ���� ����Ʈ�� ���
	 */
	public List<Board> boardSelectAll() throws SQLException;

	/**
	 * �帣�� �´� �� ��� �˻�
	 * 
	 * @return List<Board> ��ü ���� ����Ʈ�� ���
	 */
	public List<Board> boardSelectByGenre(int genreNo) throws SQLException;

	/**
	 * ����ڰ� �ۼ��� �� ��� �˻�
	 * 
	 * @return List<Board> ��ü ���� ����Ʈ�� ���
	 */
	public List<Board> boardSelectByID(String memberId) throws SQLException;

	/**
	 * ������ �� �˻�
	 * 
	 * @return Board ������ �ϳ��� ���� ���
	 */
	public Board boardSelect(Board board) throws SQLException;

	/**
	 * �Խ��ǿ� �� ���
	 */
	public int boardInsert(Board board) throws SQLException;

	/**
	 * �Խ��ǿ� �� ����
	 */
	public int boardDelete(int boardNo) throws SQLException;
}
