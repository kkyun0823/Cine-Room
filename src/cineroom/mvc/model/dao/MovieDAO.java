package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Actor;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;

public interface MovieDAO {
	/**
	 * 전체 영화 목록 출력
	 * 
	 * @return List<Movie> 전체 영화정보를 리스트로 출력
	 */
	public List<Movie> moviesSelect() throws SQLException;

	/**
	 * 제목으로 영화를 검색한 결과를 출력
	 * 
	 * @return List<Movie> 검색된 영화정보들을 리스트로 출력
	 */
	public List<Movie> moviesSelectByTitle(String movieTitle) throws SQLException;

	/**
	 * 장르로 영화를 검색한 결과를 출력
	 * 
	 * @return List<Movie> 검색된 영화 정보들을 리스트로 출력
	 */
	public List<Movie> moviesSelectByGenre(int genreNo) throws SQLException;

	/**
	 * 감독으로 영화를 검색한 결과를 출력
	 * 
	 * @return List<Movie> 검색된 영화 정보들을 리스트로 출력
	 */
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException;

	/**
	 * 감독으로 영화를 검색한 결과를 출력
	 * 
	 * @return List<Movie> 검색된 영화 정보들을 리스트로 출력
	 */
	public List<Movie> moviesSelectByActor(String actor) throws SQLException;

	/**
	 * 개봉예정작인 영화를 검색한 결과를 출력
	 * 
	 * @return List<Movie> 검색된 영화 정보들을 리스트로 출력
	 */
	public List<Movie> moviesSelectByReleaseDate() throws SQLException;

	/**
	 * 영화정보를 추가하는 작업
	 */
	public int movieAdd(Movie movie) throws SQLException;

	/**
	 * 영화정보를 수정하는 작업
	 */
	public int movieUpdate(Movie movie) throws SQLException;

	/**
	 * 영화정보를 삭제하는 작업
	 */
	public int movieDelete(int movieNo) throws SQLException;

	/**
	 * 영화에 출연한 배우들의 리스트를 반환하는 메소드
	 * */
	public List<Actor> getActors(int movieNo) throws SQLException;

	/**
	 * 선택한 영화의 평점들을 담은 리스트를 반환하는 메소드
	 * */
	public List<Rate> getRates(int movieNo) throws SQLException;
}
