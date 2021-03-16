package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.model.service.MovieService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;
import cineroom.mvc.view.MenuView;

public class MovieController {
	static MovieService movieService = new MovieService();
	public static void moviesSelect() {
		try {
			List<Movie> list = movieService.moviesSelect();
			EndView.printMovieList(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	public static boolean moviesSelectByTitle(String movieTitle) {
		boolean result =false;
		try {
			List<Movie> list = movieService.moviesSelectByTitle(movieTitle);
			EndView.printMovieList(list);
			result = true;
			
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
		return result;
	}

	public static void moviesSelectByGenre(int genreNo) {
		try {
			List<Movie> list = movieService.moviesSelectByGenre(genreNo);
			EndView.printMovieList(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	public static void moviesSelectByDirector(String movieDirector) {
		try {
			List<Movie> list = movieService.moviesSelectByDirector(movieDirector);
			EndView.printMovieList(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	public static void moviesSelectByActor(String actor) {
		try {
			List<Movie> list = movieService.moviesSelectByActor(actor);
			EndView.printMovieList(list);
		}catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	public static void moviesSelectByReleaseDate() {
		try {
			List<Movie> list = movieService.moviesSelectByReleaseDate();
			EndView.printMovieList(list);
		}catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	public static void deleteMovie(int targetNo) {
		try {
			movieService.deleteMovie(targetNo);
			EndView.printMessage("선택하신 영화가 삭제되었습니다.");
		}catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
	
	public static void addMovie(Movie movie) {
		try {
			movieService.addMovie(movie);
			EndView.printMessage("새 영화가 등록되었습니다.");
		}catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	public static void updateMovie(Movie movie) {
		try {
			movieService.updateMovie(movie);
			EndView.printMessage("영화가 수정되었습니다.");
		}catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
}
