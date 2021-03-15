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
	 * 게시판 전체 검색 출력하기
	 */
	public static void printBoardList(List<Board> list) {
		System.out.println("------검색결과(" + list.size() + "건)---------");
		int i = 1;

		for (Board dto : list) {
			System.out.print("글번호 " + i);
			System.out.println(dto);
			i++;
		}

		System.out.println();
	}
	
	/**
	 * 장르에 해당하는 게시판 검색 출력하기
	 */
	public static void printGenreBoardList(List<Board> list) {
		System.out.println("------결과(" + list.size() + "건)---------");
		int i = 1;
		
		for (Board dto : list) {
			System.out.print("글번호 " + i);
			System.out.println(dto);
			i++;
		}

		System.out.println();
	}

	/**
	 * 글번호에 해당하는 게시판 검색 출력하기
	 */
	public static void printBoard(Board dto) {
		System.out.println(dto);
	}

	/**
	 * ID,게시판 글에 해당하는 댓글 검색 출력하기
	 */
	public static void printComments(List<Comments> list) {
		System.out.println("------검색결과 (" + list.size() + "건)---------");
		for (Comments dto : list) {
			System.out.println(dto);
		}
		System.out.println();
	}
	//각 게시판에 해당하는 선택 메뉴
		public static void menuBoardByGenre() {
			while(true) {
			System.out.println("1. 댓글조회 2. 댓글등록 ");
			System.out.println(" 메뉴선택 ▶");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
					case 1: commentsController.commentsSelectByBoardNo(5); break;
					default:
						System.out.println("잘못되었습니다..다시 입력해주세요.");
					
				}
			}catch (NumberFormatException e){
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
		    }
		}	
	
	
	/**
	 * 등록, 수정, 삭제인 경우에 성공메시지 출력
	 **/
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		

		// 유저가 리뷰게시판 항목을 선택했을시
		while (true) {
			System.out.println("  *************** 리뷰게시판 *****************");
			System.out.println("┌──────────────────────┐   ");
			System.out.println("│1.전체게시판 |  2.장르별게시판 |  3.글등록        ");
			System.out.println("└──────────────────────┘  ");
			System.out.println(" 메뉴선택 ▶");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					boardController.boardSelectByAll(); // 전체 게시판 조회
					
					break;
				case 2:
					System.out.println("1.액션 2.코미디 3.로맨스 4.공포 5.애니메이션 6.SF ");
					System.out.println("7.판타지 8.모험 9.범죄 10.스릴러 11.다큐멘터리 12.드라마 13.뮤지컬");
					System.out.println();
					System.out.println("장르 선택▶");
					int genreMenu = Integer.parseInt(sc.nextLine());
					boardController.boardSelectByGenre(genreMenu);
					menuBoardByGenre();
					break;
				
					
				default:
					System.out.println("잘못되었습니다..다시 입력해주세요.");
				}
			}catch (NumberFormatException e){
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
		}
		
	
		
		
		

		
		
		// 게시판 전체글 검색
		// boardController.boardSelectByAll();

		// 장르번호에 해당하는 글 검색
		// boardController.boardSelectByGenre(1);

		//System.out.println();
		// ID에 해당하는 글 검색
		// boardController.boardSelectByID("jungwoo123");

		//System.out.println();
		// 글번호에 해당하는 글 검색
		// boardController.boardSelectByNo(5);

		//System.out.println();
		// 게시물 등록
//		String memberId = "jungwoo123";
//		int movieNo = 1;
//		String boardTitle = "최고의 영화";
//		String boardcontent = "추천합니다";
//		Board board =  new Board(0, memberId, movieNo, boardTitle, boardcontent ,null);
//		boardController.boardInsert(board);

		// 게시물 삭제
		// boardController.boardDelete(6);
		
		// 게시판 글에 해당하는 댓글 검색
		//commentsController.commentsSelectByBoardNo(5);
		
		// ID에 해당하는 댓글 검색
		// commentsController.commentsSelectByID("jungwoo123");

		// 댓글 등록
//		int boardNo = 9;
//		String memberId = "jungwoo123";
//		String commentsContent = "진짜요?";
//		Comments comments = new Comments(0, boardNo, memberId, commentsContent, null);
//		commentsController.commentsInsert(comments);

		// 댓글 삭제
		// commentsController.commentsDelete(22);
		}

}
