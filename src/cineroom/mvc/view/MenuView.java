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
				System.out.print("이용하실 메뉴의 번호를 입력해주세요 > ");
				int selectMenu = Integer.parseInt(sc.nextLine());
				switch (selectMenu) {
				case 1:
					// 회원가입
					MenuView.signUp();
					break;
				case 2:
					// 로그인
					MenuView.signIn();
					break;
				case 9:
					System.out.println("종료합니다.");
					System.exit(0);
				default:
					System.out.println("!!주어진 범위의 숫자를 입력해주세요!!");
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("!!숫자로 입력해주세요!!");
			}
		}
	}

	public static void printMainMenu() {
		System.out.println("****CINE - ROOM에 오신걸 환영합니다****");
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("│  1.회원가입  |  2.로그인  |  9.종료  │");
		System.out.println("└──────────────────────────────────────┘");
		System.out.println();
	}

	public static void printUserMenu() {
		System.out.println("***님 반갑습니다!");
		System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│  1.영화검색  |  2.평점  |  3.리뷰게시판  |  4.마이페이지  |  9.로그아웃  │");
		System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
	}

	public static void signUp() {
		System.out.println("****회원가입 페이지****");
		String memberId = "";
		String memberPassword = "";
		while (true) {
			System.out.print("사용하실 ID > ");
			memberId = sc.nextLine();
			// ID중복체크 메소드

			if (MemberController.duplicateByMemberId(memberId)) {
				System.out.println("이미 사용중인 ID입니다.");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("사용하실 PW > ");
			memberPassword = sc.nextLine();
			System.out.print("PW 확인 > ");
			String memberPassword2 = sc.nextLine();
			if (memberPassword.equals(memberPassword2)) {
				break;
			}
			System.out.println("비밀번호와 확인이 일치하지 않습니다.");
		}
		System.out.print("사용자 이름 > ");
		String memberName = sc.nextLine();
		System.out.println("생년월일(YY-MM-DD) > ");
		String memberBirth = sc.nextLine();

		List<Integer> favorList = new ArrayList<Integer>();
		MenuView.printGenre();
		System.out.print("선호하는 장르의 번호들을 입력해주세요. (','로 구분지어 입력해주세요.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for (String s : resultarr) {
			int temp = Integer.parseInt(s);
			if (temp < 0 || temp > 18)
				System.out.println("잘못된 입력은 제외되었습니다.");
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
		System.out.println("****ID와 PW를 입력해 주세요.****");
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
			System.out.println("┌──────────────────────────────────────────────────────────────────────────┐");
			System.out.println("│  1.영화검색  |  2.평점  |  3.리뷰게시판  |  4.마이페이지  |  9.로그아웃  │");
			System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 메뉴 번호를 입력해주세요. > ");
				int menuSelect = Integer.parseInt(sc.nextLine());

				switch (menuSelect) {
				case 1:
					// 영화검색
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
					System.out.println("범위 내의 숫자를 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("숫자로 입력해 주세요.");
			}
		}
	}

	private static void printRecommenMsg(String memberId) {
		MovieController.recommendMovie(memberId);
	}

	public static void printAdminMenu(String memberId) {
		System.out.println("***********관리자 메뉴입니다***********");
		while (true) {
			System.out.println("┌────────────────────────────────────────────────────────────────┐");
			System.out.println("│  1.게시판 관리  |  2.운영 관리  |  3.영화 관리  |  9.로그아웃  │");
			System.out.println("└────────────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 메뉴 번호를 입력해주세요. > ");
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
					System.out.println("범위 내의 숫자를 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("숫자로 입력해주세요.");
			}
		}
	}
	
	public static void logout(String userId) {
		Session session = new Session(userId);
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
		System.out.println("로그아웃 되었습니다.");
	}

	public static void printMovieSearchMenu() {
		loop1: while (true) {
			System.out.println("***********영화검색 메뉴입니다***********");
			System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
			System.out.println("│  1.전체영화  |  2.제목으로 검색  |  3.장르로 검색  |  4.감독으로 검색  │");
			System.out.println("│            5.배우로 검색  |  6.상영작 검색  |  9.이전메뉴              │");
			System.out.println("└────────────────────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("검색하실 조건을 숫자로 입력해주세요. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					MovieController.moviesSelect();
					break;
				case 2:
					System.out.print("검색하실 제목 키워드를 입력해주세요. > ");
					String title = sc.nextLine();
					MovieController.moviesSelectByTitle(title);
					break;
				case 3:
					MenuView.printSearchGenre();
					break;
				case 4:
					System.out.print("검색하실 감독 키워드를 입력해주세요. > ");
					String director = sc.nextLine();
					MovieController.moviesSelectByDirector(director);
					break;
				case 5:
					System.out.print("검색하실 배우 키워드를 입력해주세요. > ");
					String actor = sc.nextLine();
					MovieController.moviesSelectByActor(actor);
					break;
				case 6:
					MovieController.moviesSelectByReleaseDate();
					break;
				case 9:
					break loop1;
				default:
					System.out.println("범위내의 숫자를 입력해주세요.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}
		}
	}

	public static void printSearchGenre() {
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("검색하실 장르를 번호로 입력해주세요. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("범위 내의 숫자로 입력해주세요.");
					continue;
				}
				MovieController.moviesSelectByGenre(genreNo);
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}
		}
	}

	public static int selectMovieNo() {
		System.out.print("선택하실 영화의 번호를 입력해주세요. > ");
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}

	public static void printRateMenu(String memberId) {
		loop2: while (true) {
			System.out.println("***********영화평점 메뉴입니다***********");
			System.out.println("┌───────────────────────────────────────────────────────────┐");
			System.out.println("│  1.평점등록  |  2.평점수정  |  3.평점삭제  |  9.이전메뉴  │");
			System.out.println("└───────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 메뉴를 번호로 눌러주세요. > ");
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
					System.out.println("범위 내의 숫자로 입력해주세요.");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
			}

		}
	}

	public static void addRateMenu(String memberId) {
		String keyWord = "";
		while (true) {
			System.out.print("평점을 등록하실 영화 제목을 입력해주세요. >");
			keyWord = sc.nextLine();
			if (MovieController.moviesSelectByTitle(keyWord))
				break;
		}

		System.out.print("목록 중 평점을 등록하실 영화의 코드를 입력해주세요. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		int rate = 0;
		while (true) {
			try {
				System.out.print("평점을 입력해주세요.(1~5사이의 정수로 입력 가능)> ");
				rate = Integer.parseInt(sc.nextLine());
				if (rate > 0 && rate < 6)
					break;
				System.out.println("1에서 5사이의 정수로 입력해주세요!");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해 주세요.");
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
				System.out.print("수정하실 평점의 코드를 입력해주세요> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("코드는 숫자로 입력해 주세요.");
			}
		}
		System.out.print("입력하실 평점을 입력해주세요> ");
		newRate = Integer.parseInt(sc.nextLine());
		RateController.modifyRate(rateNo, memberId, newRate);
	}

	public static void deleteRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo = 0;
		while (true) {
			try {
				System.out.print("삭제하실 평점의 코드를 입력해주세요> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("코드는 숫자로 입력해 주세요.");
			}
		}
		RateController.deleteMovieRate(rateNo, memberId);
	}

	public static void printGenre() {
		System.out.println("┌─────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│  1.액션  |  2.코미디  |  3.로맨스  |  4.공포  |  5.애니메이션  |  6.SF  │");
		System.out.println("│  7.판타지  |  8.모험  |  9.범죄  |  10.스릴러  |  11.다큐멘터리         │");
		System.out.println("│  12.드라마  |  13.뮤지컬/공연  |  14.전쟁  |  15.가족  |  16.미스터리   │");
		System.out.println("│  17.사극  |  18.기타                                                    │");
		System.out.println("└─────────────────────────────────────────────────────────────────────────┘");
		System.out.println();
	}

	public static void printMyPageMenu(String memberId) {
		////////////// 비밀번호수정, 선호장르 수정, 작성한 글 보기, 작성한 댓글 보기
		 loop1: while (true) {
			System.out.println(
					"┌──────────────────────────────────────────────────────────────────────────────────────────────────┐");
			System.out.println("│  1.비밀번호 수정  |  2.선호장르 수정  |  3.내가 작성한 글  |  4.내가 작성한 댓글  |  9.이전메뉴  │");
			System.out.println(
					"└──────────────────────────────────────────────────────────────────────────────────────────────────┘");
			System.out.println();
			System.out.print("이용하실 메뉴의 번호를 입력해주세요. > ");
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
		System.out.print("선호하는 장르의 번호들을 입력해주세요. (','로 구분지어 입력해주세요.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for (String s : resultarr) {
			int temp = Integer.parseInt(s);
			if (temp < 0 || temp > 18)
				System.out.println("잘못된 입력은 제외되었습니다.");
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
			System.out.print("변경하실 비밀번호를 입력해주세요. > ");
			newPassword = sc.nextLine();
			System.out.print("변경할 비밀번호 확인 >");
			newPassword2 = sc.nextLine();
			if (newPassword.equals(newPassword2))
				break;
			System.out.println("비밀번호 확인이 일치하지 않습니다. 다시 입력해주세요.");
		}
		Member member = new Member(memberId, newPassword, null, null, 0);
		MemberController.memberUpdate(member);
	}
//관리자 게시판 메뉴 메소드 끝

	// 관리자 계정 만든 이후에 진행

	public static void printOperationMangeMenu() {
		MemberController.memberSelectAll();
		loop3 : while(true) {
			System.out.println("┌─────────────────────────────┐");
			System.out.println("│  1.회원삭제  |  9.이전메뉴  │");
			System.out.println("└─────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 메뉴의 번호를 입력해주세요.> ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.print("삭제하실 회원의 ID를 입력해주세요.> ");
					String targetId = sc.nextLine();
					MemberController.memberDelete(targetId);
					break;
				case 9:
					break loop3;
				default:
					System.out.println("범위내의 숫자를 입력해주세요.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("번호로 입력해주세요.");
			}
		}
	}
	
	public static void printMovieMangeMenu() {
		MovieController.moviesSelect();
		loop3 : while(true) {
			System.out.println("┌───────────────────────────────────────────────────────────┐");
			System.out.println("│  1.영화삭제  |  2.영화추가  |  3.영화수정  |  9.이전메뉴  │");
			System.out.println("└───────────────────────────────────────────────────────────┘");
			System.out.println();
			try {
				System.out.print("이용하실 메뉴의 번호를 입력해주세요.> ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.print("삭제하실 영화의 코드를 입력해주세요.> ");
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
					System.out.println("범위내의 숫자를 입력해주세요.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("번호로 입력해주세요.");
			}
		}
	}

	public static void addMovieMenu() {
		System.out.print("등록하실 영화의 코드를 입력해주세요.>");
		int movieNo = Integer.parseInt(sc.nextLine());
		MenuView.printGenre();
		System.out.print("등록하실 영화의 장르를 입력해주세요.>");
		int genreNo = Integer.parseInt(sc.nextLine());
		System.out.print("등록하실 영화의 제목을 입력해주세요.>");
		String movieTitle = sc.nextLine();
		System.out.print("등록하실 영화의 개봉일(YY-MM-DD)을 입력해주세요.>");
		String releaseDate = sc.nextLine();
		System.out.print("등록하실 영화의 상영시간을 입력해주세요.>");
		int runningTime = Integer.parseInt(sc.nextLine());
		System.out.print("등록하실 영화의 영화감독을 입력해주세요.>");
		String movieDirector = sc.nextLine();
		System.out.print("등록하실 영화의 출연배우를 쉼표(,)로 구분하여 입력해주세요.>");
		
		Movie movie = new Movie(movieNo, genreNo, movieTitle, releaseDate, runningTime, 0, movieDirector);
		MovieController.addMovie(movie);
	}
	
	public static void updateMovieMenu() {
		System.out.println("수정은 상영시간, 영화감독, 영화상태만 가능합니다.");
		System.out.print("수정하실 영화의 코드를 입력해주세요.> ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("수정하실 영화의 상영시간을 입력해주세요.> ");
		int runningTime = Integer.parseInt(sc.nextLine());
		System.out.print("수정하실 영화의 영화감독을 입력해주세요.> ");
		String movieDirector = sc.nextLine();
		int movieState=0;
		while(true) {
			System.out.print("수정하실 영화의 영화상태를 입력해주세요.(1 = 상영중 / 0=상영종료)> ");
			movieState =Integer.parseInt(sc.nextLine());
			if(movieState==1|| movieState==0) break;
			System.out.println("1 / 0 로 입력해주세요.");
		}
		Movie movie = new Movie(movieNo, 0, null, null, runningTime, movieState, movieDirector);
		MovieController.updateMovie(movie);
	}
}
