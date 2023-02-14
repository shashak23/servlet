package board.controller;

import java.io.IOException;

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
 * Servlet implementation class BoardResult
 */
@WebServlet("/boardresult")
public class BoardResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 여기다가 타이틀을 눌렀을 때 게시글 정보가 나오도록 데이터 입력하고 로직하기
		request.setCharacterEncoding("UTF-8");
		
		// 형변환으로 접속한 id의 30분유지를 통한 자동저장!
		HttpSession session = request.getSession();
		Member currentUser = (Member)session.getAttribute("member");
		
		String bNum = request.getParameter("bNum");
		
		// 데이터를 얻고 서비스에 요청하는 
		BoardService service = new BoardService();
		Board board = service.getBoardByNum(bNum);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("writeResult.jsp");
		
		request.setAttribute("board", board);
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
