package cineroom.mvc.model.dto;

/**
 * ȸ���� ��ȣ�ϴ� �帣���� ��� Ŭ����
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
