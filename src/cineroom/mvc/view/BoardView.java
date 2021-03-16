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
		loop1:
		while(true) {
			System.out.println("***********葬箔 啪衛っ 詭景殮棲棻***********");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.瞪羹 啪衛っ  |  2.濰腦滌 啪衛っ  |  3.旋 濛撩  |  9.檜瞪詭景  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 啪衛っ擊 廓�ㄦ� 殮溘п輿撮蹂. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					List<Board> list = BoardController.boardSelectByAll();
					printBoardByNoMenu(list, memberId);
						
					break;
				case 2:
					printSearchBoardByGenre(memberId);
					break;
				case 3:
					printInsertBoardMenu(memberId);
					break;
				case 9:
					break loop1;
				default:
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					break;
				}
				
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}
	public static void printBoardByNoMenu (List<Board> list ,String memeberId) {
		loop1:
			while(true) {
				try {
					System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
					System.out.println("弛 1. 旋褻��  |  2. 檜瞪詭景  弛");
					System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
					System.out.print("詭景廓�ㄧ� 殮溘п輿撮蹂 > ");
					int menuNo = Integer.parseInt(sc.nextLine());
					switch (menuNo){
						case 1:
							System.out.println();
							System.out.print("旋褻�虜� 錳ж衛朝 旋廓�ㄧ� 殮溘п輿撮蹂 > ");
							int no = Integer.parseInt(sc.nextLine());
							int boardNo = BoardController.getBoardNoByList(list, no);
							BoardController.boardSelectByNo(boardNo);
							if(boardNo!=-1) 
							printCommentMenu(memeberId, boardNo);
							
							break;
						case 2:
							break loop1;
						default:
							System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
							break;
					}
				}catch (NumberFormatException e) {
					System.out.println("璋濠煎 殮溘п輿撮蹂.");
				}
			}
	}
	
	public static void printSearchBoardByGenre(String memberId) {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("匐儀ж褒 濰腦蒂 廓�ㄦ� 殮溘п輿撮蹂. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					continue;
				}
				List<Board> list= BoardController.boardSelectByGenre(genreNo);
				printBoardByNoMenu(list, memberId);
				break;
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}
	
	
	public static void printInsertBoardMenu(String memberId) {
		//艙�飛� 埤塭憮 廓�ㄧ� 陛螳諦撿ж朝 issue
		String keyWord="";
		while(true) {
			System.out.print("旋擊 濛撩ж褒 艙�� 薯跡擊 殮溘п輿撮蹂. >");
			keyWord = sc.nextLine();
			if(MovieController.moviesSelectByTitle(keyWord)) break;	
		}
		
		System.out.print("跡煙 醞 葬箔蒂 濛撩ж褒 艙�倣� 囀萄蒂 殮溘п輿撮蹂. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("旋薯跡擊 殮溘п輿撮蹂.> ");
		String title = sc.nextLine();
		System.out.print("旋頂辨擊 殮溘п輿撮蹂. > ");
		String content = sc.nextLine();
		Board b =new Board(0, memberId, movieNo, title, content, null);
		BoardController.boardInsert(b);
	}
	
	public static void printCommentMenu(String memberId, int boardNo) {
		loop1:
		while(true) {
			try {
				System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
				System.out.println("弛 1. 渤旋濛撩  |  2. 檜瞪詭景  弛");
				System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
				System.out.print("詭景廓�ㄧ� 殮溘п輿撮蹂. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo){
					case 1:
						printInsertCommentsMenu(memberId, boardNo);
						break;
					case 2:
						break loop1;
					default:
						System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п輿撮蹂.");
			}
		}
		
	}
	
	public static void printInsertCommentsMenu (String memberId , int boardNo) {
		System.out.print("渤旋擊 殮溘п輿撮蹂. > ");
		String comment = sc.nextLine();
		Comments co = new Comments(0, boardNo, memberId, comment, null);
		CommentsController.commentsInsert(co);
		
	}
	
	//葆檜む檜雖 頂 旋 褻�� 塽 餉薯
	public static void printBoardMyPageMenu (List<Board> list ,String memeberId) {
		loop1:
			while(true) {
				try {
					System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
					System.out.println("弛 1. 旋褻��  | 2. 旋餉薯  3. 檜瞪詭景  弛");
					System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
					System.out.print("詭景廓�ㄧ� 殮溘п輿撮蹂 > ");
					int menuNo = Integer.parseInt(sc.nextLine());
					switch (menuNo){
						case 1:
							System.out.println();
							System.out.print("旋褻�虜� 錳ж衛朝 旋廓�ㄧ� 殮溘п輿撮蹂 > ");
							int no1 = Integer.parseInt(sc.nextLine());
							int boardNo1 = BoardController.getBoardNoByList(list, no1);
							BoardController.boardSelectByNo(boardNo1);
							break;
						case 2:
							System.out.println();
							System.out.print("餉薯ж褒 旋廓�ㄧ� 殮溘п輿撮蹂 > ");
							int no2 = Integer.parseInt(sc.nextLine());
							int boardNo2 = BoardController.getBoardNoByList(list, no2);
							BoardController.boardDelete(boardNo2);
						case 3:
							break loop1;
						default:
							System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
							break;
					}
				}catch (NumberFormatException e) {
					System.out.println("璋濠煎 殮溘п輿撮蹂.");
				}
			}
	}
	
	//葆檜む檜雖 頂 渤旋 爾晦 塽 餉薯
	public static void printCommentMypageMenu(List<Comments> list) {
		loop1:
		while(true) {
			try {
				System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
				System.out.println("弛 1. 渤旋餉薯  |  2. 檜瞪詭景  弛");
				System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
				System.out.print("詭景廓�ㄧ� 殮溘п輿撮蹂. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo){
					case 1:
						System.out.println();
						System.out.print("餉薯ж褒 渤旋廓�ㄧ� 殮溘п輿撮蹂 > ");
						int no = Integer.parseInt(sc.nextLine());
						int commentNo = CommentsController.getCommentsNoByList(list, no);
						CommentsController.commentsDelete(commentNo);
						break;
					case 2:
						break loop1;
					default:
						System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п輿撮蹂.");
			}
		}
	}
	//婦葬濠 啗薑戲煎 蕾樓 �� 啪衛っ 婦葬 詭模萄
	public static void printBoardMangeMenu() {
		loop1:
		while(true) {
			System.out.println("***********葬箔 啪衛っ 婦葬 詭景殮棲棻***********");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.瞪羹 啪衛っ 婦葬  |  2.濰腦滌 啪衛っ 婦葬 |  9.檜瞪詭景  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 啪衛っ擊 廓�ㄦ� 殮溘п輿撮蹂. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					List<Board> list = BoardController.boardSelectByAll();
					printBoardMangeByNoMenu(list);
						
					break;
				case 2:
					printSearchBoardMangeByGenre();
					break;
				case 9:
					break loop1;
				default:
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}
	
	public static void printBoardMangeByNoMenu (List<Board> list ) {
		loop1:
			while(true) {
				try {
					System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
					System.out.println("弛 1. 旋褻��  | 2. 旋餉薯  3. 檜瞪詭景  弛");
					System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
					System.out.print("詭景廓�ㄧ� 殮溘п輿撮蹂 > ");
					int menuNo = Integer.parseInt(sc.nextLine());
					switch (menuNo){
						case 1:
							System.out.println();
							System.out.print("旋褻�虜� 錳ж衛朝 旋廓�ㄧ� 殮溘п輿撮蹂 > ");
							int no1 = Integer.parseInt(sc.nextLine());
							int boardNo1 = BoardController.getBoardNoByList(list, no1);
							BoardController.boardSelectByNo(boardNo1);
							printCommentMangeMenu(boardNo1);
							break;
						case 2:
							System.out.println();
							System.out.print("餉薯ж褒 旋廓�ㄧ� 殮溘п輿撮蹂 > ");
							int no2 = Integer.parseInt(sc.nextLine());
							int boardNo2 = BoardController.getBoardNoByList(list, no2);
							BoardController.boardDelete(boardNo2);
						case 3:
							break loop1;
						default:
							System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
							break;
					}
				}catch (NumberFormatException e) {
					System.out.println("璋濠煎 殮溘п輿撮蹂.");
				}
			}
	}
	
	public static void printSearchBoardMangeByGenre() {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("匐儀ж褒 濰腦蒂 廓�ㄦ� 殮溘п輿撮蹂. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					continue;
				}
				List<Board> list= BoardController.boardSelectByGenre(genreNo);
				printBoardMangeByNoMenu(list);
				break;
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}
	
	public static void printCommentMangeMenu(int boardNo) {
		loop1:
		while(true) {
			try {
				System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
				System.out.println("弛 1. 渤旋餉薯  |  2. 檜瞪詭景  弛");
				System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
				System.out.print("詭景廓�ㄧ� 殮溘п輿撮蹂. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo){
					case 1:
						System.out.println();
						System.out.print("餉薯ж褒 渤旋廓�ㄧ� 殮溘п輿撮蹂 > ");
						int no = Integer.parseInt(sc.nextLine());
						List<Comments> list = CommentsController.commentsSelectByBoardNo(boardNo);
						int commentNo = CommentsController.getCommentsNoByList(list, no);
						CommentsController.commentsDelete(commentNo);
						break;
					case 2:
						break loop1;
					default:
						System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п輿撮蹂.");
			}
		}
		
	}

}
