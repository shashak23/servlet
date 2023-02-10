package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardServelt
 */
@WebServlet("/boardServelt")
public class BoardServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// link라서 get방식이에요!!, 로그인에 성공한 사람만 들어올 수 있어요
		// 기존에 클라이언트에게 할당된 세션 객체가 있으면 그거 주세요 
		//만약 없으면 만들지 말고 null을 하세요 
		HttpSession session = request.getSession(false);
		
		// 1. 입력
		
		// 2. 로직
		
		// 3. 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<h1>로그인 성공했습니다!</h1>");
		out.println("<ul>");
		if(session != null) {
			String name = (String)session.getAttribute("mname");
			out.println("<h1>" + name + "게시판에 오신 것을 환영합니다</h1>");
		} else {
			out.println("<h2>로그인에 성공해야 이용가능합니다</h2>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
		
		// 문제1) 허용되지 않은 사람이 치고 들어올 수 있따
		// 문제2) 로그인해서 게시판에 들어온 사람이 000님 게시판에 오신 걸 환영합니다 인식하도록 해야함
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
