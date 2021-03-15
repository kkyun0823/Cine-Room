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
	public static void printBoardByNo(Board dto) {
		System.out.println("┌──────────────────────┐");
		System.out.println("│     Movie  |  " + dto.getMovieTitle() );
		System.out.println("│     Title  |  " + dto.getBoardTitle());
		System.out.println("│     Review |  " +dto.getBoardContent());
		System.out.println("│     Writer |  " +dto.getMemberId());
		System.out.println("│     Date   |  " +dto.getBoardDate());
		System.out.println("└──────────────────────┘ ");
		System.out.println("  <Comment>");
		for(Comments com : dto.getCommentsList()) {
			System.out.println(com);
		}
		System.out.println();
	}

	/**
	 * ID에 해당하는 댓글 검색 출력하기
	 */
	public static void printCommentsList(List<Comments> list) {
		System.out.println("------검색결과 (" + list.size() + "건)---------");
		int i = 1;
		for (Comments dto : list) {
			System.out.println("댓글 " + i + " | ID : " + dto.getMemberId() + " | 내용 : " + dto.getCommentsContent() + " | 등록일 : " + dto.getCommentsDate());
			i++;
		}
		System.out.println();
	}
	//전체게시판 메뉴
	public static void printMenuBoardAll() {
		boardController.boardSelectByAll();
	}
	
	
	//각 게시판에 해당하는 선택 메뉴
		public static void printMenuBoardByEach() {
			while(true) {
			System.out.println("1.글 조회 2. 댓글조회 3. 댓글등록 ");
			System.out.println(" 메뉴선택 ▶");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
					case 2: commentsController.commentsSelectByBoardNo(5); break;
					default:
						System.out.println("잘못되었습니다..다시 입력해주세요.");
					
				}
			}catch (NumberFormatException e){
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
		    }
		}	
		/**
		 * 글번호에 해당하는 게시판 검색 출력하기
		 */
		public static void printBoard(int no) {
			
		}
		
		public static int getBoardNoByList (List<Board> list, int no) {
			int boardNo = list.get(no-1).getBoardNo();
			return boardNo;
		}
		
	/**
	 * 등록, 수정, 삭제인 경우에 성공메시지 출력
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
//			System.out.println("글번호"+(i+1) + list.get(i));
//		}
//		int inp = 2;
//		Board b = list.get(2-1);
//		Board b = bd.boardSelect(list.get(inp-1));
//		System.out.println(b);
		

		// 유저가 리뷰게시판 항목을 선택했을시
//		while (true) {
//			System.out.println("  *************** 리뷰게시판 *****************");
//			System.out.println("┌────────────────────────────┐   ");
//			System.out.println("│1.전체게시판 |  2.장르별게시판 |  3.게시글등록  4.이전메뉴       ");
//			System.out.println("└────────────────────────────┘  ");
//			System.out.println(" 메뉴선택 ▶");
//			try {
//				int menu = Integer.parseInt(sc.nextLine());
//				switch (menu) {
//				case 1:
//					boardController.boardSelectByAll(); // 전체 게시판 조회
//					
//					break;
//				case 2:
//					System.out.println("1.액션 2.코미디 3.로맨스 4.공포 5.애니메이션 6.SF ");
//					System.out.println("7.판타지 8.모험 9.범죄 10.스릴러 11.다큐멘터리 12.드라마 13.뮤지컬/공연");
//					System.out.println("14.전쟁 15.가족 16.미스터리 17. 사극 18. 기타");
//					System.out.println();
//					System.out.println("장르 선택▶");
//					int genreMenu = Integer.parseInt(sc.nextLine());
//					boardController.boardSelectByGenre(genreMenu);
//					printMenuBoardByEach();
//					break;
//				case 3:
//					System.out.println("글등록을 원하시는 영화를 검색해주세요");
//					//제목으로 영화 검색기능을 구현
//					//글 등록을 위한 입력값 받기 
//					//(ID는 세션에서 가져와서 처리,영화번호(영화검색에 대한 결과값 이용자가 참고)
//					//boardTitle, boardContent
//				case 4:
//					break;
//				default:
//					System.out.println("잘못되었습니다..다시 입력해주세요.");
//				}
//			}catch (NumberFormatException e){
//				System.out.println("메뉴는 숫자만 가능합니다.");
//			}
//		
//		}
		
	
		//리뷰 게시판에 접속시
		//1. 전체게시판 2. 장르별게시판 3. 새로운글 등록 4. 이전메뉴
		//1-1)전체 게시판 --- 1. 글조회 (글에 대한 상세 내용을 열람 가능 ex한줄평), 2.이전메뉴
		//1-2)글조회 항목을 선택하면, 그 안에서 댓글도 볼수있고 댓글등록가능
		//2-1)장르별 게시판 -- 1. 글조회 (글에 대한 상세 내용을 열람 가능 ex한줄평), 2.이전메뉴
		//2-2)글조회 항목을 선택하면, 그 안에서 댓글도 볼수있고 댓글등록가능
		//3)글등록 -- 글등록을 누르면 영화검색기능을 이용하여 원하는 영화번호를 얻을수있게 
		//영화리스트를 보여주는 결과값 출력해서 보여주고 사용자는 이것을 참조하여 글을 등록할 수 있다.
		
		

		//1. 글조회 2. 댓글등록
		
		//해당되는 글번호를 입력해주세요 > 3
		
		// 게시판 전체글 검색
		//boardController.boardSelectByAll();

		// 장르번호에 해당하는 글 검색
		//boardController.boardSelectByGenre(5);
		
		//List<Board> list = boardController.boardSelectByGenre(5);
		//int boardNo = getBoardNoByList(list, 3);
		
		//System.out.println();
		// ID에 해당하는 글 검색
		 //boardController.boardSelectByID("jungwoo123");

		//System.out.println();
		// 글번호에 해당하는 글 검색
		//boardController.boardSelectByNo(boardNo);

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
		commentsController.commentsSelectByID("jungwoo123");

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
