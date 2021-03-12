package cineroom.mvc.model.dto;

/**
 * ��ȭ�� �⿬�� ������ �����ϴ� Ŭ����
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
