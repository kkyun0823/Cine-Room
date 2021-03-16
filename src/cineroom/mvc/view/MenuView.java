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
				System.out.print("ÀÌ¿ëÇÏ½Ç ¸Þ´ºÀÇ ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
				int selectMenu = Integer.parseInt(sc.nextLine());
				switch (selectMenu) {
				case 1:
					// È¸¿ø°¡ÀÔ
					MenuView.signUp();
					break;
				case 2:
					// ·Î±×ÀÎ
					MenuView.signIn();
					break;
				case 9:
					System.out.println("Á¾·áÇÕ´Ï´Ù.");
					System.exit(0);
				default:
					System.out.println("!!ÁÖ¾îÁø ¹üÀ§ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä!!");
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("!!¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä!!");
			}
		}
	}

	public static void printMainMenu() {
		System.out.println("****CINE - ROOM¿¡ ¿À½Å°É È¯¿µÇÕ´Ï´Ù****");
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢  1.È¸¿ø°¡ÀÔ  |  2.·Î±×ÀÎ  |  9.Á¾·á  ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println();
	}


	public static void printUserMenu() {
		System.out.println( "***´Ô ¹Ý°©½À´Ï´Ù!");
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢  1.¿µÈ­°Ë»ö  |  2.ÆòÁ¡  |  3.¸®ºä°Ô½ÃÆÇ  |  4.¸¶ÀÌÆäÀÌÁö  |  9.·Î±×¾Æ¿ô  ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
	}
	public static void signUp() {
		System.out.println("****È¸¿ø°¡ÀÔ ÆäÀÌÁö****");
		String memberId = "";
		String memberPassword = "";
		while (true) {
			System.out.print("»ç¿ëÇÏ½Ç ID > ");
			memberId = sc.nextLine();
			// IDÁßº¹Ã¼Å© ¸Þ¼Òµå
			
			if (MemberController.duplicateByMemberId(memberId)) {
				System.out.println("ÀÌ¹Ì »ç¿ëÁßÀÎ IDÀÔ´Ï´Ù.");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("»ç¿ëÇÏ½Ç PW > ");
			memberPassword = sc.nextLine();
			System.out.print("PW È®ÀÎ > ");
			String memberPassword2 = sc.nextLine();
			if (memberPassword.equals(memberPassword2)) {
				break;
			}
			System.out.println("ºñ¹Ð¹øÈ£¿Í È®ÀÎÀÌ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
		}
		System.out.print("»ç¿ëÀÚ ÀÌ¸§ > ");
		String memberName = sc.nextLine();
		System.out.println("»ý³â¿ùÀÏ(YY-MM-DD) > ");
		String memberBirth = sc.nextLine();
		
		List<Integer> favorList = new ArrayList<Integer>();
		MenuView.printGenre();
		System.out.print("¼±È£ÇÏ´Â Àå¸£ÀÇ ¹øÈ£µéÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. (','·Î ±¸ºÐÁö¾î ÀÔ·ÂÇØÁÖ¼¼¿ä.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for(String s : resultarr) {
			int temp = Integer.parseInt(s);
			if(temp<0||temp>18) System.out.println("Àß¸øµÈ ÀÔ·ÂÀº Á¦¿ÜµÇ¾ú½À´Ï´Ù.");
			else {
				if(!favorList.contains(temp)) favorList.add(temp);
			}
		}
		Member member = new Member(memberId, memberPassword, memberName, memberBirth, 0);
		MemberController.signUp(member);
		MemberController.setFav(memberId, favorList);
	}

	public static void signIn() {
		System.out.println("****ID¿Í PW¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.****");
		System.out.print("ID > ");
		String ID = sc.nextLine();
		System.out.print("PW > ");
		String PW = sc.nextLine();

		MemberController.login(ID, PW);

	}

	public static void printUserMenu(String memberId) {
		System.out.println(memberId + "´Ô ¹Ý°©½À´Ï´Ù!");
		//¿µÈ­ÃßÃµ ¸Þ¼¼Áö//
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.¿µÈ­°Ë»ö  |  2.ÆòÁ¡  |  3.¸®ºä°Ô½ÃÆÇ  |  4.¸¶ÀÌÆäÀÌÁö  |  9.·Î±×¾Æ¿ô  ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println();
			try {
				System.out.print("ÀÌ¿ëÇÏ½Ç ¸Þ´º ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menuSelect = Integer.parseInt(sc.nextLine());
				
				switch (menuSelect) {
				case 1:
					//¿µÈ­°Ë»ö
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
					break;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
	}

	public static void printAdminMenu() {
		System.out.println("***********°ü¸®ÀÚ ¸Þ´ºÀÔ´Ï´Ù***********");
		while(true) {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢  1.°Ô½ÃÆÇ °ü¸®  |  2.¿î¿µ °ü¸®  |  3.¿µÈ­ °ü¸®  |  9.·Î±×¾Æ¿ô  ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println();
		try {
			System.out.print("ÀÌ¿ëÇÏ½Ç ¸Þ´º ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
			int menuSelect = Integer.parseInt(sc.nextLine());
			
			switch(menuSelect) {
			case 1:
				BoardView.printBoardMangeMenu();
				break;
			case 2:
				break;
			case 3:
				break;
			case 9:
				break;
			default :
				System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				break;
			}
		}catch (NumberFormatException e) {
			FailView.printMessage("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		}
		
		}
	}

	public static void printMovieSearchMenu() {
		loop1:
		while(true) {
			System.out.println("***********¿µÈ­°Ë»ö ¸Þ´ºÀÔ´Ï´Ù***********");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.ÀüÃ¼¿µÈ­  |  2.Á¦¸ñÀ¸·Î °Ë»ö  |  3.Àå¸£·Î °Ë»ö  |  4.°¨µ¶À¸·Î °Ë»ö  ¦¢");
			System.out.println("¦¢            5.¹è¿ì·Î °Ë»ö  |  6.»ó¿µÀÛ °Ë»ö  |  9.ÀÌÀü¸Þ´º              ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println();
			try {
				System.out.print("°Ë»öÇÏ½Ç Á¶°ÇÀ» ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					MovieController.moviesSelect();
					break;
				case 2:
					System.out.print("°Ë»öÇÏ½Ç Á¦¸ñ Å°¿öµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
					String title = sc.nextLine();
					MovieController.moviesSelectByTitle(title);
					break;
				case 3:
					MenuView.printSearchGenre();
					break;
				case 4:
					System.out.print("°Ë»öÇÏ½Ç °¨µ¶ Å°¿öµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
					String director = sc.nextLine();
					MovieController.moviesSelectByDirector(director);
					break;
				case 5:
					System.out.print("°Ë»öÇÏ½Ç ¹è¿ì Å°¿öµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
					String actor = sc.nextLine();
					MovieController.moviesSelectByActor(actor);
					break;
				case 6:
					MovieController.moviesSelectByReleaseDate();
					break;
				case 9 :
					break loop1;
				default:
					System.out.println("¹üÀ§³»ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
	}
	
	public static void printSearchGenre() {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("°Ë»öÇÏ½Ç Àå¸£¸¦ ¹øÈ£·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					continue;
				}
				MovieController.moviesSelectByGenre(genreNo);
				break;
			}catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
	}
	
	public static int selectMovieNo() {
		System.out.print("¼±ÅÃÇÏ½Ç ¿µÈ­ÀÇ ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}

	public static void printRateMenu(String memberId) {
		loop2 : while(true) {
			System.out.println("***********¿µÈ­ÆòÁ¡ ¸Þ´ºÀÔ´Ï´Ù***********");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.ÆòÁ¡µî·Ï  |  2.ÆòÁ¡¼öÁ¤  |  3.ÆòÁ¡»èÁ¦  |  9.ÀÌÀü¸Þ´º  ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println();
			try {
				System.out.print("ÀÌ¿ëÇÏ½Ç ¸Þ´º¸¦ ¹øÈ£·Î ´­·¯ÁÖ¼¼¿ä. > ");
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
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
				
			}catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
			
		}
	}
	
	public static void addRateMenu(String memberId) {
		String keyWord="";
		while(true) {
			System.out.print("ÆòÁ¡À» µî·ÏÇÏ½Ç ¿µÈ­ Á¦¸ñÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. >");
			keyWord = sc.nextLine();
			if(MovieController.moviesSelectByTitle(keyWord)) break;	
		}
		
		System.out.print("¸ñ·Ï Áß ÆòÁ¡À» µî·ÏÇÏ½Ç ¿µÈ­ÀÇ ÄÚµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		int rate  =0;
		while(true) {
			try {
				System.out.print("ÆòÁ¡À» ÀÔ·ÂÇØÁÖ¼¼¿ä.(1~5»çÀÌÀÇ Á¤¼ö·Î ÀÔ·Â °¡´É)> ");
				rate = Integer.parseInt(sc.nextLine());
				if(rate>0&&rate<6) break;
				System.out.println("1¿¡¼­ 5»çÀÌÀÇ Á¤¼ö·Î ÀÔ·ÂÇØÁÖ¼¼¿ä!");
			}catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
		Rate r = new Rate(0, memberId, movieNo, rate);
		RateController.setMovieRate(r);
	}
	
	public static void modifyRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo =0;
		int newRate = 0;
		while(true) {
			try {
				System.out.print("¼öÁ¤ÇÏ½Ç ÆòÁ¡ÀÇ ÄÚµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("ÄÚµå´Â ¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
		System.out.print("ÀÔ·ÂÇÏ½Ç ÆòÁ¡À» ÀÔ·ÂÇØÁÖ¼¼¿ä> ");
		newRate = Integer.parseInt(sc.nextLine());
		RateController.modifyRate(rateNo,memberId, newRate);
	}
	
	public static void deleteRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo =0;
		while(true) {
			try {
				System.out.print("»èÁ¦ÇÏ½Ç ÆòÁ¡ÀÇ ÄÚµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("ÄÚµå´Â ¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
		RateController.deleteMovieRate(rateNo,memberId);
	}

	
	
	
	
	
	public static void printGenre() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢  1.¾×¼Ç  |  2.ÄÚ¹Ìµð  |  3.·Î¸Ç½º  |  4.°øÆ÷  |  5.¾Ö´Ï¸ÞÀÌ¼Ç  |  6.SF  ¦¢");
		System.out.println("¦¢  7.ÆÇÅ¸Áö  |  8.¸ðÇè  |  9.¹üÁË  |  10.½º¸±·¯  |  11.´ÙÅ¥¸àÅÍ¸®         ¦¢");
		System.out.println("¦¢  12.µå¶ó¸¶  |  13.¹ÂÁöÄÃ/°ø¿¬  |  14.ÀüÀï  |  15.°¡Á·  |  16.¹Ì½ºÅÍ¸®   ¦¢");
		System.out.println("¦¢  17.»ç±Ø  |  18.±âÅ¸                                                    ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println();
	}
	

	public static void printMyPageMenu(String memberId) {
		//////////////ºñ¹Ð¹øÈ£¼öÁ¤, ¼±È£Àå¸£ ¼öÁ¤, ÀÛ¼ºÇÑ ±Û º¸±â, ÀÛ¼ºÇÑ ´ñ±Û º¸±â
		loop2 : while(true){
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.ºñ¹Ð¹øÈ£ ¼öÁ¤  |  2.¼±È£Àå¸£ ¼öÁ¤  |  3.³»°¡ ÀÛ¼ºÇÑ ±Û  |  4.³»°¡ ÀÛ¼ºÇÑ ´ñ±Û  |  9.ÀÌÀü¸Þ´º  ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println();
			System.out.print("ÀÌ¿ëÇÏ½Ç ¸Þ´ºÀÇ ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
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
				BoardView.printBoardMyPageMenu(list, memberId);
				break;
			case 4:
				List<Comments> colist =  CommentsController.commentsSelectByID(memberId);
				BoardView.printCommentMypageMenu(colist);
				break;
			case 9:
				break loop2;
			default:
				break;
			}
		}
	}
	public static void printModifyMenu(String memberId) {
		List<Integer> favorList = new ArrayList<Integer>();
		MenuView.printGenre();
		System.out.print("¼±È£ÇÏ´Â Àå¸£ÀÇ ¹øÈ£µéÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. (','·Î ±¸ºÐÁö¾î ÀÔ·ÂÇØÁÖ¼¼¿ä.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for(String s : resultarr) {
			int temp = Integer.parseInt(s);
			if(temp<0||temp>18) System.out.println("Àß¸øµÈ ÀÔ·ÂÀº Á¦¿ÜµÇ¾ú½À´Ï´Ù.");
			else {
				if(!favorList.contains(temp)) favorList.add(temp);
			}
		}
		MemberController.changeFavNo(memberId, favorList);
	}
	
	public static void printModifyPWMenu(String memberId) {
		String newPassword = "";
		String newPassword2 = "";
		while(true) {
			System.out.print("º¯°æÇÏ½Ç ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
			newPassword = sc.nextLine();
			System.out.print("º¯°æÇÒ ºñ¹Ð¹øÈ£ È®ÀÎ >");
			newPassword2 = sc.nextLine();
			if(newPassword.equals(newPassword2)) break;
			System.out.println("ºñ¹Ð¹øÈ£ È®ÀÎÀÌ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		}
		Member member = new Member(memberId, newPassword, null, null, 0);
		MemberController.memberUpdate(member);
	}
//°ü¸®ÀÚ °Ô½ÃÆÇ ¸Þ´º ¸Þ¼Òµå ³¡
	
	//°ü¸®ÀÚ °èÁ¤ ¸¸µç ÀÌÈÄ¿¡ ÁøÇà
	

	public static void printOperationMangeMenu() {
		
	}

	public static void printMovieMangeMenu() {
		
	}

}
