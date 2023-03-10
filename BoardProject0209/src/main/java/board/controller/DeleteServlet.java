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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		// 삭제데이터 보내는 거 하고 
		// 여기다가 타이틀을 눌렀을 때 게시글 정보가 나오도록 데이터 입력하고 로직하기
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();
				Member currentUser = (Member)session.getAttribute("member");
			
				// 데이터를 얻고 서비스에 요청하는 
				String bNum = request.getParameter("bNum");
				
				BoardService service = new BoardService();
				int result = service.deleteBoard(bNum);
				
				if (result ==1) {
					//1일 때 리스트가 가져와지고 
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("deleteSuccess.jsp");
					request.setAttribute("board", result);
					
					dispatcher.forward(request, response);
					
				} else {
					//0이면 에러 페이지가 나오도록 
					request.getRequestDispatcher("deleteFail.html");
				}
				
		
	}

}
