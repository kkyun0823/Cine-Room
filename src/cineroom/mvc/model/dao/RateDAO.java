package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;

public interface RateDAO {
	/**
	 * 영화의 평점 가져오기
	 * */
	public double getMovieRate(Movie movie) throws SQLException;
	
	/**
	 * 영화의 평점 입력하기
	 * */
	public int setMovieRate(int movieNo, String memberId ,int rate) throws SQLException;
	
	/**
	 * 작성한 영화의 평점 삭제하기
	 * */
	public int deleteMovieRate(Member member, Movie movie) throws SQLException;
	
	/**
	 * 사용자가 작성한 영화 평점 검색
	 * */
	public List<Rate> rateSelectByID(Member member) throws SQLException;
}
