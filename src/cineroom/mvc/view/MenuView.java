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
		System.out.println( "***�� �ݰ����ϴ�!");
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
			
			if (true) {
				break;
			}
			System.out.println("�̹� ������� ID�Դϴ�.");
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

		Member member = new Member(memberId, memberPassword, memberName, memberBirth, 0);
		MemberController.signUp(member);
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
		System.out.println(memberId + "�� �ݰ����ϴ�!");
		//��ȭ��õ �޼���//
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
					//��ȭ�˻�
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
					System.out.println("���� ���� ���ڸ� �Է����ּ���.");
					break;
				}
			} catch (NumberFormatException e) {
				FailView.printMessage("���ڷ� �Է��� �ּ���.");
			}
		}
	}

	public static void printAdminMenu() {
		System.out.println("***********������ �޴��Դϴ�***********");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.�Խ��� ����  |  2.� ����  |  3.��ȭ ����  |  9.�α׾ƿ�  ��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}

	public static void printMovieSearchMenu() {
		loop1:
		while(true) {
			System.out.println("***********��ȭ�˻� �޴��Դϴ�***********");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ü��ȭ  |  2.�������� �˻�  |  3.�帣�� �˻�  |  4.�������� �˻���");
			System.out.println("��            5.���� �˻�  |  6.���� �˻�  |  9.�����޴�            ��");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������");
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
					System.out.println("�˻��Ͻ� ���� Ű���带 �Է����ּ���. > ");
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
					System.out.println("�������� ���ڸ� �Է����ּ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	
	public static void printSearchGenre() {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("�˻��Ͻ� �帣�� ��ȣ�� �Է����ּ���. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					continue;
				}
				MovieController.moviesSelectByGenre(genreNo);
				break;
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	
	public static int selectMovieNo() {
		System.out.print("�����Ͻ� ��ȭ�� ��ȣ�� �Է����ּ���. > ");
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}

	public static void printRateMenu() {
		System.out.println("***********��ȭ���� �޴��Դϴ�***********");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��  1.��������  |  2.�������  |  3.��������  |  9.�����޴�  ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}

	public static void printBoardMenu(String memberId) {
		loop1:
		while(true) {
			System.out.println("***********���� �Խ��� �޴��Դϴ�***********");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��  1.��ü �Խ���  |  2.�帣�� �Խ���  |  3.�� �ۼ�  |  9.�����޴�  ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println();
			try {
				System.out.print("�̿��Ͻ� �Խ����� ��ȣ�� �Է����ּ���. > ");
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
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					break;
				}
				
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
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
	public static void printSearchBoardByGenre() {
		while(true) {
			MenuView.printGenre();
			try {
				System.out.print("�˻��Ͻ� �帣�� ��ȣ�� �Է����ּ���. > ");
				int genreNo = Integer.parseInt(sc.nextLine());
				if(genreNo>18||genreNo<=0) {
					System.out.println("���� ���� ���ڷ� �Է����ּ���.");
					continue;
				}
				BoardController.boardSelectByGenre(genreNo);
				break;
			}catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��� �ּ���.");
			}
		}
	}
	
	public static void printInsertBoardMenu(String memberId) {
		//��ȭ�� ��� ��ȣ�� �����;��ϴ� issue
		System.out.print("���並 �ۼ��Ͻ� ��ȭ ������ �Է����ּ���. >");
		String keyWord = sc.nextLine();
		MovieController.moviesSelectByTitle(keyWord);
		
		System.out.print("��� �� ���並 �ۼ��Ͻ� ��ȭ�� �ڵ带 �Է����ּ���. > ");
		int movieNo = Integer.parseInt(sc.nextLine());
		System.out.print("�������� �Է����ּ���.> ");
		String title = sc.nextLine();
		System.out.print("�۳����� �Է����ּ���. > ");
		String content = sc.nextLine();
		Board b =new Board(0, memberId, movieNo, title, content, null);
		BoardController.boardInsert(b);
	}

	public static void printMyPageMenu() {
		
	}
	//������ ���� ���� ���Ŀ� ����
	public static void printBoardMangeMenu() {
		
	}

	public static void printOperationMangeMenu() {
		
	}

	public static void printMovieMangeMenu() {
		
	}
}
