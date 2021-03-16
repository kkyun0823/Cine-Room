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
	 * ��ȭ�� ���� ��������
	 * */
	public double getMovieRate(Movie movie) throws SQLException{
		double result = rateDao.getMovieRate(movie);
		if(result == 0.0) {
			throw new SQLException("��ϵ� ������ �����ϴ�.");
			
		}
		return result;
	}
	
	
	/**
	 * �ش� ��ȭ ���� ��Ͽ��� üũ  
	 * */
	 public boolean checkRate(String memberId, int movieNo) throws SQLException{
		 boolean result = rateDao.checkRate(memberId, movieNo);
		 return result; 
	 }

	/**
	 * ��ȭ�� ���� �Է��ϱ�
	 * */
	public int setMovieRate(Rate rate) throws SQLException{
		int result = rateDao.setMovieRate(rate);
		if(result == 0) {
			throw new SQLException("���� ��Ͽ� �����Ͽ����ϴ�.");
		}
		return result;
	}
	
	/**
	 * �ۼ��� ��ȭ�� ���� �����ϱ�
	 * */
	public int deleteMovieRate(int rateNo, String memberId) throws SQLException{
		int result = rateDao.deleteMovieRate(rateNo, memberId);
		if(result == 0) {
			throw new SQLException("�ش�Ǵ� ������ ���� �������� �ʾҽ��ϴ�.");
		}
		return result;
		
	}
	
	/**
	 * ����ڰ� �ۼ��� ��ȭ ���� �˻�
	 * */
	public List<Rate> rateSelectByID(String memberId) throws SQLException{
		List<Rate> list= rateDao.rateSelectByID(memberId);
		if(list.size()==0)throw new SQLException("��ϵ� ������ �����ϴ�.");
		return list;
	}
}

