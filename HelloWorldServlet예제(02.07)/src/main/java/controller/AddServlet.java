package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/sum")  // 우리 서블릿은 sum이라는 서블릿이에요
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 서블릿을 호출하려면 http://127.0.0.1:8080/first/sum?num1=10&num2=20
		// 쿼리스트링으로 넘기라는 조건이 있었는데, 뒤에 ?변수 이름 = 변수 값 
		// 1. 입력처리
		// : 쿼리 스트링으로부터 데이터를 받으려면
		// 첫번째로, 기억해야할 것은 무조건 다 문자열인데
		
		// http://127.0.0.1:8080/first/sum  이렇게 해서 form으로부터 데이터를 받았어요 
		// 여기서부터는 html과 연동해서 봐야해요 
		String num1 = request.getParameter("myNum1"); // parameter의 변수를 줌, 이걸 내가 받아보겠어 ! 그럼 10이 들어가요
		String num2 = request.getParameter("myNum2"); // 그럼 20이 들어가요
		
		// 2. 로직처리 
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);  // 문자열을 숫자(정수)로 변환
				
		// 3. 출력처리 - 스트림 열어서 연결하고 닫기까지
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>" + sum + "</body></html>");
		out.close(); // 반드시 스트림을 닫아줘야해요 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이번에는 코드를 이 곳에 작성해야하는데 이게 그... post 하는 방법!! 
//		doGet(request, response);
			// request에 모든 데이터가 있으니까 우리가 원하는 데이터를 num1이라는 
		    // 자바가 계산할 수 있는 것으로 넣어 주는 거에요
		String num1 = request.getParameter("myNum1"); // parameter의 변수를 줌, 이걸 내가 받아보겠어 ! 그럼 10이 들어가요
		String num2 = request.getParameter("myNum2");
		
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);  // 문자열을 숫자(정수)로 변환
		
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>" + sum + "</body></html>");
		out.close();
		//http://127.0.0.1:8080/first/add.html 이걸로 브라우저에서 확인할 수 있어요 

	}

}
