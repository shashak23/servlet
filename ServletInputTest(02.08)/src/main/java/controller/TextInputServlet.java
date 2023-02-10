package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TextInputServlet
 */
@WebServlet("/InputText")
public class TextInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //field를 만들 수 있어요
		int count = 0; // 이 필드는 client thread에 의해서 공유되요
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//count += 1;		// 공유여부 확인용
		
		// 1. 입력받기 
		String data = request.getParameter("userID");
		// 2. 로직처리
		// 3. 출력처리
		//	content type 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("<br><br>");
		out.println("이건 get방식이에요");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청을 처리하면 되요! 여기서 카운트 += 1; 이런거 하지 말아야 해요~ 
		// 이렇게 하면 서블릿 장식이 바뀌어요 / 장)편하게 여러 데이터를 공유 / 단)싱글톤으로 도는 게 정확한게 아니에요
		request.setCharacterEncoding("UTF-8");
//		count += 1;		// 공유여부 확인용
		
		// 1. 입력받기 
		String data = request.getParameter("userID");
		// 2. 로직처리
		// 3. 출력처리
		//	content type 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("</body></html>");
		out.close();
 }

}
