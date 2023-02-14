package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;

/**
 * Servlet implementation class BoardPublish
 */
@WebServlet("/boardpublish")
public class BoardPublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPublishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 읽고 등록하고 
		// 글쓰기 내용을 db에 전달하고 
		// 게시판 리스트 보여주고
		request.setCharacterEncoding("UTF-8");
//		int boardNum = Integer.parseInt(request.getParameter("boardN"));
		String boardTitle = request.getParameter("boardT");
		String boardContent = request.getParameter("boardC");
//		String boardAuthor = request.getParameter("boardA");
		String boardDate = request.getParameter("boardD");
		int boardLike = Integer.parseInt(request.getParameter("boardL"));
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
//		board.setBoardAuthor(boardAuthor);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
		board.setBoardLike(boardLike);
		
		// 2. 로직담당
		BoardService service = new BoardService();
		//보드의 결과를 서비스와 연동
		List<Board> list = null;
		List<Board> result = service.getAllBoard();
		
		if(result != null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}

	}

}
