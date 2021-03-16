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
	 * 로그인 실패 -- session 처리를 어떻게 해야하는가
	 */

	public Member login(String memberId, String memberPassword) throws SQLException {
		Member member = memberDao.login(memberId, memberPassword);
		if (member == null) {
			throw new SQLException("해당하는 회원정보가 존재하지 않습니다.");
		}
		Session session = new Session(memberId);
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);

		return member;
	}

	/**
	 * 회원가입 실패 -- result에게 어떻게 해줘야하는가 *
	 */

	public int signUp(Member member) throws SQLException {
		int result = memberDao.signUp(member);
		return result;

	}
	
	/**
	 * 아이디 중복체크 - 중복  
	 * 
	 * */
	public boolean duplicateByMemberId(String memberId) throws SQLException {
    		boolean result = memberDao.duplicateByMemberId(memberId);
        	if(result == true) {
        		throw new SQLException("입력하신 아이디가 이미 존재합니다. 다시 입력해주세요.");
            }
        	return result; 
	}
	
	/**
	 * 회원정보 수정 실패 - 비밀번호 변경  
	 */
	public int memberUpdate(Member member) throws SQLException {
		int result = memberDao.memberUpdate(member);
		if (result == 0) {
			throw new SQLException("회원정보 수정에 실패했습니다.");
		}
		return result;

	}

	/**
	 * 회원정보 삭제 실패
	 */
	public int memberDelete(Member member) throws SQLException {
		int result = memberDao.memberDelete(member);
		if (result == 0) {
			throw new SQLException("회원정보 삭제에 실패했습니다. ");
		}
		return result;
	}
	

	
	/**
	 * 선호장르 변경
	 * */
	
	
}
