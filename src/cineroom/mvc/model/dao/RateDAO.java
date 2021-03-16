package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;

public interface RateDAO {
	/**
	 * ��ȭ�� ���� ��������
	 * */
	public double getMovieRate(Movie movie) throws SQLException;
	
	/**
	 * ���� ��� ��, ���� Ȯ��  
	 * */
	 public boolean checkRate(String memberId, int movieId) throws SQLException;
	 
	/**
	 * ��ȭ�� ���� �Է��ϱ�
	 * */
	public int setMovieRate(int movieNo, String memberId ,int rate) throws SQLException;
	
	/**
	 * �ۼ��� ��ȭ�� ���� �����ϱ�
	 * */
	public int deleteMovieRate(Member member, Movie movie) throws SQLException;
	
	/**
	 * ����ڰ� �ۼ��� ��ȭ ���� �˻�
	 * */
	public List<Rate> rateSelectByID(Member member) throws SQLException;
	
	
}
