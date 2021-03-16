package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;
import cineroom.mvc.model.service.MemberService;
import cineroom.mvc.model.service.RateService;




public class RateController {
	private static RateService rateService = new RateService();
	
	/**
	 * ���� ��������
	 * */
	public double getMovieRate(Movie movie) {
		try {
			double result =rateService.getMovieRate(movie);
			//MenuView.printMessage();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * �ش� ��ȭ ���� ��Ͽ��� üũ  
	 * */
	
	 public boolean checkRate (String memberId, int movieNo) {
		 try {
			 boolean result = rateService.checkRate(memberId, movieNo);
			 //MenuView.prinMessage();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }

	/**
	 *���� �Է��ϱ�  
	 **/
	public int setMovieRate(int movieNo, String memberId , double rate) {
	  try {
		  int result = rateService.setMovieRate(movieNo, memberId, rate);
		  //MenuView.printMessage();
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	}
	
	/**
	 * ���� �����ϱ� 
	 * */
	
	
	
	/**
	 * ���� �����ϱ� 
	 * */
	public int deleteMovieRate(Member member, Movie movie) {
		try {
			int result = rateService.deleteMovieRate(member, movie);
			//MenuView.printMessage();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ���� �˻��ϱ� 
	 * */
	public List<Rate> rateSelectByID(Member member){
		try {
			 List<Rate> rateList = rateService.rateSelectByID(member);
			 //MenuView.printRateList(rateList);
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
}
