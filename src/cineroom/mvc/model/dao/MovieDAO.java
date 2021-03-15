package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Actor;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;

public interface MovieDAO {
	/**
	 * ��ü ��ȭ ��� ���
	 * 
	 * @return List<Movie> ��ü ��ȭ������ ����Ʈ�� ���
	 */
	public List<Movie> moviesSelect() throws SQLException;

	/**
	 * �������� ��ȭ�� �˻��� ����� ���
	 * 
	 * @return List<Movie> �˻��� ��ȭ�������� ����Ʈ�� ���
	 */
	public List<Movie> moviesSelectByTitle(String movieTitle) throws SQLException;

	/**
	 * �帣�� ��ȭ�� �˻��� ����� ���
	 * 
	 * @return List<Movie> �˻��� ��ȭ �������� ����Ʈ�� ���
	 */
	public List<Movie> moviesSelectByGenre(int genreNo) throws SQLException;

	/**
	 * �������� ��ȭ�� �˻��� ����� ���
	 * 
	 * @return List<Movie> �˻��� ��ȭ �������� ����Ʈ�� ���
	 */
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException;

	/**
	 * �������� ��ȭ�� �˻��� ����� ���
	 * 
	 * @return List<Movie> �˻��� ��ȭ �������� ����Ʈ�� ���
	 */
	public List<Movie> moviesSelectByActor(String actor) throws SQLException;

	/**
	 * ������������ ��ȭ�� �˻��� ����� ���
	 * 
	 * @return List<Movie> �˻��� ��ȭ �������� ����Ʈ�� ���
	 */
	public List<Movie> moviesSelectByReleaseDate() throws SQLException;

	/**
	 * ��ȭ������ �߰��ϴ� �۾�
	 */
	public int movieAdd(Movie movie) throws SQLException;

	/**
	 * ��ȭ������ �����ϴ� �۾�
	 */
	public int movieUpdate(Movie movie) throws SQLException;

	/**
	 * ��ȭ������ �����ϴ� �۾�
	 */
	public int movieDelete(int movieNo) throws SQLException;

	/**
	 * ��ȭ�� �⿬�� ������ ����Ʈ�� ��ȯ�ϴ� �޼ҵ�
	 * */
	public List<Actor> getActors(int movieNo) throws SQLException;

	/**
	 * ������ ��ȭ�� �������� ���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ�
	 * */
	public List<Rate> getRates(int movieNo) throws SQLException;
}
