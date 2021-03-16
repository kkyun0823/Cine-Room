package cineroom.mvc.view;

import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;

public class EndView {
	public static void printMovieList(List<Movie> list) {
		System.out.println("*****검색결과("+list.size()+"개)*****");
		int i = 1;
		for (Movie m : list) {
			System.out.print("순번="+i+" ");
			System.out.println(m);
			i++;
		}
	}

	public static void printSelectMovie() {
	}

	public static void printBoardList(List<Board> list) {
		System.out.println("*****검색결과(" + list.size() + "건)*****");
		int i = 1;
		for (Board dto : list) {
			System.out.print("글번호 " + i);
			System.out.println(dto);
			i++;
		}
		System.out.println();
	}
	
	public static void printCommentsList(List<Comments> list) {
		System.out.println("*****검색결과(" + list.size() + "건)*****");
		int i = 1;
		for (Comments dto : list) {
			System.out.print("댓글번호 " + i);
			System.out.println(dto);
			i++;
		}
		System.out.println();
	}
	
	/**
	 * 글번호에 해당하는 게시판 검색 출력하기
	 */
	public static void printBoardByNo(Board dto) {
		System.out.println("┌───────────────────────┐");
		System.out.println("    영화제목 |  " + dto.getMovieTitle() );
		System.out.println("    글제목   |  " + dto.getBoardTitle());
		System.out.println("    글내용   |  " +dto.getBoardContent());
		System.out.println("    작성자   |  " +dto.getMemberId());
		System.out.println("    등록일   |  " +dto.getBoardDate());
		System.out.println("└───────────────────────┘ ");
		System.out.println(" <댓글>");
		int i = 1;
		for(Comments com : dto.getCommentsList()) {
			System.out.println("댓글번호 " + i + " | " + com);
			i++;
		}
		System.out.println();
	}

	
	/**
	 * ID에 해당하는 댓글 검색 출력하기
	 */
	public static void printCommentsListById(List<Comments> list) {
		System.out.println("------검색결과 (" + list.size() + "건)---------");
		int i = 1;
		for (Comments dto : list) {
			System.out.println();
			System.out.println("댓글번호 " + i + " | ID : " + dto.getMemberId() + " | 내용 : " + dto.getCommentsContent() + " | 등록일 : " + dto.getCommentsDate());
			i++;
		}
		System.out.println();
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
		System.out.println("*****내가 작성한 평점 (" + rateList.size() + "건)*****");
		for (Rate dto : rateList) {
			System.out.println(dto);
		}
		System.out.println();
	}
}
