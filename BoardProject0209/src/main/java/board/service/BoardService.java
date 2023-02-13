
package board.service;

import java.util.List;

import board.dao.BoardDao;

import board.vo.Board;

public class BoardService {

	public List<Board> getAllBoard() {
		  // 로직처리해야해요!
	      // 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면 되요!
	      // DAO가 있어야 해요!
	      BoardDao dao = new BoardDao();      
	      List<Board> list = dao.selectAll();
	      
	      return list;
	}

	public int writeBoard(Board board) {
		// 글을 작성완료한 후 
		BoardDao dao = new BoardDao(); 
		int result = dao.insert(board);
		// 데이터가 insert된 select list 가져오기 
//	    List<Board> list = dao.selectAll();
	    
		
		return result;
	}

}
