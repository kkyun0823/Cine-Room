package cineroom.mvc.model.dto;

/**
 * 모든 댓글을 저장하는 클래스
 * */
public class Comments {
	private int commentsNo;
	private int boardNo;
	private String memberId;
	private String commentsContent;
	private String commentsDate;
	public Comments(){}
	public Comments(int commentsNo, int boardNo, String memberId, String commentsContent, String commentsDate) {
		super();
		this.commentsNo = commentsNo;
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.commentsContent = commentsContent;
		this.commentsDate = commentsDate;
	}
	public int getCommentsNo() {
		return commentsNo;
	}
	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	public String getCommentsDate() {
		return commentsDate;
	}
	public void setCommentsDate(String commentsDate) {
		this.commentsDate = commentsDate;
	}
	
}
