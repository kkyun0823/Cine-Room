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
		loop1: while (true) {
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
					List<Board> list = BoardController.boardSelectByAll();
					if (list != null)
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
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
	}

	public static void printBoardByNoMenu(List<Board> list, String memeberId) {
		EndView.printBoardList(list);
		loop2: while (true) {
			try {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢ 1. ±ÛÁ¶È¸  |  2. ÀÌÀü¸Þ´º  ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("±ÛÁ¶È¸¸¦ ¿øÇÏ½Ã´Â ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no = Integer.parseInt(sc.nextLine());
					int boardNo = BoardController.getBoardNoByList(list, no);
					BoardController.boardSelectByNo(boardNo);
					if (boardNo != -1)
						printCommentMenu(memeberId, boardNo, list);
					break;
				case 2:
					break loop2;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		}
	}

	public static void printSearchBoardByGenre(String memberId) {
		int genreNo=0;
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("°Ë»öÇÏ½Ç Àå¸£¸¦ ¹øÈ£·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
		List<Board> list = BoardController.boardSelectByGenre(genreNo);
		if (list != null)
			printBoardByNoMenu(list, memberId);
	}

	public static void printInsertBoardMenu(String memberId) {
		// ¿µÈ­¸¦ °ñ¶ó¼­ ¹øÈ£¸¦ °¡Á®¿Í¾ßÇÏ´Â issue
		String keyWord = "";
		while (true) {
			System.out.print("±ÛÀ» ÀÛ¼ºÇÏ½Ç ¿µÈ­ Á¦¸ñÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. >");
			keyWord = sc.nextLine();
			if (MovieController.moviesSelectByTitle(keyWord))
				break;
		}

		System.out.print("¸ñ·Ï Áß ¸®ºä¸¦ ÀÛ¼ºÇÏ½Ç ¿µÈ­ÀÇ ÄÚµå¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("±ÛÁ¦¸ñÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä.> ");
		String title = sc.nextLine();
		System.out.print("±Û³»¿ëÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		String content = sc.nextLine();
		Board b = new Board(0, memberId, movieNo, title, content, null);
		BoardController.boardInsert(b);
	}

	public static void printCommentMenu(String memberId, int boardNo, List<Board> list) {
		loop3: while (true) {
			try {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢ 1. ´ñ±ÛÀÛ¼º  |  2. ÀÌÀü¸Þ´º  ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					printInsertCommentsMenu(memberId, boardNo);

					break;
				case 2:
					break loop3;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		}

	}

	public static void printInsertCommentsMenu(String memberId, int boardNo) {
		System.out.print("´ñ±ÛÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
		String comment = sc.nextLine();
		Comments co = new Comments(0, boardNo, memberId, comment, null);
		CommentsController.commentsInsert(co);

	}

	// ¸¶ÀÌÆäÀÌÁö ³» ±Û Á¶È¸ ¹× »èÁ¦
	public static void printBoardMyPageMenu(List<Board> list, String memberId) {
		EndView.printBoardList(list);
		loop4: while (true) {
			try {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢ 1. ±ÛÁ¶È¸  | 2. ±Û»èÁ¦  ¦¢ 3. ÀÌÀü¸Þ´º ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("±ÛÁ¶È¸¸¦ ¿øÇÏ½Ã´Â ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no1 = Integer.parseInt(sc.nextLine());
					int boardNo1 = BoardController.getBoardNoByList(list, no1);
					if (list != null)
						BoardController.boardSelectByNo(boardNo1);
					break;
				case 2:
					System.out.println();
					System.out.print("»èÁ¦ÇÏ½Ç ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no2 = Integer.parseInt(sc.nextLine());
					int boardNo2 = BoardController.getBoardNoByList(list, no2);
					if (boardNo2 != -1)
						BoardController.boardDelete(boardNo2);
					break;
				case 3:
					break loop4;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		}
	}

	// ¸¶ÀÌÆäÀÌÁö ³» ´ñ±Û º¸±â ¹× »èÁ¦
	public static void printCommentMypageMenu(List<Comments> list, String memberId) {
		EndView.printCommentsListById(list);
		loop5: while (true) {
			try {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢ 1. ´ñ±Û»èÁ¦  |  2. ÀÌÀü¸Þ´º  ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("»èÁ¦ÇÏ½Ç ´ñ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no = Integer.parseInt(sc.nextLine());
					int commentNo = CommentsController.getCommentsNoByList(list, no);
					if (list != null)
						CommentsController.commentsDelete(commentNo);
					break;
				case 2:
					break loop5;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		}
	}

	// °ü¸®ÀÚ °èÁ¤À¸·Î Á¢¼Ó ÈÄ °Ô½ÃÆÇ °ü¸® ¸Þ¼Òµå
	public static void printBoardMangeMenu(String memberId) {

		loop6: while (true) {
			System.out.println("***********¸®ºä °Ô½ÃÆÇ °ü¸® ¸Þ´ºÀÔ´Ï´Ù***********");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢  1.ÀüÃ¼ °Ô½ÃÆÇ °ü¸®  |  2.Àå¸£º° °Ô½ÃÆÇ °ü¸® |  9.ÀÌÀü¸Þ´º     ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println();
			try {
				System.out.print("ÀÌ¿ëÇÏ½Ç °Ô½ÃÆÇÀ» ¹øÈ£·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					List<Board> list = BoardController.boardSelectByAll();
					if (list != null)
						printBoardMangeByNoMenu(list, memberId);

					break;
				case 2:
					printSearchBoardMangeByGenre(memberId);
					break;
				case 9:
					break loop6;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
	}

	public static void printBoardMangeByNoMenu(List<Board> list, String memeberId) {
		EndView.printBoardList(list);
		loop7: while (true) {
			try {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢ 1. ±ÛÁ¶È¸  | 2. ±Û»èÁ¦  ¦¢ 3. ÀÌÀü¸Þ´º  ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("±ÛÁ¶È¸¸¦ ¿øÇÏ½Ã´Â ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no1 = Integer.parseInt(sc.nextLine());
					int boardNo1 = BoardController.getBoardNoByList(list, no1);
					BoardController.boardSelectByNo(boardNo1);
					if (boardNo1 != -1)
						printCommentMangeMenu(list, boardNo1, memeberId);
					break;
				case 2:
					System.out.println();
					System.out.print("»èÁ¦ÇÏ½Ç ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no2 = Integer.parseInt(sc.nextLine());
					int boardNo2 = BoardController.getBoardNoByList(list, no2);
					if (boardNo2 != -1) {
						BoardController.boardDelete(boardNo2);
					} else {
						System.out.println("¾ø´Â ¹øÈ£ÀÔ´Ï´Ù.");
					}
					break;
				case 3:
					break loop7;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		}
	}

	public static void printSearchBoardMangeByGenre(String memberId) {
		int genreNo = 0;
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("°Ë»öÇÏ½Ç Àå¸£¸¦ ¹øÈ£·Î ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
		List<Board> list = BoardController.boardSelectByGenre(genreNo);
		if (list != null)
			printBoardMangeByNoMenu(list, memberId);
	}

	public static void printCommentMangeMenu(List<Board> list, int boardNo, String memberId) {

		loop1: while (true) {
			try {
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println("¦¢ 1. ´ñ±Û»èÁ¦  |  2. ÀÌÀü¸Þ´º  ¦¢");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("»èÁ¦ÇÏ½Ç ´ñ±Û¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä > ");
					int no = Integer.parseInt(sc.nextLine());
					List<Comments> list2 = CommentsController.commentsSelectByBoardNo(boardNo);
					if (list != null) {
						int commentNo = CommentsController.getCommentsNoByList(list2, no);
						CommentsController.commentsDelete(commentNo);
					}
					break;
				case 2:
					break loop1;
				default:
					System.out.println("¹üÀ§ ³»ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("¼ýÀÚ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		}

	}

}
