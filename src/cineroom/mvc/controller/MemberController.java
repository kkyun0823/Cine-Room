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
	  * �α���
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
		 * ȸ������  
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
		 * ȸ������ ����  
		 * */
		public int memberUpdate(Member member) {
			
			try {
				int result = memberService.memberUpdate(member);	//���񽺸� ����ϰ� 
				TestRateView.printMessage("ȸ������ ������ �Ϸ��Ͽ����ϴ�.");	// ���ο� ��� ���� 
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * ȸ������ ���� 
		 * */
		public int memberDelete(Member member) {
			
			try {
				int result = memberService.memberDelete(member);
				TestRateView.printMessage("ȸ�������� �����Ǿ����ϴ�.");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
}
