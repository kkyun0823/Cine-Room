package cineroom.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

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
	 *���̵� �ߺ�Ȯ�� 
	 * */
	public boolean duplicateByMemberId(String memberID) throws SQLException;	
	
	/**
	 * ȸ������ ���� ��� (��й�ȣ)
	 * */
	public int memberUpdate(Member member) throws SQLException;
	
	/**
	 * ȸ������ ���� ���
	 * */
	public int memberDelete(Member member) throws SQLException;
	
	/**
	 * ��ȣ�帣 ����  
	 * */
	public int changeFavNo (String memberId, List<Integer> favorList)throws SQLException;
	
	/**
	 * ��ȣ�帣 �Է�
	 * */
	public int setFav(String memberId, List<Integer> favorList)throws SQLException;
	
}
