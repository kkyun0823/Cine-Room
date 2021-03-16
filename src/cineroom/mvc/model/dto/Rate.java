package cineroom.mvc.model.dto;

/**
 * ��ȭ�� ������ �����ϴ� Ŭ����
 * */
public class Rate {
	private int rateNo;
	private String memberId;
	private int movieNo;
	private int rate;
	
	private String movieName;
	
	public Rate() {}
	public Rate(int rateNo, String memberId, int movieNo, int rate) {
		super();
		this.rateNo = rateNo;
		this.memberId = memberId;
		this.movieNo = movieNo;
		this.rate = rate;
	}
	public int getRateNo() {
		return rateNo;
	}
	public void setRateNo(int rateNo) {
		this.rateNo = rateNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[�ڵ�=");
		builder.append(rateNo);
		builder.append(", ��ȭ�̸�=");
		builder.append(movieName);
		builder.append(", ����=");
		builder.append(rate);
		builder.append("]");
		return builder.toString();
	}
	
}
