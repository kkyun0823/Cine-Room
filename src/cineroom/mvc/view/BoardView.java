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
			System.out.println("***********리뷰 게시판 메뉴입니다***********");
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.println("│  1.전체 게시판  |  2.장르별 게시판  |  3.글 작성  |  9.이전메뉴  │");
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 게시판을 번호로 입력해주세요. > ");
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
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}
		}
	}

	public static void printBoardByNoMenu(List<Board> list, String memeberId) {
		EndView.printBoardList(list);
		loop2: while (true) {
			try {
				System.out.println("┌────────────────────────────┐");
				System.out.println("│ 1. 글조회  |  2. 이전메뉴  │");
				System.out.println("└────────────────────────────┘");
				System.out.print("메뉴번호를 입력해주세요 > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("글조회를 원하시는 글번호를 입력해주세요 > ");
					int no = Integer.parseInt(sc.nextLine());
					int boardNo = BoardController.getBoardNoByList(list, no);
					BoardController.boardSelectByNo(boardNo);
					if (boardNo != -1)
						printCommentMenu(memeberId, boardNo, list);
					break;
				case 2:
					break loop2;
				default:
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}
	}

	public static void printSearchBoardByGenre(String memberId) {
		int genreNo=0;
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("검색하실 장르를 번호로 입력해주세요. > ");
				genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("범위 내의 숫자로 입력해주세요.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}
		}
		List<Board> list = BoardController.boardSelectByGenre(genreNo);
		if (list != null)
			printBoardByNoMenu(list, memberId);
	}

	public static void printInsertBoardMenu(String memberId) {
		// 영화를 골라서 번호를 가져와야하는 issue
		String keyWord = "";
		while (true) {
			System.out.print("글을 작성하실 영화 제목을 입력해주세요. >");
			keyWord = sc.nextLine();
			if (MovieController.moviesSelectByTitle(keyWord))
				break;
		}

		System.out.print("목록 중 리뷰를 작성하실 영화의 코드를 입력해주세요. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("글제목을 입력해주세요.> ");
		String title = sc.nextLine();
		System.out.print("글내용을 입력해주세요. > ");
		String content = sc.nextLine();
		Board b = new Board(0, memberId, movieNo, title, content, null);
		BoardController.boardInsert(b);
	}

	public static void printCommentMenu(String memberId, int boardNo, List<Board> list) {
		loop3: while (true) {
			try {
				System.out.println("┌──────────────────────────────┐");
				System.out.println("│ 1. 댓글작성  |  2. 이전메뉴  │");
				System.out.println("└──────────────────────────────┘");
				System.out.print("메뉴번호를 입력해주세요. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					printInsertCommentsMenu(memberId, boardNo);

					break;
				case 2:
					break loop3;
				default:
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}

	}

	public static void printInsertCommentsMenu(String memberId, int boardNo) {
		System.out.print("댓글을 입력해주세요. > ");
		String comment = sc.nextLine();
		Comments co = new Comments(0, boardNo, memberId, comment, null);
		CommentsController.commentsInsert(co);

	}

	// 마이페이지 내 글 조회 및 삭제
	public static void printBoardMyPageMenu(List<Board> list, String memberId) {
		EndView.printBoardList(list);
		loop4: while (true) {
			try {
				System.out.println("┌───────────────────────────────────────┐");
				System.out.println("│ 1. 글조회  | 2. 글삭제  │ 3. 이전메뉴 │");
				System.out.println("└───────────────────────────────────────┘");
				System.out.print("메뉴번호를 입력해주세요 > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("글조회를 원하시는 글번호를 입력해주세요 > ");
					int no1 = Integer.parseInt(sc.nextLine());
					int boardNo1 = BoardController.getBoardNoByList(list, no1);
					if (list != null)
						BoardController.boardSelectByNo(boardNo1);
					break;
				case 2:
					System.out.println();
					System.out.print("삭제하실 글번호를 입력해주세요 > ");
					int no2 = Integer.parseInt(sc.nextLine());
					int boardNo2 = BoardController.getBoardNoByList(list, no2);
					if (boardNo2 != -1)
						BoardController.boardDelete(boardNo2);
					break;
				case 3:
					break loop4;
				default:
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}
	}

	// 마이페이지 내 댓글 보기 및 삭제
	public static void printCommentMypageMenu(List<Comments> list, String memberId) {
		EndView.printCommentsListById(list);
		loop5: while (true) {
			try {
				System.out.println("┌──────────────────────────────┐");
				System.out.println("│ 1. 댓글삭제  |  2. 이전메뉴  │");
				System.out.println("└──────────────────────────────┘");
				System.out.print("메뉴번호를 입력해주세요. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("삭제하실 댓글번호를 입력해주세요 > ");
					int no = Integer.parseInt(sc.nextLine());
					int commentNo = CommentsController.getCommentsNoByList(list, no);
					if (list != null)
						CommentsController.commentsDelete(commentNo);
					break;
				case 2:
					break loop5;
				default:
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}
	}

	// 관리자 계정으로 접속 후 게시판 관리 메소드
	public static void printBoardMangeMenu(String memberId) {

		loop6: while (true) {
			System.out.println("***********리뷰 게시판 관리 메뉴입니다***********");
			System.out.println("┌────────────────────────────────────────────────────────────────┐");
			System.out.println("│  1.전체 게시판 관리  |  2.장르별 게시판 관리 |  9.이전메뉴     │");
			System.out.println("└────────────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 게시판을 번호로 입력해주세요. > ");
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
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}
		}
	}

	public static void printBoardMangeByNoMenu(List<Board> list, String memeberId) {
		EndView.printBoardList(list);
		loop7: while (true) {
			try {
				System.out.println("┌────────────────────────────────────────┐");
				System.out.println("│ 1. 글조회  | 2. 글삭제  │ 3. 이전메뉴  │");
				System.out.println("└────────────────────────────────────────┘");
				System.out.print("메뉴번호를 입력해주세요 > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("글조회를 원하시는 글번호를 입력해주세요 > ");
					int no1 = Integer.parseInt(sc.nextLine());
					int boardNo1 = BoardController.getBoardNoByList(list, no1);
					BoardController.boardSelectByNo(boardNo1);
					if (boardNo1 != -1)
						printCommentMangeMenu(list, boardNo1, memeberId);
					break;
				case 2:
					System.out.println();
					System.out.print("삭제하실 글번호를 입력해주세요 > ");
					int no2 = Integer.parseInt(sc.nextLine());
					int boardNo2 = BoardController.getBoardNoByList(list, no2);
					if (boardNo2 != -1) {
						BoardController.boardDelete(boardNo2);
					} else {
						System.out.println("없는 번호입니다.");
					}
					break;
				case 3:
					break loop7;
				default:
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}
	}

	public static void printSearchBoardMangeByGenre(String memberId) {
		int genreNo = 0;
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("검색하실 장르를 번호로 입력해주세요. > ");
				genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("범위 내의 숫자로 입력해주세요.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}
		}
		List<Board> list = BoardController.boardSelectByGenre(genreNo);
		if (list != null)
			printBoardMangeByNoMenu(list, memberId);
	}

	public static void printCommentMangeMenu(List<Board> list, int boardNo, String memberId) {

		loop1: while (true) {
			try {
				System.out.println("┌──────────────────────────────┐");
				System.out.println("│ 1. 댓글삭제  |  2. 이전메뉴  │");
				System.out.println("└──────────────────────────────┘");
				System.out.print("메뉴번호를 입력해주세요. > ");
				int menuNo = Integer.parseInt(sc.nextLine());
				switch (menuNo) {
				case 1:
					System.out.println();
					System.out.print("삭제하실 댓글번호를 입력해주세요 > ");
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
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}
		}

	}

}
