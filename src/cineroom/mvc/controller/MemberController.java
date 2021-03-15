package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Board;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.service.BoardService;
import cineroom.mvc.model.service.MemberService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.MenuView;
import cineroom.mvc.view.TestView;



	public class MemberController {
		private static MemberService memberService = new MemberService();
		
	 /**
	  * 로그인
	  * */
		public static void login(String memberId, String memberPassword) {
			
			try {
				Member member = memberService.login(memberId, memberPassword);
				TestMemberView.printUserMenu();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 회원가입  
		 * */
		public int signUp(Member member) {
			
			try {
				int result = memberService.signUp(member);
				TestRateView.printUserMenu();   
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 회원정보 수정  
		 * */
		public int memberUpdate(Member member) {
			
			try {
				int result = memberService.memberUpdate(member);	//서비스를 출력하고 
				TestRateView.printMessage("회원정보 수정을 완료하였습니다.");	// 새로운 뷰로 가자 
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * 회원정보 삭제 
		 * */
		public int memberDelete(Member member) {
			
			try {
				int result = memberService.memberDelete(member);
				TestRateView.printMessage("회원정보가 삭제되었습니다.");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
}
