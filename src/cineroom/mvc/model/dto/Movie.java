package cineroom.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

/* *
 * ��ȭ�� ������ �����ϴ� Ŭ����
 * ��ȭ�� ���� ������ ������ ����Ʈ�� ������ �� �ִ�.
 * */
public class Movie {
	private int movieNo;
	private int genreNO;
	private String movieTitle;
	private String releaseDate;
	private int runningTime;
	private int movieState;
	private String movieDirector;
	private String genreName;
	
	private List<Rate> rateList = new ArrayList<Rate>();
	private List<Actor> actorList = new ArrayList<Actor>();
	
	public Movie() {}
	
	public Movie(int movieNo, int genreNO, String movieTitle, String releaseDate, int runningTime, int movieState,
			String movieDirector) {
		super();
		this.movieNo = movieNo;
		this.genreNO = genreNO;
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.movieState = movieState;
		this.movieDirector = movieDirector;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public int getGenreNO() {
		return genreNO;
	}

	public void setGenreNO(int genreNO) {
		this.genreNO = genreNO;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public int getMovieState() {
		return movieState;
	}

	public void setMovieState(int movieState) {
		this.movieState = movieState;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public List<Rate> getRateList() {
		return rateList;
	}

	public void setRateList(List<Rate> rateList) {
		this.rateList = rateList;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
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
		builder.append("[��ȭ����=");
		builder.append(movieTitle);
		builder.append(", �帣=");
		builder.append(genreName);
		builder.append(", ������=");
		builder.append(releaseDate);
		builder.append(", �󿵽ð�=");
		builder.append(runningTime);
		builder.append(", ��ȭ����=");
		builder.append(movieDirector);
		builder.append("]");
		return builder.toString();
	}
}
