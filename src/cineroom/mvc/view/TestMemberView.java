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
		System.out.println("****CINE - ROOM�� ���Ű� ȯ���մϴ�****");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("��  1.ȸ������  |  2.�α���  |  9.����		   ��");
		System.out.println("��������������������������������������������������������������������������������");
	}

	
	public static void menu() {
		while(true) {
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				TestMemberView.signUp(); // ȸ������
				break;
			case 2 :
				MenuView.login();// �α���
				break;
			
			case 9 :
				System.exit(0);
			}
		}
	
		public static void signUp() {
			System.out.println();
			
		}
		
		
		
	/**
	 * �α��� 
	 * */
	public static void login() {
		 System.out.print("ID : ");
		 String memberId = sc.nextLine();
		 
		 System.out.print("PASSWORD : ");
		 String memberPassword = sc.nextLine();
		 
		MemberController.login(memberId, memberPassword); 
	}
	
	/**
	 * �ߺ�üũ 
	 * */
	
	//EmpDTO empDTO = new EmpDTO(9000, "���߱�", "���", 8000, null);
	 if(dao.duplicateByEmpno(empDTO.getEmpno())) {
		 //�����޼���
		 EndView.printMessage(empDTO.getEmpno() + "�� �ߺ����� ����� �� �����ϴ�. ");
	 }else {
		 int result = dao.empInsert(empDTO);
		 if(result ==0) EndView.printMessage(result + "��ϵ��� �ʾҽ��ϴ�.");
	     else EndView.printMessage(result + "��Ǿ����ϴ�.");
		
	
	/**
	 * ����� �α��� �� �������� 
	 * */
	
	public static void printUserMenu(String memberId) {
		while(true) {
			System.out.println("-----" +userId+ " �α��� �� -----");
			System.out.println(" 1. ��й�ȣ ����  |  2.��ȣ�帣 ����   ");
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
		System.out.println( "***�� �ݰ����ϴ�!");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.��ȭ�˻�  |  2.����  |  3.����Խ���  |  4.����������  |  9.�α׾ƿ�			   ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public static void printAdminMenu() {
		System.out.println("***********������ �޴��Դϴ�***********");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.�Խ��� ����  |  2.� ����  |  3.��ȭ ����  9.�α׾ƿ�			  ��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
	}

}
