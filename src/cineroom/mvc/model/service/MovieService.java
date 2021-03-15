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
		if(list.size()==0)throw new SQLException("ERROR : 등록된 영화정보가 없습니다.");
		return list;
	}
	
	public List<Movie> moviesSelectByTitle(String movieTitle) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByTitle(movieTitle);
		if(list.size()==0)throw new SQLException("ERROR : 제목 키워드'"+movieTitle+"'로 검색된 영화정보가 없습니다.");
		return list;
	}
	
	public List<Movie> moviesSelectByGenre(int genreNo, String genreName) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByGenre(genreNo);
		if(list.size()==0)throw new SQLException("ERROR : 장르'"+genreName+"'로 검색된 영화정보가 없습니다.");
		return list;
	}
	
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByDirector(movieDirector);
		if(list.size()==0)throw new SQLException("ERROR : 감독 키워드'"+movieDirector+"'로 검색된 영화정보가 없습니다.");
		return list;
	}
	
	
	

}
