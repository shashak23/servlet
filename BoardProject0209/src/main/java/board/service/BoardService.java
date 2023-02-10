
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

}
