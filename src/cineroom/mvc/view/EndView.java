package cineroom.mvc.view;

import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.dto.Member;
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
	
	public static void printCommentsList(List<Comments> list) {
		System.out.println("*****�˻����(" + list.size() + "��)*****");
		int i = 1;
		for (Comments dto : list) {
			System.out.print("��۹�ȣ " + i);
			System.out.println(dto);
			i++;
		}
		System.out.println();
	}
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խ��� �˻� ����ϱ�
	 */
	public static void printBoardByNo(Board dto) {
		System.out.println("����������������������������������������������");
		System.out.println("    ��ȭ���� |  " + dto.getMovieTitle() );
		System.out.println("    ������   |  " + dto.getBoardTitle());
		System.out.println("    �۳���   |  " +dto.getBoardContent());
		System.out.println("    �ۼ���   |  " +dto.getMemberId());
		System.out.println("    �����   |  " +dto.getBoardDate());
		System.out.println("����������������������������������������������");
		System.out.println(" <���>");
		int i = 1;
		for(Comments com : dto.getCommentsList()) {
			System.out.println("��۹�ȣ " + i + " | " + com);
			i++;
		}
		System.out.println();
	}

	
	/**
	 * ID�� �ش��ϴ� ��� �˻� ����ϱ�
	 */
	public static void printCommentsListById(List<Comments> list) {
		System.out.println("------�˻���� (" + list.size() + "��)---------");
		int i = 1;
		for (Comments dto : list) {
			System.out.println();
			System.out.println("��۹�ȣ " + i + " | ID : " + dto.getMemberId() + " | ���� : " + dto.getCommentsContent() + " | ����� : " + dto.getCommentsDate());
			i++;
		}
		System.out.println();
	}
	

	

	public static void rateList() {

	}

	public static void printMember() {

	}

	public static void printMemberList(List<Member> memberList) {
		System.out.println("*****�� ȸ���� ("+memberList.size()+"��)*****");
		for(Member m : memberList) {
			System.out.println(m);
			System.out.println();
		}
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
	
	public static void printRecommendMsg(List<Movie> movieList) {
		System.out.println("*****��ȭ ��õ �޼���(��ȣ�Ͻô� �帣�� ������ ��õ�ص����)*****");
		System.out.println();
		
		for(Movie m : movieList) {
			int movieNo = m.getMovieNo();
			String movieTitle = m.getMovieTitle();
			String genreName = m.getGenreName();
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("*****"+genreName+"�帣�� ��õ �������Դϴ�!*****");
			System.out.println("  >"+"��ȭ�ڵ�="+movieNo+" | ��ȭ����="+movieTitle+" | �帣="+genreName);
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
		}
	}
}
