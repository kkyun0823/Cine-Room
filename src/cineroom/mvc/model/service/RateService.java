package cineroom.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dao.BoardDAO;
import cineroom.mvc.model.dao.BoardDAOImpl;
import cineroom.mvc.model.dao.RateDAO;
import cineroom.mvc.model.dao.RateDAOImpl;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;


public class RateService {
	private RateDAO rateDao = new RateDAOImpl();
	/**
	 * 영화의 평점 가져오기
	 * */
	public double getMovieRate(Movie movie) throws SQLException{
		double result = rateDao.getMovieRate(movie);
		if(result == 0.0) {
			throw new SQLException("등록된 평점이 없습니다.");
			
		}
		return result;
	}
	
	
	/**
	 * 해당 영화 평점 등록여부 체크  
	 * */
	 public boolean checkRate(String memberId, int movieNo) throws SQLException{
		 boolean result = rateDao.checkRate(memberId, movieNo);
		 return result; 
	 }

	/**
	 * 영화의 평점 입력하기
	 * */
	public int setMovieRate(Rate rate) throws SQLException{
		int result = rateDao.setMovieRate(rate);
		if(result == 0) {
			throw new SQLException("평점 등록에 실패하였습니다.");
		}
		return result;
	}
	
	/**
	 * 작성한 영화의 평점 삭제하기
	 * */
	public int deleteMovieRate(int rateNo, String memberId) throws SQLException{
		int result = rateDao.deleteMovieRate(rateNo, memberId);
		if(result == 0) {
			throw new SQLException("해당되는 정보가 없어 삭제되지 않았습니다.");
		}
		return result;
		
	}
	
	/**
	 * 사용자가 작성한 영화 평점 검색
	 * */
	public List<Rate> rateSelectByID(String memberId) throws SQLException{
		List<Rate> list= rateDao.rateSelectByID(memberId);
		if(list.size()==0)throw new SQLException("등록된 평점이 없습니다.");
		return list;
	}
}

