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
	 * 전체검색  
	 * */
	
	public List<Member> memberSelectAll() throws SQLException {
		List<Member> list =  memberDao.memberSelectAll();
		if(list==null || list.size()==0 || list.isEmpty()) {
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return list;
	}
	
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
	public int memberDelete(String targetId) throws SQLException {
		int result = memberDao.memberDelete(targetId);
		if (result == 0) {
			throw new SQLException("해당하는 정보가 없어 삭제되지 않았습니다.");
		}
		return result;
	}
	
	public int setFav(String memberId, List<Integer> favorList) throws SQLException{
		int result = memberDao.setFav(memberId, favorList);
		if(result == 0) {
			throw new SQLException("관심장르가 등록되지 않았습니다. 마이페이지에서 다시 추가해주세요!");
		}
		return result;
	}
	

	
	/**
	 * 선호장르 변경  // DAO에 추가하기 
	 * */
	public int changeFavNo(String memberId, List<Integer> favorList) throws SQLException{
		int result = memberDao.changeFavNo(memberId, favorList);
		if (result == 0) {
			throw new SQLException("선호장르 변경에 실패했습니다. ");
		}
		return result;
	}
	
}
