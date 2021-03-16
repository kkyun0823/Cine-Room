package cineroom.mvc.view;

import java.util.List;
import java.util.Scanner;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.controller.CommentsController;
import cineroom.mvc.controller.MemberController;
import cineroom.mvc.controller.MovieController;
import cineroom.mvc.controller.RateController;
import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Comments;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;
import cineroom.mvc.session.Session;
import cineroom.mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			MenuView.printMainMenu();
			try {
				System.out.print("檜辨ж褒 詭景曖 廓�ㄧ� 殮溘п輿撮蹂 > ");
				int selectMenu = Integer.parseInt(sc.nextLine());
				switch (selectMenu) {
				case 1:
					// �蛾灠㊣�
					MenuView.signUp();
					break;
				case 2:
					// 煎斜檣
					MenuView.signIn();
					break;
				case 9:
					System.out.println("謙猿м棲棻.");
					System.exit(0);
				default:
					System.out.println("!!輿橫霞 彰嬪曖 璋濠蒂 殮溘п輿撮蹂!!");
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("!!璋濠煎 殮溘п輿撮蹂!!");
			}
		}
	}

	public static void printMainMenu() {
		System.out.println("****CINE - ROOM縑 螃褐勘 �紊腎桭炴�****");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛  1.�蛾灠㊣�  |  2.煎斜檣  |  9.謙猿  弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println();
	}


	public static void printUserMenu() {
		System.out.println( "***椒 奩骨蝗棲棻!");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛  1.艙�降侄�  |  2.ゎ薄  |  3.葬箔啪衛っ  |  4.葆檜む檜雖  |  9.煎斜嬴醒  弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
	}
	public static void signUp() {
		System.out.println("****�蛾灠㊣� む檜雖****");
		String memberId = "";
		String memberPassword = "";
		while (true) {
			System.out.print("餌辨ж褒 ID > ");
			memberId = sc.nextLine();
			// ID醞犒羹觼 詭模萄
			
			if (MemberController.duplicateByMemberId(memberId)) {
				System.out.println("檜嘐 餌辨醞檣 ID殮棲棻.");
				continue;
			}
			System.out.println("餌辨 陛棟и ID殮棲棻!");
			break;
		}

		while (true) {
			System.out.print("餌辨ж褒 PW > ");
			memberPassword = sc.nextLine();
			System.out.print("PW �挫� > ");
			String memberPassword2 = sc.nextLine();
			if (memberPassword.equals(memberPassword2)) {
				break;
			}
			System.out.println("綠塵廓�ˋ� �挫怹� 橾纂ж雖 彊蝗棲棻.");
		}
		System.out.print("餌辨濠 檜葷 > ");
		String memberName = sc.nextLine();
		System.out.println("儅喇錯橾(YY-MM-DD) > ");
		String memberBirth = sc.nextLine();

		Member member = new Member(memberId, memberPassword, memberName, memberBirth, 0);
		MemberController.signUp(member);
	}

	public static void signIn() {
		System.out.println("****ID諦 PW蒂 殮溘п 輿撮蹂.****");
		System.out.print("ID > ");
		String ID = sc.nextLine();
		System.out.print("PW > ");
		String PW = sc.nextLine();

		MemberController.login(ID, PW);

	}

	public static void printUserMenu(String memberId) {
		System.out.println(memberId + "椒 奩骨蝗棲棻!");
		//艙�倥葃� 詭撮雖//
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.艙�降侄�  |  2.ゎ薄  |  3.葬箔啪衛っ  |  4.葆檜む檜雖  |  9.煎斜嬴醒  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 詭景 廓�ㄧ� 殮溘п輿撮蹂. > ");
				int menuSelect = Integer.parseInt(sc.nextLine());
				
				switch (menuSelect) {
				case 1:
					//艙�降侄�
					MenuView.printMovieSearchMenu();
					break;
				case 2:
					MenuView.printRateMenu(memberId);
					break;
				case 3:
					MenuView.printBoardMenu(memberId);
					break;
				case 4:
					break;
				case 9:
					break;
				default:
					System.out.println("彰嬪 頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}

	public static void printAdminMenu() {
		System.out.println("***********婦葬濠 詭景殮棲棻***********");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛  1.啪衛っ 婦葬  |  2.遴艙 婦葬  |  3.艙�� 婦葬  |  9.煎斜嬴醒  弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println();
	}

	public static void printMovieSearchMenu() {
		loop1:
		while(true) {
			System.out.println("***********艙�降侄� 詭景殮棲棻***********");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.瞪羹艙��  |  2.薯跡戲煎 匐儀  |  3.濰腦煎 匐儀  |  4.馬絮戲煎 匐儀  弛");
			System.out.println("弛            5.寡辦煎 匐儀  |  6.鼻艙濛 匐儀  |  9.檜瞪詭景              弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("匐儀ж褒 褻勒擊 璋濠煎 殮溘п輿撮蹂. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					MovieController.moviesSelect();
					break;
				case 2:
					System.out.print("匐儀ж褒 薯跡 酈錶萄蒂 殮溘п輿撮蹂. > ");
					String title = sc.nextLine();
					MovieController.moviesSelectByTitle(title);
					break;
				case 3:
					MenuView.printSearchGenre();
					break;
				case 4:
					System.out.print("匐儀ж褒 馬絮 酈錶萄蒂 殮溘п輿撮蹂. > ");
					String director = sc.nextLine();
					MovieController.moviesSelectByDirector(director);
					break;
				case 5:
					System.out.print("匐儀ж褒 寡辦 酈錶萄蒂 殮溘п輿撮蹂. > ");
					String actor = sc.nextLine();
					MovieController.moviesSelectByActor(actor);
					break;
				case 6:
					MovieController.moviesSelectByReleaseDate();
					break;
				case 9 :
					break loop1;
				default:
					System.out.println("彰嬪頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}
	
	public static void printSearchGenre() {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("匐儀ж褒 濰腦蒂 廓�ㄦ� 殮溘п輿撮蹂. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					continue;
				}
				MovieController.moviesSelectByGenre(genreNo);
				break;
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}
	
	public static int selectMovieNo() {
		System.out.print("摹鷗ж褒 艙�倣� 廓�ㄧ� 殮溘п輿撮蹂. > ");
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}

	public static void printRateMenu(String memberId) {
		loop2 : while(true) {
			System.out.println("***********艙�倖臗� 詭景殮棲棻***********");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.ゎ薄蛔煙  |  2.ゎ薄熱薑  |  3.ゎ薄餉薯  |  9.檜瞪詭景  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 詭景蒂 廓�ㄦ� 揚楝輿撮蹂. > ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					MenuView.addRateMenu(memberId);
					break;
				case 2:
					break;
				case 3:
					MenuView.deleteRateMenu(memberId);
					break;
				case 6:
					break loop2;
				default:
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					break;
				}
				
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
			
		}
	}
	
	public static void addRateMenu(String memberId) {
		String keyWord="";
		while(true) {
			System.out.print("ゎ薄擊 蛔煙ж褒 艙�� 薯跡擊 殮溘п輿撮蹂. >");
			keyWord = sc.nextLine();
			if(MovieController.moviesSelectByTitle(keyWord)) break;	
		}
		
		System.out.print("跡煙 醞 ゎ薄擊 蛔煙ж褒 艙�倣� 囀萄蒂 殮溘п輿撮蹂. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		int rate  =0;
		while(true) {
			try {
				System.out.print("ゎ薄擊 殮溘п輿撮蹂.(1~5餌檜曖 薑熱煎 殮溘 陛棟)> ");
				rate = Integer.parseInt(sc.nextLine());
				if(rate>0&&rate<6) break;
				System.out.println("1縑憮 5餌檜曖 薑熱煎 殮溘п輿撮蹂!");
			}catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
		Rate r = new Rate(0, memberId, movieNo, rate);
		RateController.setMovieRate(r);
	}
	
	public static void deleteRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo =0;
		while(true) {
			try {
				System.out.print("餉薯ж褒 ゎ薄曖 囀萄蒂 殮溘п輿撮蹂> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("囀萄朝 璋濠煎 殮溘п 輿撮蹂.");
			}
		}
		RateController.deleteMovieRate(rateNo,memberId);
	}

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
					MenuView.printSearchBoardByGenre(memberId);
					break;
				case 3:
					MenuView.printInsertBoardMenu(memberId);
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
	
	
	
	
	public static void printGenre() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛  1.擋暮  |  2.囀嘐蛤  |  3.煎裔蝶  |  4.奢ん  |  5.擁棲詭檜暮  |  6.SF  弛");
		System.out.println("弛  7.っ顫雖  |  8.賅я  |  9.彰賸  |  10.蝶萵楝  |  11.棻聽詮攪葬         弛");
		System.out.println("弛  12.萄塭葆  |  13.嗽雖鏽/奢翱  |  14.瞪爵  |  15.陛褶  |  16.嘐蝶攪葬   弛");
		System.out.println("弛  17.餌斛  |  18.晦顫                                                    弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println();
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
			System.out.print("ゎ薄擊 蛔煙ж褒 艙�� 薯跡擊 殮溘п輿撮蹂. >");
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

	public static void printMyPageMenu() {
		
	}
	//婦葬濠 啗薑 虜萇 檜�醴� 霞ч
	public static void printBoardMangeMenu() {
		
	}

	public static void printOperationMangeMenu() {
		
	}

	public static void printMovieMangeMenu() {
		
	}

}
