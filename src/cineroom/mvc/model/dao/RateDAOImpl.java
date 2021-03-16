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

public class RateDAOImpl implements RateDAO {

	// 가져오기
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

			if (rs.next())
				rate = rs.getDouble(1);
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return rate;
	}

	// 해당 영화 평점 등록여부 체크
	@Override
	public boolean checkRate(String memberId, int movieId) throws SQLException {
		

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;

		String sql = "select*from rate where member_id = ? and movie_no = ? ";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setInt(2, movieId);

			rs = ps.executeQuery();

			if (rs.next())
				result = true;
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	// 평점입력
	@Override
	public int setMovieRate(Rate rate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into rate values(rate_seq.nextval,?,?,?)";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, rate.getMemberId());
			ps.setInt(2, rate.getMovieNo());
			ps.setInt(3, rate.getRate());

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	// 삭제
	@Override
	public int deleteMovieRate(int rateNo, String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "Delete rate where rate_no= ? and member_id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, rateNo);
			ps.setString(2, memberId);

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	// 검색 - 내가 쓴 평점 보기
	@Override
	public List<Rate> rateSelectByID(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select rate_no, movie_title, rate from rate join movie using (movie_no) where member_id = ?";
		List<Rate> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Rate rate = new Rate(rs.getInt(1), memberId, 0, rs.getInt(3));
				rate.setMovieName(rs.getString(2));
				list.add(rate);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
