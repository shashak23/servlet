package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mysql.mybatisconnectionfacotry;
import vo.members;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		// 데이터 변환
		request.setCharacterEncoding("UTF-8");
		// 1. 입력
		String id = request.getParameter("userID");
		String password = request.getParameter("userPW");
		// 2. 로직
		members member = new members(); // vo연결
		member.setId(id);
		member.setPw(password);

		SqlSession session = 
				mybatisconnectionfacotry.getSqlSessionFactory().openSession();
		
		members result = session.selectOne("members.login"); 


		session.close();
		
		if(result != null) {
			// 로그인 성공, 세션 처리 
			// servlet container에게 session객체를 요청해요
			// 만약 기존에 내가 할당받은 세션이 있으면 그거 주시고요
			// 기존에 할당 받은 세션 객체가 없으면 만들어 주세요
			HttpSession session1 = request.getSession(true);
			// 이 세션 객체는 map형태에요
			session1.setAttribute("loginID", result.getName());
		}

		// 3. 결과
		response.setContentType("login/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<h1>로그인 성공했습니다!</h1>");
		
		out.println("<h2>로그인 실패했습니다!</h2>");

		out.println("<ul>");
//		
		if(result != null) { // id 로그인 성공
			out.println(result.getId() + "님 환영합니다!");
			out.println("<br><br>");
			out.println("게시판 들어가기!");
			// password만들기 
		}else {
			out.println("<h2>로그인 실패했습니다!</h2>");
			out.println("로그인에 실패했습니다");
		out.println("<a href='board'> 게시판 들어가기 </a>");
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}
	}

}
