package cineroom.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시판의 글들을 저장하는 클래스
 * 댓글의 경우 리스트에 담아서 사용할 수 있다.
 * */
public class Board {
	private int boardNo;
	private String memberId;
	private int movieNo;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private List<Comments> commentsList = new ArrayList<Comments>();
	
	public Board(int boardNo, String memberId, int movieNo, String boardTitle, String boardContent, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.movieNo = movieNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
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

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}
	
}
