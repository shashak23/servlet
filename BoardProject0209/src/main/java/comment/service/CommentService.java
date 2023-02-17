package comment.service;

import java.util.List;

import comment.dao.CommentDao;
import comment.vo.Comment;

public class CommentService {

	public int writeComment(Comment comment) {
		// 로직처리하기
	
		CommentDao dao = new CommentDao();
		int result = dao.insert(comment);
		
		return result;
	}

	public List<Comment> getAllComment(int boardNum) {
		CommentDao dao = new CommentDao();
		List<Comment> result = dao.selectAll(boardNum);
		
		return result;
	}



}
