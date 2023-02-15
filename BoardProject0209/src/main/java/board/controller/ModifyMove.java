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
 * Servlet implementation class ModifySuccess
 */
@WebServlet("/modifyJsp")
public class ModifyMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// deleteSuccess 했던 거 그대로 가져오기 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//getparameter를 이용해서 지정했던 name을 꺼내온다
		String boardNum = request.getParameter("bNum");
		String boardTitle = request.getParameter("bTitle");

		// 호출 할 때 loginSuccess
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("modify.jsp");
		// 보드 키 값읠 결과 값을 보내달라는 요청
		request.setAttribute("bNum", boardNum);
		request.setAttribute("bTitle", boardTitle);
		
		dispatcher.forward(request, response);
	}

}
