package cineroom.mvc.view;

import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Movie;

public class EndView {
	public static void printMovieList(List<Movie> list) {
		System.out.println("*****�˻����("+list.size()+"��)*****");
		for (Movie m : list) {
			System.out.println(m);
		}
	}

	public static void printSelectMovie() {
	}

	public static void printBoardList(List<Board> list) {
		System.out.println("*****�˻����(" + list.size() + "��)*****");
		int i = 1;
		for (Board dto : list) {
			System.out.print("�۹�ȣ " + i);
			System.out.println(dto);
			i++;
		}
		System.out.println();
	}

	public static void printBoard(Board board) {

	}

	public static void printCommentsList() {

	}

	public static void rateList() {

	}

	public static void printMember() {

	}

	public static void printMemberList() {

	}

	public static void printMessage(String message) {

	}
}
