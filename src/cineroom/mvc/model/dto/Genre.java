package cineroom.mvc.model.dto;


/**
 * 장르에 대한 정보들을 저장하는 클래스
 * */
public class Genre {
	private int genreNo;
	private String genreName;
	
	public Genre() {}
	public Genre(int genreNo, String genreName) {
		super();
		this.genreNo = genreNo;
		this.genreName = genreName;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Genre [genreNo=");
		builder.append(genreNo);
		builder.append(", genreName=");
		builder.append(genreName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
