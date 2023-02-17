package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyCommentMove
 */
@WebServlet("/commentmodifyMove")
public class ModifyCommentMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCommentMove() {
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
		// 
		request.setCharacterEncoding("UTF-8");
		//getparameter를 이용해서 지정했던 name을 꺼내온다
		String boardNum = request.getParameter("bNum");
		String commentContent = request.getParameter("bTitle");

		// 호출 할 때 loginSuccess
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("commentmodify.jsp");
		// 보드 키 값읠 결과 값을 보내달라는 요청
		request.setAttribute("bNum", boardNum);
		request.setAttribute("bTitle", commentContent);
		
		dispatcher.forward(request, response);
	}

}
