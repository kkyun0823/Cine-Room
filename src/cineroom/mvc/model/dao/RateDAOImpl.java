package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;
import cineroom.mvc.util.DBUtil;


public class RateDAOImpl implements RateDAO{

	//가져오기 
	@Override
	public double getMovieRate(Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double rate = 0.0;
		String sql = "select rate from movie join rate using(?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movie.getMovieNo());
	
			rs = ps.executeQuery();
			
			if(rs.next())
				rate = rs.getDouble(1);
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return rate;
	}

	// 해당 영화 평점 등록여부 체크  
	@Override
	 public boolean checkRate(String memberId) throws SQLException{

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    boolean result = false;
	    
	    String sql = "select*from rate where member_id = ? and movie_number = ? ";
	    
	    try {
	    	con = DBUtil.getConnection();
	    	ps = con.prepareStatement(sql);
	    	ps.setString(1, member.getMemberId());
	    	ps.setInt(1, movie.geMovieNo());
		
	    	rs = ps.executeQuery();
	    
	    	//if(rs.next()) {
	    		result = true;
	} finally {
		DBUtil.dbClose(con, ps);
	}
	return result;
	}

	
	
	
	//평점입력 
	@Override
	public int setMovieRate(int movieNo, String memberId, int rate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "insert into rate values (rate_rateno_seq.nextval,?,?,?)";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			ps.setString(2, memberId);
			ps.setInt(3, rate);
			
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return rate;
		}
	
	

	
	//삭제 
	@Override
	public int deleteMovieRate(Member member, Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "Delete from rate where movie_number = ? and member_id = ?";
		
		int result = 0;		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movie.getMovieNo());
			ps.setString(2, member.getMemberId());
			
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
		}
			

	
	//검색  - 내가 쓴 평점 보기  
	@Override
	public List<Rate> rateSelectByID(Member member) throws SQLException {
			Connection con=null;
		    PreparedStatement ps=null;
		    ResultSet rs=null;
		    String sql = "select movie_name, rate from rate join movie using (movie_no) where member_id = ?";
		    		
			List<Rate> list = new ArrayList<>();
			 try {
			   con = DBUtil.getConnection();
			   ps= con.prepareStatement("select * from member join rate using(member_id) where movie_id = ?");
			   ps.setString(1, member.getMemberId());
		       rs = ps.executeQuery(); 
		        
		       while(rs.next()) {
		       	Rate rate  = new Rate(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
		        	list.add(rate);
		        }
	    }finally {
	    	DBUtil.dbClose(con, ps, rs);
	    }
			return list;
			
	}

}
