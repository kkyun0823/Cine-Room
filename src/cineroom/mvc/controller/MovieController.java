package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.service.MovieService;

public class MovieController {
	static MovieService movieService = new MovieService();

	public static void moviesSelect() {
		try {
			List<Movie> list = movieService.moviesSelect();
		} catch (SQLException e) {

		}
	}

	public static void moviesSelectByTitle(String movieTitle) {
		try {
			List<Movie> list = movieService.moviesSelectByTitle(movieTitle);
		} catch (SQLException e) {

		}
	}

	public static void moviesSelectByGenre(int genreNo, String genreName) {
		try {
			List<Movie> list = movieService.moviesSelectByGenre(genreNo, genreName);
		} catch (SQLException e) {

		}
	}

	public static void moviesSelectByDirector(String movieDirector) {
		try {
			List<Movie> list = movieService.moviesSelectByDirector(movieDirector);
		} catch (SQLException e) {

		}
	}
}
