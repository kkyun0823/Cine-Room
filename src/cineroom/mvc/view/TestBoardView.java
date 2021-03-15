package cineroom.mvc.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.controller.CommentsController;
import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;

public class TestBoardView {
	private static Scanner sc = new Scanner(System.in);
	private static BoardController boardController = new BoardController();
	private static CommentsController commentsController = new CommentsController();
	
	/**
	 * �Խ��� ��ü �˻� ����ϱ�
	 */
	public static void printBoardList(List<Board> list) {
		System.out.println("------�˻����(" + list.size() + "��)---------");
		int i = 1;

		for (Board dto : list) {
			System.out.print("�۹�ȣ " + i);
			System.out.println(dto);
			i++;
		}

		System.out.println();
	}
	
	/**
	 * �帣�� �ش��ϴ� �Խ��� �˻� ����ϱ�
	 */
	public static void printGenreBoardList(List<Board> list) {
		System.out.println("------���(" + list.size() + "��)---------");
		int i = 1;
		
		for (Board dto : list) {
			System.out.print("�۹�ȣ " + i);
			System.out.println(dto);
			i++;
		}

		System.out.println();
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խ��� �˻� ����ϱ�
	 */
	public static void printBoard(Board dto) {
		System.out.println(dto);
	}

	/**
	 * ID,�Խ��� �ۿ� �ش��ϴ� ��� �˻� ����ϱ�
	 */
	public static void printComments(List<Comments> list) {
		System.out.println("------�˻���� (" + list.size() + "��)---------");
		for (Comments dto : list) {
			System.out.println(dto);
		}
		System.out.println();
	}
	//�� �Խ��ǿ� �ش��ϴ� ���� �޴�
		public static void menuBoardByGenre() {
			while(true) {
			System.out.println("1. �����ȸ 2. ��۵�� ");
			System.out.println(" �޴����� ��");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
					case 1: commentsController.commentsSelectByBoardNo(5); break;
					default:
						System.out.println("�߸��Ǿ����ϴ�..�ٽ� �Է����ּ���.");
					
				}
			}catch (NumberFormatException e){
				System.out.println("�޴��� ���ڸ� �����մϴ�.");
			}
		    }
		}	
	
	
	/**
	 * ���, ����, ������ ��쿡 �����޽��� ���
	 **/
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		

		// ������ ����Խ��� �׸��� ����������
		while (true) {
			System.out.println("  *************** ����Խ��� *****************");
			System.out.println("������������������������������������������������   ");
			System.out.println("��1.��ü�Խ��� |  2.�帣���Խ��� |  3.�۵��        ");
			System.out.println("������������������������������������������������  ");
			System.out.println(" �޴����� ��");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					boardController.boardSelectByAll(); // ��ü �Խ��� ��ȸ
					
					break;
				case 2:
					System.out.println("1.�׼� 2.�ڹ̵� 3.�θǽ� 4.���� 5.�ִϸ��̼� 6.SF ");
					System.out.println("7.��Ÿ�� 8.���� 9.���� 10.������ 11.��ť���͸� 12.��� 13.������");
					System.out.println();
					System.out.println("�帣 ���â�");
					int genreMenu = Integer.parseInt(sc.nextLine());
					boardController.boardSelectByGenre(genreMenu);
					menuBoardByGenre();
					break;
				
					
				default:
					System.out.println("�߸��Ǿ����ϴ�..�ٽ� �Է����ּ���.");
				}
			}catch (NumberFormatException e){
				System.out.println("�޴��� ���ڸ� �����մϴ�.");
			}
		}
		
	
		
		
		

		
		
		// �Խ��� ��ü�� �˻�
		// boardController.boardSelectByAll();

		// �帣��ȣ�� �ش��ϴ� �� �˻�
		// boardController.boardSelectByGenre(1);

		//System.out.println();
		// ID�� �ش��ϴ� �� �˻�
		// boardController.boardSelectByID("jungwoo123");

		//System.out.println();
		// �۹�ȣ�� �ش��ϴ� �� �˻�
		// boardController.boardSelectByNo(5);

		//System.out.println();
		// �Խù� ���
//		String memberId = "jungwoo123";
//		int movieNo = 1;
//		String boardTitle = "�ְ��� ��ȭ";
//		String boardcontent = "��õ�մϴ�";
//		Board board =  new Board(0, memberId, movieNo, boardTitle, boardcontent ,null);
//		boardController.boardInsert(board);

		// �Խù� ����
		// boardController.boardDelete(6);
		
		// �Խ��� �ۿ� �ش��ϴ� ��� �˻�
		//commentsController.commentsSelectByBoardNo(5);
		
		// ID�� �ش��ϴ� ��� �˻�
		// commentsController.commentsSelectByID("jungwoo123");

		// ��� ���
//		int boardNo = 9;
//		String memberId = "jungwoo123";
//		String commentsContent = "��¥��?";
//		Comments comments = new Comments(0, boardNo, memberId, commentsContent, null);
//		commentsController.commentsInsert(comments);

		// ��� ����
		// commentsController.commentsDelete(22);
		}

}
