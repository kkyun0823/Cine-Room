package cineroom.mvc.view;

import java.util.Scanner;

import cineroom.mvc.controller.MemberController;




public class TestMemberView {

	
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		MenuView.printMainMenu();
		MenuView.printUserMenu();
		MenuView.printAdminMenu();
	}

	public static void printMainMenu() {
		System.out.println("****CINE - ROOM에 오신걸 환영합니다****");
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("│  1.회원가입  |  2.로그인  |  9.종료		   │");
		System.out.println("└──────────────────────────────────────┘");
	}

	
	public static void menu() {
		while(true) {
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				TestMemberView.signUp(); // 회원가입
				break;
			case 2 :
				MenuView.login();// 로그인
				break;
			
			case 9 :
				System.exit(0);
			}
		}
	
		public static void signUp() {
			System.out.println();
			
		}
		
		
		
	/**
	 * 로그인 
	 * */
	public static void login() {
		 System.out.print("ID : ");
		 String memberId = sc.nextLine();
		 
		 System.out.print("PASSWORD : ");
		 String memberPassword = sc.nextLine();
		 
		MemberController.login(memberId, memberPassword); 
	}
	
	/**
	 * 중복체크 
	 * */
	
	//EmpDTO empDTO = new EmpDTO(9000, "송중기", "배우", 8000, null);
	 if(dao.duplicateByEmpno(empDTO.getEmpno())) {
		 //오류메세지
		 EndView.printMessage(empDTO.getEmpno() + "는 중복으로 등록할 수 없습니다. ");
	 }else {
		 int result = dao.empInsert(empDTO);
		 if(result ==0) EndView.printMessage(result + "등록되지 않았습니다.");
	     else EndView.printMessage(result + "등륵되었습니다.");
		
	
	/**
	 * 사용자 로그인 후 정보변경 
	 * */
	
	public static void printUserMenu(String memberId) {
		while(true) {
			System.out.println("-----" +userId+ " 로그인 중 -----");
			System.out.println(" 1. 비밀번호 변경  |  2.선호장르 변경   ");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					 
					
					break;
					
				case 2 :
				
					break;
				
				}
		}
	}
	
	
	public static void printUserMenu() {
		System.out.println( "***님 반갑습니다!");
		System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│  1.영화검색  |  2.평점  |  3.리뷰게시판  |  4.마이페이지  |  9.로그아웃			   │");
		System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
	}

	public static void printAdminMenu() {
		System.out.println("***********관리자 메뉴입니다***********");
		System.out.println("┌─────────────────────────────────────────────────────────────┐");
		System.out.println("│  1.게시판 관리  |  2.운영 관리  |  3.영화 관리  9.로그아웃			  │");
		System.out.println("└─────────────────────────────────────────────────────────────┘");
	}

}
