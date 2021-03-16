package cineroom.mvc.view;

import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;

public class EndView {
	public static void printMovieList(List<Movie> list) {
		System.out.println("*****�˻����("+list.size()+"��)*****");
		int i = 1;
		for (Movie m : list) {
			System.out.print("����="+i+" ");
			System.out.println(m);
			i++;
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
		System.out.println(message);
	}

	public static void printRateList(List<Rate> rateList) {
		System.out.println("*****���� �ۼ��� ���� (" + rateList.size() + "��)*****");
		for (Rate dto : rateList) {
			System.out.println(dto);
		}
		System.out.println();
	}
}
