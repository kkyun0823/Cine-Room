package cineroom.mvc.view;

import java.util.List;
import java.util.Scanner;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.controller.CommentsController;
import cineroom.mvc.controller.MovieController;
import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;

public class BoardView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void printBoardMenu(String memberId) {
		while(true) {
			System.out.println("***********���� �Խ��� �޴��Դϴ�***********");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ü �Խ���  |  2.�帣�� �Խ���  |  3.�� �ۼ�  |  9.�����޴�  ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �Խ����� ��ȣ�� �Է����ּ���. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					List<Board> list = BoardController.boardSelectByAll();
					if(list!=null)
					printBoardByNoMenu(list, memberId);
						
					break;
				case 2:
					printSearchBoardByGenre(memberId);
					break;
				case 3:
					printInsertBoardMenu(memberId);
					break;
				case 9:
					MenuView.printUserMenu(memberId);
					break;
				default:
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					break;
				}
				
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	public static void printBoardByNoMenu (List<Board> list ,String memeberId) {
	        EndView.printBoardList(list);	
			while(true) {
				try {
					System.out.println("������������������������������������������������������������");
					System.out.println("�� 1. ����ȸ  |  2. �����޴�  ��");
					System.out.println("������������������������������������������������������������");
					System.out.print("�޴���ȣ�� �Է����ּ��� > ");
					int menuNo = Integer.parseInt(sc.nextLine());
					switch (menuNo){
						case 1:
							System.out.println();
							System.out.print("����ȸ�� ���Ͻô� �۹�ȣ�� �Է����ּ��� > ");
							int no = Integer.parseInt(sc.nextLine());
							int boardNo = BoardController.getBoardNoByList(list, no);
							BoardController.boardSelectByNo(boardNo);
							if(boardNo!=-1) 
							printCommentMenu(memeberId, boardNo, list);
							break;
						case 2:
							printBoardMenu(memeberId);
							break; 
						default:
							System.out.println("���� ���� ���ڷ� �Է����ּ���.");
							break;
					}
				}catch (NumberFormatException e) {
					System.out.println("���ڷ� �Է����ּ���.");
				}
			}
	}
	
	public static void printSearchBoardByGenre(String memberId) {
		
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("�˻��Ͻ� �帣�� ��ȣ�� �Է����ּ���. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					continue;
				}
				List<Board> list= BoardController.boardSelectByGenre(genreNo);
				if(list != null)printBoardByNoMenu(list, memberId);
				break;
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	
	
	public static void printInsertBoardMenu(String memberId) {
		//��ȭ�� ��� ��ȣ�� �����;��ϴ� issue
		String keyWord="";
		while(true) {
			System.out.print("���� �ۼ��Ͻ� ��ȭ ������ �Է����ּ���. >");
			keyWord = sc.nextLine();
			if(MovieController.moviesSelectByTitle(keyWord)) break;	
		}
		
		System.out.print("��� �� ���並 �ۼ��Ͻ� ��ȭ�� �ڵ带 �Է����ּ���. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("�������� �Է����ּ���.> ");
		String title = sc.nextLine();
		System.out.print("�۳����� �Է����ּ���. > ");
		String content = sc.nextLine();
		Board b =new Board(0, memberId, movieNo, title, content, null);
		BoardController.boardInsert(b);
	}
	
	public static void printCommentMenu(String memberId, int boardNo, List<Board> list ) {
		while(true) {
			try {
				System.out.println("����������������������������������������������������������������");
				System.out.println("�� 1. ����ۼ�  |  2. �����޴�  ��");
				System.out.println("����������������������������������������������������������������");
				System.out.print("�޴���ȣ�� �Է����ּ���. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo){
					case 1:
						printInsertCommentsMenu(memberId, boardNo);
						
						break;
					case 2:
						
						printBoardMenu(memberId);
						break;
					default:
						System.out.println("���� ���� ���ڷ� �Է����ּ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է����ּ���.");
			}
		}
		
	}
	
	public static void printInsertCommentsMenu (String memberId , int boardNo) {
		System.out.print("����� �Է����ּ���. > ");
		String comment = sc.nextLine();
		Comments co = new Comments(0, boardNo, memberId, comment, null);
		CommentsController.commentsInsert(co);
		
	}
	
	//���������� �� �� ��ȸ �� ����
	public static void printBoardMyPageMenu (List<Board> list ,String memberId) {
		
		EndView.printBoardList(list);
			while(true) {
				try {
					System.out.println("������������������������������������������������������������");
					System.out.println("�� 1. ����ȸ  | 2. �ۻ���  �� 3. �����޴�  ��");
					System.out.println("������������������������������������������������������������");
					System.out.print("�޴���ȣ�� �Է����ּ��� > ");
					int menuNo = Integer.parseInt(sc.nextLine());
					switch (menuNo){
						case 1:
							System.out.println();
							System.out.print("����ȸ�� ���Ͻô� �۹�ȣ�� �Է����ּ��� > ");
							int no1 = Integer.parseInt(sc.nextLine());
							int boardNo1 = BoardController.getBoardNoByList(list, no1);
							if(list!=null)
							BoardController.boardSelectByNo(boardNo1);
							break;
						case 2:
							System.out.println();
							System.out.print("�����Ͻ� �۹�ȣ�� �Է����ּ��� > ");
							int no2 = Integer.parseInt(sc.nextLine());
							int boardNo2 = BoardController.getBoardNoByList(list, no2);
							if(boardNo2 != -1)
							BoardController.boardDelete(boardNo2);
							break;
						case 3:
							MenuView.printMyPageMenu(memberId);
							break;
						default:
							System.out.println("���� ���� ���ڷ� �Է����ּ���.");
							break;
					}
				}catch (NumberFormatException e) {
					System.out.println("���ڷ� �Է����ּ���.");
				}
			}
	}
	
	//���������� �� ��� ���� �� ����
	public static void printCommentMypageMenu(List<Comments> list, String memberId) {
		EndView.printCommentsListById(list);
		while(true) {
			try {
				System.out.println("����������������������������������������������������������������");
				System.out.println("�� 1. ��ۻ���  |  2. �����޴�  ��");
				System.out.println("����������������������������������������������������������������");
				System.out.print("�޴���ȣ�� �Է����ּ���. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo){
					case 1:
						System.out.println();
						System.out.print("�����Ͻ� ��۹�ȣ�� �Է����ּ��� > ");
						int no = Integer.parseInt(sc.nextLine());
						int commentNo = CommentsController.getCommentsNoByList(list, no);
						if(list != null)
						CommentsController.commentsDelete(commentNo);
						break;
					case 2:
						MenuView.printMyPageMenu(memberId);
						break;
					default:
						System.out.println("���� ���� ���ڷ� �Է����ּ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է����ּ���.");
			}
		}
	}
	//������ �������� ���� �� �Խ��� ���� �޼ҵ�
	public static void printBoardMangeMenu(String memberId) {
		
		while(true) {
			System.out.println("***********���� �Խ��� ���� �޴��Դϴ�***********");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ü �Խ��� ����  |  2.�帣�� �Խ��� ���� |  9.�����޴�  ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �Խ����� ��ȣ�� �Է����ּ���. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					List<Board> list = BoardController.boardSelectByAll();
					if(list!=null)
					printBoardMangeByNoMenu(list , memberId);
						
					break;
				case 2:
					printSearchBoardMangeByGenre(memberId);
					break;
				case 9:
					MenuView.printAdminMenu(memberId);
				default:
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	
	public static void printBoardMangeByNoMenu (List<Board> list, String memeberId ) {
		EndView.printBoardList(list);	
		while(true) {
				try {
					System.out.println("������������������������������������������������������������");
					System.out.println("�� 1. ����ȸ  | 2. �ۻ���  �� 3. �����޴�  ��");
					System.out.println("������������������������������������������������������������");
					System.out.print("�޴���ȣ�� �Է����ּ��� > ");
					int menuNo = Integer.parseInt(sc.nextLine());
					switch (menuNo){
						case 1:
							System.out.println();
							System.out.print("����ȸ�� ���Ͻô� �۹�ȣ�� �Է����ּ��� > ");
							int no1 = Integer.parseInt(sc.nextLine());
							int boardNo1 = BoardController.getBoardNoByList(list, no1);
							BoardController.boardSelectByNo(boardNo1);
							if(boardNo1!=-1) 
							printCommentMangeMenu(list, boardNo1, memeberId);
							break;
						case 2:
							System.out.println();
							System.out.print("�����Ͻ� �۹�ȣ�� �Է����ּ��� > ");
							int no2 = Integer.parseInt(sc.nextLine());
							int boardNo2 = BoardController.getBoardNoByList(list, no2);
							if(boardNo2!= -1) {
							BoardController.boardDelete(boardNo2);
							}
							else {
							System.out.println("���� ��ȣ�Դϴ�.");}
							break;
						case 3:
							printBoardMangeMenu(memeberId);
							break;
						default:
							System.out.println("���� ���� ���ڷ� �Է����ּ���.");
							break;
					}
				}catch (NumberFormatException e) {
					System.out.println("���ڷ� �Է����ּ���.");
				}
			}
	}
	
	public static void printSearchBoardMangeByGenre(String memberId) {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("�˻��Ͻ� �帣�� ��ȣ�� �Է����ּ���. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					continue;
				}
				List<Board> list= BoardController.boardSelectByGenre(genreNo);
				if(list!=null) printBoardMangeByNoMenu(list, memberId);
				continue;
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	
	public static void printCommentMangeMenu(List<Board> list, int boardNo, String memberId) {
		
		while(true) {
			try {
				System.out.println("����������������������������������������������������������������");
				System.out.println("�� 1. ��ۻ���  |  2. �����޴�  ��");
				System.out.println("����������������������������������������������������������������");
				System.out.print("�޴���ȣ�� �Է����ּ���. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo){
					case 1:
						System.out.println();
						System.out.print("�����Ͻ� ��۹�ȣ�� �Է����ּ��� > ");
						int no = Integer.parseInt(sc.nextLine());
						List<Comments> list2 = CommentsController.commentsSelectByBoardNo(boardNo);
						if(list!=null) {
						int commentNo = CommentsController.getCommentsNoByList(list2, no);
						CommentsController.commentsDelete(commentNo);
						}
						break;
					case 2:
						printBoardMangeMenu(memberId);
						break ;
					default:
						System.out.println("���� ���� ���ڷ� �Է����ּ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է����ּ���.");
			}
		}
		
	}

}