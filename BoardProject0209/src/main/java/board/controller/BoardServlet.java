package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
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
		// 변환하기
		request.setCharacterEncoding("UTF-8");
		// 어디까지 들어가야하지? 게시글이니까 게시글에 들어가는 모든 내용이 보여야겠지
		// 1. 입력하기
		int boardNum = Integer.parseInt(request.getParameter("boardN"));
		String boardTitle = request.getParameter("boardT");
		String boardContent = request.getParameter("boardC");
		String boardAuthor = request.getParameter("boardA");
		String boardDate = request.getParameter("boardD");
		int boardLike = Integer.parseInt(request.getParameter("boardL"));
		
		// 테이블 만들기
		Board board = new Board();
		board.setBoardNum(boardNum);
		board.setBoardTitle(boardTitle);
		board.setBoardAuthor(boardAuthor);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
		board.setBoardLike(boardLike);
		
		// 2. 로직하기
		BoardService service = new BoardService();
		
		// 3. 출력하기 - > jsp
		
	}

}
