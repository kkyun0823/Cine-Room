package cineroom.mvc.view;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.model.dto.Board;


public class TestBoardView {

	/**
	 * ��ü �˻� ����ϱ�
	 * */
	public static void printBoardList(List<Board> list) {
		System.out.println("------�˻���� (" + list.size() +"��)---------");
		for(Board dto : list) {
			System.out.println(dto);
		}
		System.out.println();
	}
	
	/**
	 * �帣��ȣ,ID,�۹�ȣ�� �ش��ϴ� �˻� ����ϱ�
	 * */
	public static void printBoard(Board dto) {
		System.out.println(dto);	
	}
	
	
	/**
	 * ���, ����, ������ ��쿡 �����޽��� ���
	 **/
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) throws SQLException {
		//�Խ��� ��ü�� �˻�
		BoardController controller = new BoardController();
		//controller.boardSelectByAll();
		
		System.out.println();
		//�帣��ȣ�� �ش��ϴ� �� �˻� 
		//controller.boardSelectByGenre(1);
		
		System.out.println();
		//ID�� �ش��ϴ� �� �˻�
		//controller.boardSelectByID("jungwoo123");
		
		System.out.println();
		//�۹�ȣ�� �ش��ϴ� �� �˻� 
		//controller.boardSelectByNo(5);
		
		System.out.println();
		//�Խù� ���
//		String memberId = "jungwoo123";
//		int movieNo = 1;
//		String boardTitle = "�ְ��� ��ȭ";
//		String boardcontent = "��õ�մϴ�";
//		Board board =  new Board(0, memberId, movieNo, boardTitle, boardcontent ,null);
//		controller.boardInsert(board);
		
		//�Խù� ����
		//controller.boardDelete(6);
		
		
		
		

	}

}
