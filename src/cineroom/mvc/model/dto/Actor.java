package cineroom.mvc.model.dto;

/**
 * 영화에 출연한 배우들을 저장하는 클래스
 * */
public class Actor {
	private int actorNo;
	private int movieNo;
	private String actorName;
	
	public Actor( ) {}
	public Actor(int actorNo, int movieNo, String actorName) {
		super();
		this.actorNo = actorNo;
		this.movieNo = movieNo;
		this.actorName = actorName;
	}
	public int getActorNo() {
		return actorNo;
	}
	public void setActorNo(int actorNo) {
		this.actorNo = actorNo;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
}
