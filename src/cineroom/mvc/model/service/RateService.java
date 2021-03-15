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
	 * 영화의 평점 입력하기
	 * */
	public int setMovieRate(int movieNo, String memberId ,int rate) throws SQLException{
		int result = rateDao.setMovieRate(movieNo, memberId, rate);
		if(result == 0) {
			throw new SQLException("평점 등록에 실패하였습니다.");
		}
		return result;
		
	}
	
	/**
	 * 작성한 영화의 평점 삭제하기
	 * */
	public int deleteMovieRate(Member member, Movie movie) throws SQLException{
		int result = rateDao.deleteMovieRate(member, movie);
		if(result == 0) {
			throw new SQLException("평점이 삭제되지 않았습니다.");
		}
		return result;
		
	}
	
	/**
	 * 사용자가 작성한 영화 평점 검색
	 * */
	public List<Rate> rateSelectByID(Member member) throws SQLException{
		List<Rate> list= rateDao.rateSelectByID(member);
		if(list.size()==0)throw new SQLException("등록된 평점이 없습니다.");
		return list;
	}
}

