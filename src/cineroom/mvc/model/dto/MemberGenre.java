package cineroom.mvc.model.dto;

/**
 * 회원이 선호하는 장르들을 담는 클래스
 * */
public class MemberGenre {
	private int genreFavorNo;
	private int genreNo;
	private String memberId;
	
	public MemberGenre() {}
	public MemberGenre(int genreFavorNo, int genreNo, String memberId) {
		super();
		this.genreFavorNo = genreFavorNo;
		this.genreNo = genreNo;
		this.memberId = memberId;
	}
	public int getGenreFavorNo() {
		return genreFavorNo;
	}
	public void setGenreFavorNo(int genreFavorNo) {
		this.genreFavorNo = genreFavorNo;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
