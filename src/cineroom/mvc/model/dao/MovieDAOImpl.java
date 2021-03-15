package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.util.DBUtil;

public class MovieDAOImpl implements MovieDAO {

	@Override
	public List<Movie> moviesSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no)";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != -1) {
					Movie dto = new Movie(0, 0, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getString(5));
					dto.setGenreName(rs.getString(6));
					movieList.add(dto);
				}
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public List<Movie> moviesSelectByTitle(String movieTitle) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where movie_title like ?";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + movieTitle + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != -1) {
					Movie dto = new Movie(0, 0, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getString(5));
					dto.setGenreName(rs.getString(6));
					movieList.add(dto);
				}
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public List<Movie> moviesSelectByGenre(int genreNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where genre_no =  ?";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, genreNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != -1) {
					Movie dto = new Movie(0, 0, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getString(5));
					dto.setGenreName(rs.getString(6));
					movieList.add(dto);
				}
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public List<Movie> moviesSelectByDirector(String movieDirector) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where movie_director like ?";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + movieDirector + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != -1) {
					Movie dto = new Movie(0, 0, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getString(5));
					dto.setGenreName(rs.getString(6));
					movieList.add(dto);
				}
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public List<Movie> moviesSelectByActor(String Actor) throws SQLException {
		return null;
	}

	@Override
	public List<Movie> moviesSelectByReleaseDate() throws SQLException {
		return null;
	}

	@Override
	public int movieAdd(Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into movie values(?, ?,?,?,?,default,?)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movie.getMovieNo());
			ps.setInt(2, movie.getGenreNO());
			ps.setString(3, movie.getMovieTitle());
			ps.setString(4, movie.getReleaseDate());
			ps.setInt(5, movie.getRunningTime());
			ps.setString(6, movie.getMovieDirector());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int movieUpdate(Movie movie) throws SQLException {
		return 0;
	}

	@Override
	public int movieDelete(int movieNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update movie set movie_state = -1 where movie_no = ?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movieNo);

			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Movie movieSelectByNo(int movieNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name "
				+ "from movie join genre using (genre_no) where movie_no = ?";
		Movie movie = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(4) != -1) {
					movie = new Movie(0, 0, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
							rs.getString(5));
					movie.setGenreName(rs.getString(6));
				}
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movie;
	}

}
