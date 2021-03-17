package cineroom.mvc.view;

import java.util.ArrayList;
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
		System.out.println("***椒 奩骨蝗棲棻!");
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

		List<Integer> favorList = new ArrayList<Integer>();
		MenuView.printGenre();
		System.out.print("摹��ж朝 濰腦曖 廓�ㄤ橉� 殮溘п輿撮蹂. (','煎 掘碟雖橫 殮溘п輿撮蹂.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for (String s : resultarr) {
			int temp = Integer.parseInt(s);
			if (temp < 0 || temp > 18)
				System.out.println("澀跤脹 殮溘擎 薯諼腎歷蝗棲棻.");
			else {
				if (!favorList.contains(temp))
					favorList.add(temp);
			}
		}
		Member member = new Member(memberId, memberPassword, memberName, memberBirth, 0);
		MemberController.signUp(member);
		MemberController.setFav(memberId, favorList);
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
		MenuView.printRecommenMsg(memberId);
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
					// 艙�降侄�
					MenuView.printMovieSearchMenu();
					break;
				case 2:
					MenuView.printRateMenu(memberId);
					break;
				case 3:
					BoardView.printBoardMenu(memberId);
					break;
				case 4:
					MenuView.printMyPageMenu(memberId);
					break;
				case 9:
					MenuView.logout(memberId);
					return;
				default:
					System.out.println("彰嬪 頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}

	private static void printRecommenMsg(String memberId) {
		MovieController.recommendMovie(memberId);
	}

	public static void printAdminMenu(String memberId) {
		System.out.println("***********婦葬濠 詭景殮棲棻***********");
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.啪衛っ 婦葬  |  2.遴艙 婦葬  |  3.艙�� 婦葬  |  9.煎斜嬴醒  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 詭景 廓�ㄧ� 殮溘п輿撮蹂. > ");
				int menuSelect = Integer.parseInt(sc.nextLine());

				switch (menuSelect) {
				case 1:
					BoardView.printBoardMangeMenu(memberId);
					break;
				case 2:
					MenuView.printOperationMangeMenu();
					break;
				case 3:
					MenuView.printMovieMangeMenu();
					break;
				case 9:
					MenuView.logout(memberId);
					return;
				default:
					System.out.println("彰嬪 頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("璋濠煎 殮溘п輿撮蹂.");
			}
		}
	}
	
	public static void logout(String userId) {
		Session session = new Session(userId);
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
		System.out.println("煎斜嬴醒 腎歷蝗棲棻.");
	}

	public static void printMovieSearchMenu() {
		loop1: while (true) {
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
				case 9:
					break loop1;
				default:
					System.out.println("彰嬪頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
	}

	public static void printSearchGenre() {
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("匐儀ж褒 濰腦蒂 廓�ㄦ� 殮溘п輿撮蹂. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					continue;
				}
				MovieController.moviesSelectByGenre(genreNo);
				break;
			} catch (NumberFormatException e) {
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
		loop2: while (true) {
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
					MenuView.modifyRateMenu(memberId);
					break;
				case 3:
					MenuView.deleteRateMenu(memberId);
					break;
				case 9:
					break loop2;
				default:
					System.out.println("彰嬪 頂曖 璋濠煎 殮溘п輿撮蹂.");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}

		}
	}

	public static void addRateMenu(String memberId) {
		String keyWord = "";
		while (true) {
			System.out.print("ゎ薄擊 蛔煙ж褒 艙�� 薯跡擊 殮溘п輿撮蹂. >");
			keyWord = sc.nextLine();
			if (MovieController.moviesSelectByTitle(keyWord))
				break;
		}

		System.out.print("跡煙 醞 ゎ薄擊 蛔煙ж褒 艙�倣� 囀萄蒂 殮溘п輿撮蹂. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		int rate = 0;
		while (true) {
			try {
				System.out.print("ゎ薄擊 殮溘п輿撮蹂.(1~5餌檜曖 薑熱煎 殮溘 陛棟)> ");
				rate = Integer.parseInt(sc.nextLine());
				if (rate > 0 && rate < 6)
					break;
				System.out.println("1縑憮 5餌檜曖 薑熱煎 殮溘п輿撮蹂!");
			} catch (NumberFormatException e) {
				System.out.println("璋濠煎 殮溘п 輿撮蹂.");
			}
		}
		Rate r = new Rate(0, memberId, movieNo, rate);
		RateController.setMovieRate(r);
	}

	public static void modifyRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo = 0;
		int newRate = 0;
		while (true) {
			try {
				System.out.print("熱薑ж褒 ゎ薄曖 囀萄蒂 殮溘п輿撮蹂> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("囀萄朝 璋濠煎 殮溘п 輿撮蹂.");
			}
		}
		System.out.print("殮溘ж褒 ゎ薄擊 殮溘п輿撮蹂> ");
		newRate = Integer.parseInt(sc.nextLine());
		RateController.modifyRate(rateNo, memberId, newRate);
	}

	public static void deleteRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo = 0;
		while (true) {
			try {
				System.out.print("餉薯ж褒 ゎ薄曖 囀萄蒂 殮溘п輿撮蹂> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("囀萄朝 璋濠煎 殮溘п 輿撮蹂.");
			}
		}
		RateController.deleteMovieRate(rateNo, memberId);
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

	public static void printMyPageMenu(String memberId) {
		////////////// 綠塵廓�ˉ鶬�, 摹��濰腦 熱薑, 濛撩и 旋 爾晦, 濛撩и 渤旋 爾晦
		 loop1: while (true) {
			System.out.println(
					"忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.綠塵廓�� 熱薑  |  2.摹��濰腦 熱薑  |  3.頂陛 濛撩и 旋  |  4.頂陛 濛撩и 渤旋  |  9.檜瞪詭景  弛");
			System.out.println(
					"戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			System.out.print("檜辨ж褒 詭景曖 廓�ㄧ� 殮溘п輿撮蹂. > ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				MenuView.printModifyPWMenu(memberId);
				break;
			case 2:
				MenuView.printModifyMenu(memberId);
				break;
			case 3:
				List<Board> list = BoardController.boardSelectByID(memberId);
				if(list!= null)
				BoardView.printBoardMyPageMenu(list, memberId);
				break;
			case 4:
				List<Comments> colist = CommentsController.commentsSelectByID(memberId);
				if(colist!= null)
				BoardView.printCommentMypageMenu(colist,memberId);
				break;
			case 9:
				break loop1;
			default:
				break;
			}
		}
	}

	public static void printModifyMenu(String memberId) {
		List<Integer> favorList = new ArrayList<Integer>();
		MenuView.printGenre();
		System.out.print("摹��ж朝 濰腦曖 廓�ㄤ橉� 殮溘п輿撮蹂. (','煎 掘碟雖橫 殮溘п輿撮蹂.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for (String s : resultarr) {
			int temp = Integer.parseInt(s);
			if (temp < 0 || temp > 18)
				System.out.println("澀跤脹 殮溘擎 薯諼腎歷蝗棲棻.");
			else {
				if (!favorList.contains(temp))
					favorList.add(temp);
			}
		}
		MemberController.changeFavNo(memberId, favorList);
	}

	public static void printModifyPWMenu(String memberId) {
		String newPassword = "";
		String newPassword2 = "";
		while (true) {
			System.out.print("滲唳ж褒 綠塵廓�ㄧ� 殮溘п輿撮蹂. > ");
			newPassword = sc.nextLine();
			System.out.print("滲唳й 綠塵廓�� �挫� >");
			newPassword2 = sc.nextLine();
			if (newPassword.equals(newPassword2))
				break;
			System.out.println("綠塵廓�� �挫怹� 橾纂ж雖 彊蝗棲棻. 棻衛 殮溘п輿撮蹂.");
		}
		Member member = new Member(memberId, newPassword, null, null, 0);
		MemberController.memberUpdate(member);
	}
//婦葬濠 啪衛っ 詭景 詭模萄 部

	// 婦葬濠 啗薑 虜萇 檜�醴� 霞ч

	public static void printOperationMangeMenu() {
		MemberController.memberSelectAll();
		loop3 : while(true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.�蛾艭餑�  |  9.檜瞪詭景  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 詭景曖 廓�ㄧ� 殮溘п輿撮蹂.> ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.print("餉薯ж褒 �蛾衋� ID蒂 殮溘п輿撮蹂.> ");
					String targetId = sc.nextLine();
					MemberController.memberDelete(targetId);
					break;
				case 9:
					break loop3;
				default:
					System.out.println("彰嬪頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("廓�ㄦ� 殮溘п輿撮蹂.");
			}
		}
	}
	
	public static void printMovieMangeMenu() {
		MovieController.moviesSelect();
		loop3 : while(true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛  1.艙�香餑�  |  2.艙�倥葥�  |  3.艙�乘鶬�  |  9.檜瞪詭景  弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println();
			try {
				System.out.print("檜辨ж褒 詭景曖 廓�ㄧ� 殮溘п輿撮蹂.> ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.print("餉薯ж褒 艙�倣� 囀萄蒂 殮溘п輿撮蹂.> ");
					int targetNo = Integer.parseInt(sc.nextLine());
					MovieController.deleteMovie(targetNo);
					break;
				case 2:
					MenuView.addMovieMenu();
					break;
				case 3:
					MenuView.updateMovieMenu();
					break;
				case 9:
					break loop3;
				default:
					System.out.println("彰嬪頂曖 璋濠蒂 殮溘п輿撮蹂.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("廓�ㄦ� 殮溘п輿撮蹂.");
			}
		}
	}

	public static void addMovieMenu() {
		System.out.print("蛔煙ж褒 艙�倣� 囀萄蒂 殮溘п輿撮蹂.>");
		int movieNo = Integer.parseInt(sc.nextLine());
		MenuView.printGenre();
		System.out.print("蛔煙ж褒 艙�倣� 濰腦蒂 殮溘п輿撮蹂.>");
		int genreNo = Integer.parseInt(sc.nextLine());
		System.out.print("蛔煙ж褒 艙�倣� 薯跡擊 殮溘п輿撮蹂.>");
		String movieTitle = sc.nextLine();
		System.out.print("蛔煙ж褒 艙�倣� 偃瑰橾(YY-MM-DD)擊 殮溘п輿撮蹂.>");
		String releaseDate = sc.nextLine();
		System.out.print("蛔煙ж褒 艙�倣� 鼻艙衛除擊 殮溘п輿撮蹂.>");
		int runningTime = Integer.parseInt(sc.nextLine());
		System.out.print("蛔煙ж褒 艙�倣� 艙�降巡黃� 殮溘п輿撮蹂.>");
		String movieDirector = sc.nextLine();
		System.out.print("蛔煙ж褒 艙�倣� 轎翱寡辦蒂 蔑ル(,)煎 掘碟ж罹 殮溘п輿撮蹂.>");
		
		Movie movie = new Movie(movieNo, genreNo, movieTitle, releaseDate, runningTime, 0, movieDirector);
		MovieController.addMovie(movie);
	}
	
	public static void updateMovieMenu() {
		System.out.println("熱薑擎 鼻艙衛除, 艙�降巡�, 艙�香鬌繡� 陛棟м棲棻.");
		System.out.print("熱薑ж褒 艙�倣� 囀萄蒂 殮溘п輿撮蹂.> ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("熱薑ж褒 艙�倣� 鼻艙衛除擊 殮溘п輿撮蹂.> ");
		int runningTime = Integer.parseInt(sc.nextLine());
		System.out.print("熱薑ж褒 艙�倣� 艙�降巡黃� 殮溘п輿撮蹂.> ");
		String movieDirector = sc.nextLine();
		int movieState=0;
		while(true) {
			System.out.print("熱薑ж褒 艙�倣� 艙�香鬌繡� 殮溘п輿撮蹂.(1 = 鼻艙醞 / 0=鼻艙謙猿)> ");
			movieState =Integer.parseInt(sc.nextLine());
			if(movieState==1|| movieState==0) break;
			System.out.println("1 / 0 煎 殮溘п輿撮蹂.");
		}
		Movie movie = new Movie(movieNo, 0, null, null, runningTime, movieState, movieDirector);
		MovieController.updateMovie(movie);
	}
}
