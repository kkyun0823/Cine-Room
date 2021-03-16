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
	 * 로그인
	 */
	public static void login(String memberId, String memberPassword) {
		try {
			Member member = memberService.login(memberId, memberPassword);
			if (member.getMemberState() == 1) {
				MenuView.printUserMenu(memberId);
			} else if (member.getMemberState() == 2) {
				MenuView.printAdminMenu();
			} else {
				FailView.printMessage("삭제된 계정입니다.");
			}
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 아이디 중복체크 - 중복 아닐 때
	 */
	public boolean duplicateByMemberId(String memberId) {
		try {
			boolean result = memberService.duplicateByMemberId(memberId);
			if (result == false) {
				EndView.printMessage("사용 가능한 아이디입니다. ");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true; 
	}

	/**
	 * 회원가입
	 */
	public static void signUp(Member member) {
		try {
			int result = memberService.signUp(member);
			if (result != 1)
				throw new SQLException("회원가입에 실패했습니다.");
			System.out.println("회원가입 완료되었습니다!\n");
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 회원정보 수정 -비밀번호 변경
	 */
//	public int memberUpdate(Member member) {
//
//		try {
//			int result = memberService.memberUpdate(member); 
//			TestRateView.printMessage("회원정보 수정을 완료하였습니다."); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * 선호장르 수정
	 */
	public int changeFavNo (Member member) {
		 try {
				int result = memberService.changeFavNo(member);
				//MenuView.printMessage("선호장르 수정을 완료하였습니다.");
			} catch (Exception e) {
				FailView.printMessage(e.getMessage());
			}
		}


/**
 * 회원정보 삭제
 */
//	public int memberDelete(Member member) {
//
//		try {
//			int result = memberService.memberDelete(member);
//			TestRateView.printMessage("회원정보가 삭제되었습니다.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
