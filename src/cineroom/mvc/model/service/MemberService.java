package cineroom.mvc.model.service;

import java.sql.SQLException;

import cineroom.mvc.model.dao.MemberDAO;
import cineroom.mvc.model.dao.MemberDAOImpl;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.session.Session;
import cineroom.mvc.session.SessionSet;
import cineroom.mvc.view.EndView;

public class MemberService {
	MemberDAO memberDao = new MemberDAOImpl();

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
        	if(result == true) {
        		throw new SQLException("�Է��Ͻ� ���̵� �̹� �����մϴ�. �ٽ� �Է����ּ���.");
            }
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
	public int memberDelete(Member member) throws SQLException {
		int result = memberDao.memberDelete(member);
		if (result == 0) {
			throw new SQLException("ȸ������ ������ �����߽��ϴ�. ");
		}
		return result;
	}
	

	
	/**
	 * ��ȣ�帣 ����
	 * */
	
	
}
