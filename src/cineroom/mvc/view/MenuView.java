package cineroom.mvc.view;

import java.util.Scanner;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		MenuView.printMainMenu();
		MenuView.printUserMenu();
		MenuView.printAdminMenu();
	}

	public static void printMainMenu() {
		System.out.println("****CINE - ROOM에 오신걸 환영합니다****");
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("│  1.회원가입  |  2.로그인  |  9.종료  │");
		System.out.println("└──────────────────────────────────────┘");
	}

	public static void printUserMenu() {
		System.out.println( "***님 반갑습니다!");
		System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│  1.영화검색  |  2.평점  |  3.리뷰게시판  |  4.마이페이지  |  9.로그아웃  │");
		System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
	}

	public static void printAdminMenu() {
		System.out.println("***********관리자 메뉴입니다***********");
		System.out.println("┌─────────────────────────────────────────────────────────────┐");
		System.out.println("│  1.게시판 관리  |  2.운영 관리  |  3.영화 관리  9.로그아웃  │");
		System.out.println("└─────────────────────────────────────────────────────────────┘");
	}

	public static void printMovieSearchMenu() {

	}
	public static void printRateMenu() {
		
	}
	public static void printBoardMenu() {
		
	}
	public static void printMyPageMenu() {
		
	}
	
	public static void printBoardMangeMenu() {
		
	}

	public static void printOperationMangeMenu() {
		
	}
	
	public static void printMovieMangeMenu() {
		
	}
}
