package cineroom.mvc.model.dao;

import java.sql.SQLException;

import cineroom.mvc.model.dto.Member;

public interface MemberDAO {
	/**
	 * �α��� ��� -> id�� pw�� �Է��Ѵ�.
	 * @return �α��� �� member��ȯ
	 * */
	public Member login(String memberId, String memberPassword) throws SQLException;
	
	/**
	 * ȸ������ ��� -> ȸ�����Կ� �ʿ��� �������� �Է��Ѵ�.
	 * @return boolean �α��ο� �����ϸ� true, �����ϸ� false
	 * */
	public int signUp(Member member) throws SQLException;
	
	/**
	 * ȸ������ ���� ���
	 * */
	public int memberUpdate(Member member) throws SQLException;
	
	/**
	 * ȸ������ ���� ���
	 * */
	public int memberDelete(Member member) throws SQLException;
}
