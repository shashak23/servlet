package comment.vo;

public class Comment {
	private int commentNum;
	private String commentContent;
	private String commentAuthor;
	private int commentDate;
	private int boardNum;
	
	public Comment () {
		
	}

	public Comment(int commentNum, String commentContent, String commentAuthor, int commentDate, int boardNum) {
		super();
		this.commentNum = commentNum;
		this.commentContent = commentContent;
		this.commentAuthor = commentAuthor;
		this.commentDate = commentDate;
		this.boardNum = boardNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public int getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(int commentDate) {
		this.commentDate = commentDate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	

}
