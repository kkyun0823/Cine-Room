package cineroom.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.controller.CommentsController;
import cineroom.mvc.model.dao.BoardDAO;
import cineroom.mvc.model.dao.BoardDAOImpl;
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
	public static void printBoardByNo(Board dto) {
		System.out.println("������������������������������������������������");
		System.out.println("��     Movie  |  " + dto.getMovieTitle() );
		System.out.println("��     Title  |  " + dto.getBoardTitle());
		System.out.println("��     Review |  " +dto.getBoardContent());
		System.out.println("��     Writer |  " +dto.getMemberId());
		System.out.println("��     Date   |  " +dto.getBoardDate());
		System.out.println("������������������������������������������������ ");
		System.out.println("  <Comment>");
		for(Comments com : dto.getCommentsList()) {
			System.out.println(com);
		}
		System.out.println();
	}

	/**
	 * ID�� �ش��ϴ� ��� �˻� ����ϱ�
	 */
	public static void printCommentsList(List<Comments> list) {
		System.out.println("------�˻���� (" + list.size() + "��)---------");
		int i = 1;
		for (Comments dto : list) {
			System.out.println("��� " + i + " | ID : " + dto.getMemberId() + " | ���� : " + dto.getCommentsContent() + " | ����� : " + dto.getCommentsDate());
			i++;
		}
		System.out.println();
	}
	//��ü�Խ��� �޴�
	public static void printMenuBoardAll() {
		boardController.boardSelectByAll();
	}
	
	
	//�� �Խ��ǿ� �ش��ϴ� ���� �޴�
		public static void printMenuBoardByEach() {
			while(true) {
			System.out.println("1.�� ��ȸ 2. �����ȸ 3. ��۵�� ");
			System.out.println(" �޴����� ��");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
					case 2: commentsController.commentsSelectByBoardNo(5); break;
					default:
						System.out.println("�߸��Ǿ����ϴ�..�ٽ� �Է����ּ���.");
					
				}
			}catch (NumberFormatException e){
				System.out.println("�޴��� ���ڸ� �����մϴ�.");
			}
		    }
		}	
		/**
		 * �۹�ȣ�� �ش��ϴ� �Խ��� �˻� ����ϱ�
		 */
		public static void printBoard(int no) {
			
		}
		
		public static int getBoardNoByList (List<Board> list, int no) {
			int boardNo = list.get(no-1).getBoardNo();
			return boardNo;
		}
		
	/**
	 * ���, ����, ������ ��쿡 �����޽��� ���
	 **/
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void main(String[] args)throws SQLException {
		
//		BoardDAO bd = new BoardDAOImpl();
//		
//		List<Board> list = bd.boardSelectAll();
//		
//		for(int i = 0 ; i <list.size(); i++) {
//			System.out.println("�۹�ȣ"+(i+1) + list.get(i));
//		}
//		int inp = 2;
//		Board b = list.get(2-1);
//		Board b = bd.boardSelect(list.get(inp-1));
//		System.out.println(b);
		

		// ������ ����Խ��� �׸��� ����������
//		while (true) {
//			System.out.println("  *************** ����Խ��� *****************");
//			System.out.println("������������������������������������������������������������   ");
//			System.out.println("��1.��ü�Խ��� |  2.�帣���Խ��� |  3.�Խñ۵��  4.�����޴�       ");
//			System.out.println("������������������������������������������������������������  ");
//			System.out.println(" �޴����� ��");
//			try {
//				int menu = Integer.parseInt(sc.nextLine());
//				switch (menu) {
//				case 1:
//					boardController.boardSelectByAll(); // ��ü �Խ��� ��ȸ
//					
//					break;
//				case 2:
//					System.out.println("1.�׼� 2.�ڹ̵� 3.�θǽ� 4.���� 5.�ִϸ��̼� 6.SF ");
//					System.out.println("7.��Ÿ�� 8.���� 9.���� 10.������ 11.��ť���͸� 12.��� 13.������/����");
//					System.out.println("14.���� 15.���� 16.�̽��͸� 17. ��� 18. ��Ÿ");
//					System.out.println();
//					System.out.println("�帣 ���â�");
//					int genreMenu = Integer.parseInt(sc.nextLine());
//					boardController.boardSelectByGenre(genreMenu);
//					printMenuBoardByEach();
//					break;
//				case 3:
//					System.out.println("�۵���� ���Ͻô� ��ȭ�� �˻����ּ���");
//					//�������� ��ȭ �˻������ ����
//					//�� ����� ���� �Է°� �ޱ� 
//					//(ID�� ���ǿ��� �����ͼ� ó��,��ȭ��ȣ(��ȭ�˻��� ���� ����� �̿��ڰ� ����)
//					//boardTitle, boardContent
//				case 4:
//					break;
//				default:
//					System.out.println("�߸��Ǿ����ϴ�..�ٽ� �Է����ּ���.");
//				}
//			}catch (NumberFormatException e){
//				System.out.println("�޴��� ���ڸ� �����մϴ�.");
//			}
//		
//		}
		
	
		//���� �Խ��ǿ� ���ӽ�
		//1. ��ü�Խ��� 2. �帣���Խ��� 3. ���ο�� ��� 4. �����޴�
		//1-1)��ü �Խ��� --- 1. ����ȸ (�ۿ� ���� �� ������ ���� ���� ex������), 2.�����޴�
		//1-2)����ȸ �׸��� �����ϸ�, �� �ȿ��� ��۵� �����ְ� ��۵�ϰ���
		//2-1)�帣�� �Խ��� -- 1. ����ȸ (�ۿ� ���� �� ������ ���� ���� ex������), 2.�����޴�
		//2-2)����ȸ �׸��� �����ϸ�, �� �ȿ��� ��۵� �����ְ� ��۵�ϰ���
		//3)�۵�� -- �۵���� ������ ��ȭ�˻������ �̿��Ͽ� ���ϴ� ��ȭ��ȣ�� �������ְ� 
		//��ȭ����Ʈ�� �����ִ� ����� ����ؼ� �����ְ� ����ڴ� �̰��� �����Ͽ� ���� ����� �� �ִ�.
		
		

		//1. ����ȸ 2. ��۵��
		
		//�ش�Ǵ� �۹�ȣ�� �Է����ּ��� > 3
		
		// �Խ��� ��ü�� �˻�
		//boardController.boardSelectByAll();

		// �帣��ȣ�� �ش��ϴ� �� �˻�
		//boardController.boardSelectByGenre(5);
		
		//List<Board> list = boardController.boardSelectByGenre(5);
		//int boardNo = getBoardNoByList(list, 3);
		
		//System.out.println();
		// ID�� �ش��ϴ� �� �˻�
		 //boardController.boardSelectByID("jungwoo123");

		//System.out.println();
		// �۹�ȣ�� �ش��ϴ� �� �˻�
		//boardController.boardSelectByNo(boardNo);

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
		commentsController.commentsSelectByID("jungwoo123");

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
