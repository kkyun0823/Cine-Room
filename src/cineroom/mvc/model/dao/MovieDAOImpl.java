package cineroom.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Actor;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;
import cineroom.mvc.util.DBUtil;

public class MovieDAOImpl implements MovieDAO {

	@Override
	public List<Movie> moviesSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_no, movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no)";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(5) != -1) {
					Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
							rs.getString(6));
					dto.setGenreName(rs.getString(7));
					dto.setActorList(this.getActors(rs.getInt(1)));
					dto.setRateList(this.getRates(rs.getInt(1)));
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
		String sql = "select movie_no, movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where movie_title like ?";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + movieTitle + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(5) != -1) {
					Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
							rs.getString(6));
					dto.setGenreName(rs.getString(7));
					dto.setActorList(this.getActors(rs.getInt(1)));
					dto.setRateList(this.getRates(rs.getInt(1)));
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
		String sql = "select movie_no, movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where genre_no =  ?";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, genreNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(5) != -1) {
					Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
							rs.getString(6));
					dto.setGenreName(rs.getString(7));
					dto.setActorList(this.getActors(rs.getInt(1)));
					dto.setRateList(this.getRates(rs.getInt(1)));
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
		String sql = "select movie_no, movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where movie_director like ?";
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + movieDirector + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(5) != -1) {
					Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
							rs.getString(6));
					dto.setGenreName(rs.getString(7));
					dto.setActorList(this.getActors(rs.getInt(1)));
					dto.setRateList(this.getRates(rs.getInt(1)));
					movieList.add(dto);
				}
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public List<Movie> moviesSelectByActor(String actor) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_no, movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name "
				+ "from genre join movie " + "using(genre_no) join actor " + "using(movie_no) "
				+ "where actor_name like ?";
		List<Movie> movieList = new ArrayList<Movie>();
		List<Integer> tempList = new ArrayList<Integer>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + actor + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (tempList.contains(rs.getInt(1)))
					continue;
				tempList.add(rs.getInt(1));
				Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				dto.setGenreName(rs.getString(7));
				dto.setActorList(this.getActors(rs.getInt(1)));
				dto.setRateList(this.getRates(rs.getInt(1)));
				movieList.add(dto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
	}

	@Override
	public List<Movie> moviesSelectByReleaseDate() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select movie_no, movie_title, to_char(release_date, 'YYYY-MM-DD'), running_time, movie_state, movie_director, genre_name"
				+ " from movie join genre using (genre_no) where movie_state = 1";
		List<Movie> movieList = new ArrayList<Movie>();
		// movie_state가 1인 상영작들만 불러옴
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				dto.setGenreName(rs.getString(7));
				dto.setActorList(this.getActors(rs.getInt(1)));
				dto.setRateList(this.getRates(rs.getInt(1)));
				movieList.add(dto);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return movieList;
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
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update movie set running_time = ?, movie_director = ?, movie_state = ? where movie_no =?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movie.getRunningTime());
			ps.setString(2, movie.getMovieDirector());
			ps.setInt(3, movie.getMovieState());
			ps.setInt(4, movie.getMovieNo());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int movieDelete(int movieNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		// 삭제 대신에 -1로 상태를 바꾸어 복구에 용이하게 설계
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
	public List<Actor> getActors(int movieNo) throws SQLException {
		List<Actor> list = new ArrayList<Actor>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select actor_name from movie join actor using(movie_no) where movie_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Actor(0, 0, rs.getString(1)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Rate> getRates(int movieNo) throws SQLException {
		List<Rate> list = new ArrayList<Rate>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select rate from rate join movie using(movie_no) where movie_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, movieNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Rate(0, null, 0, rs.getInt(1)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	public List<Movie> recommendMovie(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Movie> result = new ArrayList<Movie>();
		List<String> genreList = this.getFavorGenreName(memberId);
		String sql = "select movie_no, movie_title, genre_name from movie join genre using(genre_no) "
				+ "where genre_name =? and movie_state= 1";
		for(int i = 0 ; i <genreList.size(); i++) {
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, genreList.get(i));
				rs = ps.executeQuery();
				while(rs.next()) {
					Movie dto = new Movie(rs.getInt(1), 0, rs.getString(2), null, 0, 0, null);
					dto.setGenreName(rs.getString(3));
					result.add(dto);
				}
			}finally {
				DBUtil.dbClose(con, ps, rs);
			}
		}
		return result;
	}

	public List<String> getFavorGenreName(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> genreList = new ArrayList<String>();
		String sql = "select genre_name from member_genre join genre using(genre_no) where member_id = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while(rs.next()) {
				genreList.add(rs.getString(1));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return genreList;
	}
}
