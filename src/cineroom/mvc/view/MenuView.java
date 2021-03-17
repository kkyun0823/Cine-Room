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
				System.out.print("�̿��Ͻ� �޴��� ��ȣ�� �Է����ּ��� > ");
				int selectMenu = Integer.parseInt(sc.nextLine());
				switch (selectMenu) {
				case 1:
					// ȸ������
					MenuView.signUp();
					break;
				case 2:
					// �α���
					MenuView.signIn();
					break;
				case 9:
					System.out.println("�����մϴ�.");
					System.exit(0);
				default:
					System.out.println("!!�־��� ������ ���ڸ� �Է����ּ���!!");
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("!!���ڷ� �Է����ּ���!!");
			}
		}
	}

	public static void printMainMenu() {
		System.out.println("****CINE - ROOM�� ���Ű� ȯ���մϴ�****");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("��  1.ȸ������  |  2.�α���  |  9.����  ��");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println();
	}

	public static void printUserMenu() {
		System.out.println("***�� �ݰ����ϴ�!");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.��ȭ�˻�  |  2.����  |  3.����Խ���  |  4.����������  |  9.�α׾ƿ�  ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public static void signUp() {
		System.out.println("****ȸ������ ������****");
		String memberId = "";
		String memberPassword = "";
		while (true) {
			System.out.print("����Ͻ� ID > ");
			memberId = sc.nextLine();
			// ID�ߺ�üũ �޼ҵ�

			if (MemberController.duplicateByMemberId(memberId)) {
				System.out.println("�̹� ������� ID�Դϴ�.");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("����Ͻ� PW > ");
			memberPassword = sc.nextLine();
			System.out.print("PW Ȯ�� > ");
			String memberPassword2 = sc.nextLine();
			if (memberPassword.equals(memberPassword2)) {
				break;
			}
			System.out.println("��й�ȣ�� Ȯ���� ��ġ���� �ʽ��ϴ�.");
		}
		System.out.print("����� �̸� > ");
		String memberName = sc.nextLine();
		System.out.println("�������(YY-MM-DD) > ");
		String memberBirth = sc.nextLine();

		List<Integer> favorList = new ArrayList<Integer>();
		MenuView.printGenre();
		System.out.print("��ȣ�ϴ� �帣�� ��ȣ���� �Է����ּ���. (','�� �������� �Է����ּ���.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for (String s : resultarr) {
			int temp = Integer.parseInt(s);
			if (temp < 0 || temp > 18)
				System.out.println("�߸��� �Է��� ���ܵǾ����ϴ�.");
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
		System.out.println("****ID�� PW�� �Է��� �ּ���.****");
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
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ȭ�˻�  |  2.����  |  3.����Խ���  |  4.����������  |  9.�α׾ƿ�  ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �޴� ��ȣ�� �Է����ּ���. > ");
				int menuSelect = Integer.parseInt(sc.nextLine());

				switch (menuSelect) {
				case 1:
					// ��ȭ�˻�
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
					System.out.println("���� ���� ���ڸ� �Է����ּ���.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("���ڷ� �Է��� �ּ���.");
			}
		}
	}

	private static void printRecommenMsg(String memberId) {
		MovieController.recommendMovie(memberId);
	}

	public static void printAdminMenu(String memberId) {
		System.out.println("***********������ �޴��Դϴ�***********");
		while (true) {
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.�Խ��� ����  |  2.� ����  |  3.��ȭ ����  |  9.�α׾ƿ�  ��");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �޴� ��ȣ�� �Է����ּ���. > ");
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
					System.out.println("���� ���� ���ڸ� �Է����ּ���.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("���ڷ� �Է����ּ���.");
			}
		}
	}
	
	public static void logout(String userId) {
		Session session = new Session(userId);
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}

	public static void printMovieSearchMenu() {
		loop1: while (true) {
			System.out.println("***********��ȭ�˻� �޴��Դϴ�***********");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ü��ȭ  |  2.�������� �˻�  |  3.�帣�� �˻�  |  4.�������� �˻�  ��");
			System.out.println("��            5.���� �˻�  |  6.���� �˻�  |  9.�����޴�              ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�˻��Ͻ� ������ ���ڷ� �Է����ּ���. > ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					MovieController.moviesSelect();
					break;
				case 2:
					System.out.print("�˻��Ͻ� ���� Ű���带 �Է����ּ���. > ");
					String title = sc.nextLine();
					MovieController.moviesSelectByTitle(title);
					break;
				case 3:
					MenuView.printSearchGenre();
					break;
				case 4:
					System.out.print("�˻��Ͻ� ���� Ű���带 �Է����ּ���. > ");
					String director = sc.nextLine();
					MovieController.moviesSelectByDirector(director);
					break;
				case 5:
					System.out.print("�˻��Ͻ� ��� Ű���带 �Է����ּ���. > ");
					String actor = sc.nextLine();
					MovieController.moviesSelectByActor(actor);
					break;
				case 6:
					MovieController.moviesSelectByReleaseDate();
					break;
				case 9:
					break loop1;
				default:
					System.out.println("�������� ���ڸ� �Է����ּ���.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}

	public static void printSearchGenre() {
		while (true) {
			MenuView.printGenre();
			try {
				System.out.print("�˻��Ͻ� �帣�� ��ȣ�� �Է����ּ���. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if (genreNo > 18 || genreNo <= 0) {
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					continue;
				}
				MovieController.moviesSelectByGenre(genreNo);
				break;
			} catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}

	public static int selectMovieNo() {
		System.out.print("�����Ͻ� ��ȭ�� ��ȣ�� �Է����ּ���. > ");
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}

	public static void printRateMenu(String memberId) {
		loop2: while (true) {
			System.out.println("***********��ȭ���� �޴��Դϴ�***********");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.�������  |  2.��������  |  3.��������  |  9.�����޴�  ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �޴��� ��ȣ�� �����ּ���. > ");
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
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}

		}
	}

	public static void addRateMenu(String memberId) {
		String keyWord = "";
		while (true) {
			System.out.print("������ ����Ͻ� ��ȭ ������ �Է����ּ���. >");
			keyWord = sc.nextLine();
			if (MovieController.moviesSelectByTitle(keyWord))
				break;
		}

		System.out.print("��� �� ������ ����Ͻ� ��ȭ�� �ڵ带 �Է����ּ���. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		int rate = 0;
		while (true) {
			try {
				System.out.print("������ �Է����ּ���.(1~5������ ������ �Է� ����)> ");
				rate = Integer.parseInt(sc.nextLine());
				if (rate > 0 && rate < 6)
					break;
				System.out.println("1���� 5������ ������ �Է����ּ���!");
			} catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
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
				System.out.print("�����Ͻ� ������ �ڵ带 �Է����ּ���> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("�ڵ�� ���ڷ� �Է��� �ּ���.");
			}
		}
		System.out.print("�Է��Ͻ� ������ �Է����ּ���> ");
		newRate = Integer.parseInt(sc.nextLine());
		RateController.modifyRate(rateNo, memberId, newRate);
	}

	public static void deleteRateMenu(String memberId) {
		RateController.rateSelectByID(memberId);
		int rateNo = 0;
		while (true) {
			try {
				System.out.print("�����Ͻ� ������ �ڵ带 �Է����ּ���> ");
				rateNo = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("�ڵ�� ���ڷ� �Է��� �ּ���.");
			}
		}
		RateController.deleteMovieRate(rateNo, memberId);
	}

	public static void printGenre() {
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.�׼�  |  2.�ڹ̵�  |  3.�θǽ�  |  4.����  |  5.�ִϸ��̼�  |  6.SF  ��");
		System.out.println("��  7.��Ÿ��  |  8.����  |  9.����  |  10.������  |  11.��ť���͸�         ��");
		System.out.println("��  12.���  |  13.������/����  |  14.����  |  15.����  |  16.�̽��͸�   ��");
		System.out.println("��  17.���  |  18.��Ÿ                                                    ��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}

	public static void printMyPageMenu(String memberId) {
		////////////// ��й�ȣ����, ��ȣ�帣 ����, �ۼ��� �� ����, �ۼ��� ��� ����
		 loop1: while (true) {
			System.out.println(
					"��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��й�ȣ ����  |  2.��ȣ�帣 ����  |  3.���� �ۼ��� ��  |  4.���� �ۼ��� ���  |  9.�����޴�  ��");
			System.out.println(
					"��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			System.out.print("�̿��Ͻ� �޴��� ��ȣ�� �Է����ּ���. > ");
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
		System.out.print("��ȣ�ϴ� �帣�� ��ȣ���� �Է����ּ���. (','�� �������� �Է����ּ���.) > ");
		String result = sc.nextLine();
		String[] resultarr = result.split(",");
		for (String s : resultarr) {
			int temp = Integer.parseInt(s);
			if (temp < 0 || temp > 18)
				System.out.println("�߸��� �Է��� ���ܵǾ����ϴ�.");
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
			System.out.print("�����Ͻ� ��й�ȣ�� �Է����ּ���. > ");
			newPassword = sc.nextLine();
			System.out.print("������ ��й�ȣ Ȯ�� >");
			newPassword2 = sc.nextLine();
			if (newPassword.equals(newPassword2))
				break;
			System.out.println("��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		}
		Member member = new Member(memberId, newPassword, null, null, 0);
		MemberController.memberUpdate(member);
	}
//������ �Խ��� �޴� �޼ҵ� ��

	// ������ ���� ���� ���Ŀ� ����

	public static void printOperationMangeMenu() {
		MemberController.memberSelectAll();
		loop3 : while(true) {
			System.out.println("��������������������������������������������������������������");
			System.out.println("��  1.ȸ������  |  9.�����޴�  ��");
			System.out.println("��������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �޴��� ��ȣ�� �Է����ּ���.> ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.print("�����Ͻ� ȸ���� ID�� �Է����ּ���.> ");
					String targetId = sc.nextLine();
					MemberController.memberDelete(targetId);
					break;
				case 9:
					break loop3;
				default:
					System.out.println("�������� ���ڸ� �Է����ּ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("��ȣ�� �Է����ּ���.");
			}
		}
	}
	
	public static void printMovieMangeMenu() {
		MovieController.moviesSelect();
		loop3 : while(true) {
			System.out.println("��������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ȭ����  |  2.��ȭ�߰�  |  3.��ȭ����  |  9.�����޴�  ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �޴��� ��ȣ�� �Է����ּ���.> ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.print("�����Ͻ� ��ȭ�� �ڵ带 �Է����ּ���.> ");
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
					System.out.println("�������� ���ڸ� �Է����ּ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("��ȣ�� �Է����ּ���.");
			}
		}
	}

	public static void addMovieMenu() {
		System.out.print("����Ͻ� ��ȭ�� �ڵ带 �Է����ּ���.>");
		int movieNo = Integer.parseInt(sc.nextLine());
		MenuView.printGenre();
		System.out.print("����Ͻ� ��ȭ�� �帣�� �Է����ּ���.>");
		int genreNo = Integer.parseInt(sc.nextLine());
		System.out.print("����Ͻ� ��ȭ�� ������ �Է����ּ���.>");
		String movieTitle = sc.nextLine();
		System.out.print("����Ͻ� ��ȭ�� ������(YY-MM-DD)�� �Է����ּ���.>");
		String releaseDate = sc.nextLine();
		System.out.print("����Ͻ� ��ȭ�� �󿵽ð��� �Է����ּ���.>");
		int runningTime = Integer.parseInt(sc.nextLine());
		System.out.print("����Ͻ� ��ȭ�� ��ȭ������ �Է����ּ���.>");
		String movieDirector = sc.nextLine();
		System.out.print("����Ͻ� ��ȭ�� �⿬��츦 ��ǥ(,)�� �����Ͽ� �Է����ּ���.>");
		
		Movie movie = new Movie(movieNo, genreNo, movieTitle, releaseDate, runningTime, 0, movieDirector);
		MovieController.addMovie(movie);
	}
	
	public static void updateMovieMenu() {
		System.out.println("������ �󿵽ð�, ��ȭ����, ��ȭ���¸� �����մϴ�.");
		System.out.print("�����Ͻ� ��ȭ�� �ڵ带 �Է����ּ���.> ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("�����Ͻ� ��ȭ�� �󿵽ð��� �Է����ּ���.> ");
		int runningTime = Integer.parseInt(sc.nextLine());
		System.out.print("�����Ͻ� ��ȭ�� ��ȭ������ �Է����ּ���.> ");
		String movieDirector = sc.nextLine();
		int movieState=0;
		while(true) {
			System.out.print("�����Ͻ� ��ȭ�� ��ȭ���¸� �Է����ּ���.(1 = ���� / 0=������)> ");
			movieState =Integer.parseInt(sc.nextLine());
			if(movieState==1|| movieState==0) break;
			System.out.println("1 / 0 �� �Է����ּ���.");
		}
		Movie movie = new Movie(movieNo, 0, null, null, runningTime, movieState, movieDirector);
		MovieController.updateMovie(movie);
	}
}
