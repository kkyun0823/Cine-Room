package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.service.MemberService;
import cineroom.mvc.session.Session;
import cineroom.mvc.session.SessionSet;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;
import cineroom.mvc.view.MenuView;

public class MemberController {
	private static MemberService memberService = new MemberService();

	/**
	 * 회원정보 전체 검색
	 */

	public static void memberSelectAll() {
		try {
			List<Member> list = memberService.memberSelectAll();
			EndView.printMemberList(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 로그인
	 */
	public static void login(String memberId, String memberPassword) {
		try {
			Member member = memberService.login(memberId, memberPassword);
			if (member.getMemberState() == 1) {
				System.out.println(memberId + "님 반갑습니다.!");
				Session session = new Session(memberId);
				SessionSet sessionSet = SessionSet.getInstance();
				sessionSet.add(session);
				MenuView.printUserMenu(memberId);
			} else if (member.getMemberState() == 2) {
				MenuView.printAdminMenu(memberId);
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
	public static boolean duplicateByMemberId(String memberId) {
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
	public static void memberUpdate(Member member) {
		try {
			memberService.memberUpdate(member);
			EndView.printMessage("비밀번호가 수정되었습니다.");
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 선호장르 수정
	 */
	public static void changeFavNo(String memberId, List<Integer> favorList) {
		try {
			int result = memberService.changeFavNo(memberId, favorList);
			EndView.printMessage(result + "개의 선호장르로 변경되었습니다.");
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}
	}

	public static void setFav(String memberId, List<Integer> favorList) {
		try {
			int result = memberService.setFav(memberId, favorList);
			EndView.printMessage(result + "개의 관심장르가 등록되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 회원정보 삭제
	 */
	public static void memberDelete(String targetId) {

		try {
			memberService.memberDelete(targetId);
			EndView.printMessage("선택하신 '"+targetId+"'회원이 삭제되었습니다.");
		} catch (Exception e) {
			FailView.printMessage(e.getMessage());
		}

	}

}
