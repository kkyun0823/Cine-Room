package cineroom.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dao.MovieDAO;
import cineroom.mvc.model.dao.MovieDAOImpl;
import cineroom.mvc.model.dto.Movie;

public class TestViewMovie {
	public static void main(String[] args) throws SQLException{
		MovieDAO md = new MovieDAOImpl();
		List<Movie> list = new ArrayList<Movie>();
		
//		list = md.moviesSelect();
//		for(Movie m : list) {
//			System.out.println(m);
//		}
		
//		list = md.moviesSelectByTitle("더");
//		for(Movie m : list) {
//			System.out.println(m);
//		}
//		list = md.moviesSelectByGenre(2);
//		for(Movie m : list) {
//			System.out.println(m);
//		}
		
//		int result = md.movieAdd(new Movie(1222, 1, "임의추가", "20210315", 22, 0, "박감독"));
		
//		int result = md.movieDelete(1222);
//		System.out.println(result);
//		list = md.moviesSelectByDirector("박감독");
//		for(Movie m : list) {
//			System.out.println(m);
//		}
		
	}
}
