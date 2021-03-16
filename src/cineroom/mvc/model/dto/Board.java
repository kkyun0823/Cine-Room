package cineroom.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * �Խ����� �۵��� �����ϴ� Ŭ���� ����� ��� ����Ʈ�� ��Ƽ� ����� �� �ִ�.
 */
public class Board {
	private int boardNo;
	private String memberId;
	private int movieNo;
	private String movieTitle;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	List<Comments> commentsList = new ArrayList<Comments>();

	public Board(int boardNo, String memberId, String movieTitle, String boardTitle, String boardContent,
			String boardDate, List<Comments> commentsList) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.movieTitle = movieTitle;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.commentsList = commentsList;
	}

	public Board(int boardNo, String memberId, int movieNo, String boardTitle, String boardContent, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.movieNo = movieNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}
	
	public Board(int boardNo, String memberId,  String movieTitle, String boardTitle, String boardContent, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.movieTitle = movieTitle;
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
	
	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" | �ۼ��� ID : ");
		builder.append(memberId);
		builder.append(" | ��ȭ���� : ");
		builder.append(movieTitle);
		builder.append(" | ������ : ");
		builder.append(boardTitle);
		builder.append(" | ����� : ");
		builder.append(boardDate);
		builder.append(" | ��ۼ� : ");
		builder.append(commentsList.size());
		builder.append(" |");
		return builder.toString();
	}

}
