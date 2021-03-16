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
	 * 평점 등록 전, 여부 확인  
	 * */
	 public boolean checkRate(String memberId, int movieId) throws SQLException;
	 
	/**
	 * 영화의 평점 입력하기
	 * */
	public int setMovieRate(Rate rate) throws SQLException;
	
	/**
	 * 작성한 영화의 평점 삭제하기
	 * */
	public int deleteMovieRate(int rateNo, String memberId) throws SQLException;
	
	/**
	 * 사용자가 작성한 영화 평점 검색
	 * */
	public List<Rate> rateSelectByID(String memberId) throws SQLException;
	
	
}
