package cineroom.mvc.model.dao;

import java.sql.SQLException;

import cineroom.mvc.model.dto.Member;

public interface MemberDAO {
	/**
	 * 로그인 기능 -> id와 pw를 입력한다.
	 * @return 로그인 된 member반환
	 * */
	public Member login(String memberId, String memberPassword) throws SQLException;
	
	/**
	 * 회원가입 기능 -> 회원가입에 필요한 정보들을 입력한다.
	 * @return boolean 로그인에 성공하면 true, 실패하면 false
	 * */
	public int signUp(Member member) throws SQLException;
	
	/**
	 * 회원정보 수정 기능
	 * */
	public int memberUpdate(Member member) throws SQLException;
	
	/**
	 * 회원정보 삭제 기능
	 * */
	public int memberDelete(Member member) throws SQLException;
}
