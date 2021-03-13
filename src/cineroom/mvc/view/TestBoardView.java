package cineroom.mvc.view;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.model.dto.Board;


public class TestBoardView {

	/**
	 * 전체 검색 출력하기
	 * */
	public static void printBoardList(List<Board> list) {
		System.out.println("------검색결과 (" + list.size() +"건)---------");
		for(Board dto : list) {
			System.out.println(dto);
		}
		System.out.println();
	}
	
	/**
	 * 장르번호,ID,글번호에 해당하는 검색 출력하기
	 * */
	public static void printBoard(Board dto) {
		System.out.println(dto);	
	}
	
	
	/**
	 * 등록, 수정, 삭제인 경우에 성공메시지 출력
	 **/
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) throws SQLException {
		//게시판 전체글 검색
		BoardController controller = new BoardController();
		//controller.boardSelectByAll();
		
		System.out.println();
		//장르번호에 해당하는 글 검색 
		//controller.boardSelectByGenre(1);
		
		System.out.println();
		//ID에 해당하는 글 검색
		//controller.boardSelectByID("jungwoo123");
		
		System.out.println();
		//글번호에 해당하는 글 검색 
		//controller.boardSelectByNo(5);
		
		System.out.println();
		//게시물 등록
//		String memberId = "jungwoo123";
//		int movieNo = 1;
//		String boardTitle = "최고의 영화";
//		String boardcontent = "추천합니다";
//		Board board =  new Board(0, memberId, movieNo, boardTitle, boardcontent ,null);
//		controller.boardInsert(board);
		
		//게시물 삭제
		//controller.boardDelete(6);
		
		
		
		

	}

}
