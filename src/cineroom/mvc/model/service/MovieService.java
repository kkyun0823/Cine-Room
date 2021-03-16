package cineroom.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dao.MovieDAO;
import cineroom.mvc.model.dao.MovieDAOImpl;
import cineroom.mvc.model.dto.Movie;

public class MovieService {
	MovieDAO movieDao = new MovieDAOImpl();
	
	public List<Movie> moviesSelect() throws SQLException{
		List<Movie> list = movieDao.moviesSelect();
		if(list.size()==0)throw new SQLException("ERROR : ��ϵ� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	public List<Movie> moviesSelectByTitle(String movieTitle) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByTitle(movieTitle);
		if(list.size()==0)throw new SQLException("ERROR : ���� Ű����'"+movieTitle+"'�� �˻��� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	public List<Movie> moviesSelectByGenre(int genreNo) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByGenre(genreNo);
		if(list.size()==0)throw new SQLException("ERROR : �ش� �帣�� �˻��� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByDirector(movieDirector);
		if(list.size()==0)throw new SQLException("ERROR : ���� Ű����'"+movieDirector+"'�� �˻��� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	public List<Movie> moviesSelectByActor(String actor) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByActor(actor);
		if(list.size()==0)throw new SQLException("ERROR : ��� Ű����'"+actor+"'�� �˻��� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	public List<Movie> moviesSelectByReleaseDate() throws SQLException{
		List<Movie> list = movieDao.moviesSelectByReleaseDate();
		if(list.size()==0) throw new SQLException("ERROR : ���� ������ ��ȭ������ �����ϴ�.");
		return list;
	}

}
