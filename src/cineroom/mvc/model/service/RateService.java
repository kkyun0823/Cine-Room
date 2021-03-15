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
	 * ��ȭ�� ���� �Է��ϱ�
	 * */
	public int setMovieRate(int movieNo, String memberId ,int rate) throws SQLException{
		int result = rateDao.setMovieRate(movieNo, memberId, rate);
		if(result == 0) {
			throw new SQLException("���� ��Ͽ� �����Ͽ����ϴ�.");
		}
		return result;
		
	}
	
	/**
	 * �ۼ��� ��ȭ�� ���� �����ϱ�
	 * */
	public int deleteMovieRate(Member member, Movie movie) throws SQLException{
		int result = rateDao.deleteMovieRate(member, movie);
		if(result == 0) {
			throw new SQLException("������ �������� �ʾҽ��ϴ�.");
		}
		return result;
		
	}
	
	/**
	 * ����ڰ� �ۼ��� ��ȭ ���� �˻�
	 * */
	public List<Rate> rateSelectByID(Member member) throws SQLException{
		List<Rate> list= rateDao.rateSelectByID(member);
		if(list.size()==0)throw new SQLException("��ϵ� ������ �����ϴ�.");
		return list;
	}
}

