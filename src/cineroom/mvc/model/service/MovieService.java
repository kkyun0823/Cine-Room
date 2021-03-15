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
	
	public List<Movie> moviesSelectByGenre(int genreNo, String genreName) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByGenre(genreNo);
		if(list.size()==0)throw new SQLException("ERROR : �帣'"+genreName+"'�� �˻��� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByDirector(movieDirector);
		if(list.size()==0)throw new SQLException("ERROR : ���� Ű����'"+movieDirector+"'�� �˻��� ��ȭ������ �����ϴ�.");
		return list;
	}
	
	
	

}
