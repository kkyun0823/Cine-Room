package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.model.service.MemberService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;
import cineroom.mvc.view.MenuView;
import cineroom.mvc.view.TestView;

public class MemberController {
	private static MemberService memberService = new MemberService();

	/**
	 * �α���
	 */
	public static void login(String memberId, String memberPassword) {
		try {
			Member member = memberService.login(memberId, memberPassword);
			if (member.getMemberState() == 1) {
				MenuView.printUserMenu(memberId);
			} else if (member.getMemberState() == 2) {
				MenuView.printAdminMenu();
			} else {
				FailView.printMessage("������ �����Դϴ�.");
			}
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * ���̵� �ߺ�üũ - �ߺ� �ƴ� ��
	 */
	public boolean duplicateByMemberId(String memberId) {
		try {
			boolean result = memberService.duplicateByMemberId(memberId);
			if (result == false) {
				EndView.printMessage("��� ������ ���̵��Դϴ�. ");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true; 
	}

	/**
	 * ȸ������
	 */
	public static void signUp(Member member) {
		try {
			int result = memberService.signUp(member);
			if (result != 1)
				throw new SQLException("ȸ�����Կ� �����߽��ϴ�.");
			System.out.println("ȸ������ �Ϸ�Ǿ����ϴ�!\n");
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * ȸ������ ���� -��й�ȣ ����
	 */
//	public int memberUpdate(Member member) {
//
//		try {
//			int result = memberService.memberUpdate(member); 
//			TestRateView.printMessage("ȸ������ ������ �Ϸ��Ͽ����ϴ�."); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * ��ȣ�帣 ����
	 */
	public int changeFavNo (Member member) {
		 try {
				int result = memberService.changeFavNo(member);
				//MenuView.printMessage("��ȣ�帣 ������ �Ϸ��Ͽ����ϴ�.");
			} catch (Exception e) {
				FailView.printMessage(e.getMessage());
			}
		}


/**
 * ȸ������ ����
 */
//	public int memberDelete(Member member) {
//
//		try {
//			int result = memberService.memberDelete(member);
//			TestRateView.printMessage("ȸ�������� �����Ǿ����ϴ�.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
