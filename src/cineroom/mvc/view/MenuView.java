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
		System.out.println("****CINE - ROOM�� ���Ű� ȯ���մϴ�****");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("��  1.ȸ������  |  2.�α���  |  9.����  ��");
		System.out.println("��������������������������������������������������������������������������������");
	}

	public static void printUserMenu() {
		System.out.println( "***�� �ݰ����ϴ�!");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.��ȭ�˻�  |  2.����  |  3.����Խ���  |  4.����������  |  9.�α׾ƿ�  ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public static void printAdminMenu() {
		System.out.println("***********������ �޴��Դϴ�***********");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.�Խ��� ����  |  2.� ����  |  3.��ȭ ����  9.�α׾ƿ�  ��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
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
