package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.vo.Member;

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
		
		HttpSession session = request.getSession();
		Member currentUser = (Member)session.getAttribute("member");
		
		
		// 1. 입력하기
		String boardTitle = request.getParameter("boardT");
		String boardContent = request.getParameter("boardC");
//		String boardAuthor = request.getParameter("boardA");
		String boardAuthor = currentUser.getMemberId();
		String boardDate = request.getParameter("boardD");

		// 테이블 만들기
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardAuthor(boardAuthor);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
//		board.setBoardLike(boardLike);
		
		// 2. 로직하기
		BoardService service = new BoardService();
		// 보드의 결과를 서비스와 연동
		int result = service.writeBoard(board);
		
		List<Board> list = null;
		if( result == 1) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}
		
		// 작성자가 세션에 저장되어 있는 걸로 하면 비교해서 되지 않을가?
		// 세션에 저장하는 거는 로그인 직후, 아이디를 저장해놓고 종료할때까지 가져가는 걸로
		// 로그아웃하면 ㅇ날리는 걸로 
		
		// id가 존재하는 사람이면 정상 처리되어 게시글 완료 
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("loginSuccess.jsp");
		request.setAttribute("boardList", list);
		dispatcher.forward(request, response);
		

	}
	}
