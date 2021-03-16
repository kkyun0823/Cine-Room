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
	
	public List<Movie> moviesSelectByGenre(int genreNo) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByGenre(genreNo);
		if(list.size()==0)throw new SQLException("ERROR : 해당 장르로 검색된 영화정보가 없습니다.");
		return list;
	}
	
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByDirector(movieDirector);
		if(list.size()==0)throw new SQLException("ERROR : 감독 키워드'"+movieDirector+"'로 검색된 영화정보가 없습니다.");
		return list;
	}
	
	public List<Movie> moviesSelectByActor(String actor) throws SQLException{
		List<Movie> list = movieDao.moviesSelectByActor(actor);
		if(list.size()==0)throw new SQLException("ERROR : 배우 키워드'"+actor+"'로 검색된 영화정보가 없습니다.");
		return list;
	}
	
	public List<Movie> moviesSelectByReleaseDate() throws SQLException{
		List<Movie> list = movieDao.moviesSelectByReleaseDate();
		if(list.size()==0) throw new SQLException("ERROR : 현재 상영중인 영화정보가 없습니다.");
		return list;
	}
	
	public int deleteMovie(int targetNo)throws SQLException {
		int result = movieDao.movieDelete(targetNo);
		if(result==0) throw new SQLException("ERROR : 영화코드를 잘못 입력하셨습니다.");
		return result;
	}

	public void addMovie(Movie movie) throws SQLException{
		int result = movieDao.movieAdd(movie);
		if(result==0) throw new SQLException("ERROR : 영화등록에 실패하였습니다. 다시한번 등록해주세요.");
	}
	
	public void updateMovie(Movie movie)throws SQLException{
		int result = movieDao.movieUpdate(movie);
		if(result ==0) throw new SQLException("ERROR : 영화수정에 실패하였습니다.");
	}

}
