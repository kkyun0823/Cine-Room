package cineroom.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원 정보를 저장하는 클래스
 * 선호하는 장르를 List에 담을 수 있다.
 * */
public class Member {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberBirth;
	private int memberState;
	
	private List<Genre> genreList = new ArrayList<Genre>();
	
	public Member() {}
	
	public Member(String memberId, String memberPassword, String memberName, String memberBirth, int memberState) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberState = memberState;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public int getMemberState() {
		return memberState;
	}

	public void setMemberState(int memberState) {
		this.memberState = memberState;
	}

	public List<Genre> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<Genre> genreList) {
		this.genreList = genreList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ 회원 ID=");
		builder.append(memberId);
		builder.append(", |  회원 이름=");
		builder.append(memberName);
		builder.append(", |  회원 생년월일=");
		builder.append(memberBirth.substring(0, 10));
		builder.append("]");
		return builder.toString();
	}
	
}
