package cineroom.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dao.MemberDAO;
import cineroom.mvc.model.dao.MemberDAOImpl;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.session.Session;
import cineroom.mvc.session.SessionSet;
import cineroom.mvc.view.EndView;


public class MemberService {
	MemberDAO memberDao = new MemberDAOImpl();

	
	/**
	 * ��ü�˻�  
	 * */
	
	public List<Member> memberSelectAll() throws SQLException {
		List<Member> list =  memberDao.memberSelectAll();
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException("�˻��� ������ �����ϴ�.");
		}
		return list;
	}
	
	/**
	 * �α��� ���� -- session ó���� ��� �ؾ��ϴ°�
	 */

	public Member login(String memberId, String memberPassword) throws SQLException {
		Member member = memberDao.login(memberId, memberPassword);
		if (member == null) {
			throw new SQLException("�ش��ϴ� ȸ�������� �������� �ʽ��ϴ�.");
		}
		Session session = new Session(memberId);
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);

		return member;
	}

	/**
	 * ȸ������ ���� -- result���� ��� ������ϴ°� *
	 */

	public int signUp(Member member) throws SQLException {
		int result = memberDao.signUp(member);
		return result;

	}
	
	/**
	 * ���̵� �ߺ�üũ - �ߺ�  
	 * 
	 * */
	public boolean duplicateByMemberId(String memberId) throws SQLException {
    		boolean result = memberDao.duplicateByMemberId(memberId);
        	return result; 
	}
	
	/**
	 * ȸ������ ���� ���� - ��й�ȣ ����  
	 */
	public int memberUpdate(Member member) throws SQLException {
		int result = memberDao.memberUpdate(member);
		if (result == 0) {
			throw new SQLException("ȸ������ ������ �����߽��ϴ�.");
		}
		return result;

	}

	/**
	 * ȸ������ ���� ����
	 */
	public int memberDelete(String targetId) throws SQLException {
		int result = memberDao.memberDelete(targetId);
		if (result == 0) {
			throw new SQLException("�ش��ϴ� ������ ���� �������� �ʾҽ��ϴ�.");
		}
		return result;
	}
	
	public int setFav(String memberId, List<Integer> favorList) throws SQLException{
		int result = memberDao.setFav(memberId, favorList);
		if(result == 0) {
			throw new SQLException("�����帣�� ��ϵ��� �ʾҽ��ϴ�. �������������� �ٽ� �߰����ּ���!");
		}
		return result;
	}
	

	
	/**
	 * ��ȣ�帣 ����  // DAO�� �߰��ϱ� 
	 * */
	public int changeFavNo(String memberId, List<Integer> favorList) throws SQLException{
		int result = memberDao.changeFavNo(memberId, favorList);
		if (result == 0) {
			throw new SQLException("��ȣ�帣 ���濡 �����߽��ϴ�. ");
		}
		return result;
	}
	
}
