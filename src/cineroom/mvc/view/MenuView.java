package cineroom.mvc.view;

import java.util.Scanner;

import cineroom.mvc.controller.BoardController;
import cineroom.mvc.controller.MemberController;
import cineroom.mvc.controller.MovieController;
import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
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
			
			if (true) {
				break;
			}
			System.out.println("ÀÌ¹Ì »ç¿ëÁßÀÎ IDÀÔ´Ï´Ù.");
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

		Member member = new Member(memberId, memberPassword, memberName, memberBirth, 0);
		MemberController.signUp(member);
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
					break;
				case 3:
					MenuView.printBoardMenu(memberId);
					break;
				case 4:
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
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢  1.°Ô½ÃÆÇ °ü¸®  |  2.¿î¿µ °ü¸®  |  3.¿µÈ­ °ü¸®  |  9.·Î±×¾Æ¿ô  ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println();
	}

	public static void printMovieSearchMenu() {
		loop1:
		while(true) {
			System.out.println("***********¿µÈ­°Ë»ö ¸Þ´ºÀÔ´Ï´Ù***********");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.ÀüÃ¼¿µÈ­  |  2.Á¦¸ñÀ¸·Î °Ë»ö  |  3.Àå¸£·Î °Ë»ö  |  4.°¨µ¶À¸·Î °Ë»ö¦¢");
			System.out.println("¦¢            5.¹è¿ì·Î °Ë»ö  |  6.»ó¿µÀÛ °Ë»ö  |  9.ÀÌÀü¸Þ´º            ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
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
					System.out.println("°Ë»öÇÏ½Ç °¨µ¶ Å°¿öµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
					String director = sc.nextLine();
					MovieController.moviesSelectByDirector(director);
					break;
				case 5:
					break;
				case 6:
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

	public static void printRateMenu() {
		System.out.println("***********¿µÈ­ÆòÁ¡ ¸Þ´ºÀÔ´Ï´Ù***********");
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¦¢  1.ÆòÁ¡º¸±â  |  2.ÆòÁ¡µî·Ï  |  3.ÆòÁ¡¼öÁ¤  |  9.ÀÌÀü¸Þ´º  ¦¢");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println();
	}

	public static void printBoardMenu(String memberId) {
		loop1:
		while(true) {
			System.out.println("***********¸®ºä °Ô½ÃÆÇ ¸Þ´ºÀÔ´Ï´Ù***********");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.ÀüÃ¼ °Ô½ÃÆÇ  |  2.Àå¸£º° °Ô½ÃÆÇ  |  3.±Û ÀÛ¼º  |  9.ÀÌÀü¸Þ´º  ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println();
			try {
				System.out.print("ÀÌ¿ëÇÏ½Ç °Ô½ÃÆÇÀ» ¹øÈ£·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					BoardController.boardSelectByAll();
					break;
				case 2:
					MenuView.printSearchBoardByGenre();
					break;
				case 3:
					MenuView.printInsertBoardMenu(memberId);
					break;
				case 9:
					break loop1;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
				
			}catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
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
	public static void printSearchBoardByGenre() {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("°Ë»öÇÏ½Ç Àå¸£¸¦ ¹øÈ£·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					continue;
				}
				BoardController.boardSelectByGenre(genreNo);
				break;
			}catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
	}
	
	public static void printInsertBoardMenu(String memberId) {
		//¿µÈ­¸¦ °ñ¶ó¼­ ¹øÈ£¸¦ °¡Á®¿Í¾ßÇÏ´Â issue
		System.out.print("¸®ºä¸¦ ÀÛ¼ºÇÏ½Ç ¿µÈ­ Á¦¸ñÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. >");
		String keyWord = sc.nextLine();
		MovieController.moviesSelectByTitle(keyWord);
		
		System.out.print("¸ñ·Ï Áß ¸®ºä¸¦ ÀÛ¼ºÇÏ½Ç ¿µÈ­ÀÇ ÄÚµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("±ÛÁ¦¸ñÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä.> ");
		String title = sc.nextLine();
		System.out.print("±Û³»¿ëÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		String content = sc.nextLine();
		Board b =new Board(0, memberId, movieNo, title, content, null);
		BoardController.boardInsert(b);
	}

	public static void printMyPageMenu() {
		
	}
	//°ü¸®ÀÚ °èÁ¤ ¸¸µç ÀÌÈÄ¿¡ ÁøÇà
	public static void printBoardMangeMenu() {
		
	}

	public static void printOperationMangeMenu() {
		
	}

	public static void printMovieMangeMenu() {
		
	}
}
