
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

		return result;  
	}

//	public Board selectOne(Board board) {
//		// 타이틀을 누렀을 때 db에서 연결된 정보들이 하나씩 나오기!
//		BoardDao dao = new BoardDao();
//		Board result = dao.selectOne(board);
//		
//		return result;
//	}

	public Board getBoardByNum(String bNum) {
		// 로직처리를 하게 해 
		BoardDao dao = new BoardDao();
		Board board = dao.selectOne(bNum);
		
		return board;
	}

	public int deleteBoard(Board board) {
		// 로직
		BoardDao dao = new BoardDao();
		int result = dao.delete(board);
				
		return result;
	}

	


}
