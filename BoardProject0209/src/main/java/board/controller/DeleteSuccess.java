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
 * Servlet implementation class DeleteSuccess
 */
@WebServlet("/deleteSuccess")
public class DeleteSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 형변환 하고 
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Member currentUser = (Member)session.getAttribute("member");
		
		// 
		List<Board> list = null;
		
		BoardService bservice = new BoardService();
		list = bservice.getAllBoard();
		
		
		// 호출 할 때 loginSuccess
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("loginSuccess.jsp");
		// 보드 키 값읠 결과 값을 보내달라는 요청
		request.setAttribute("boardList", list);
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
