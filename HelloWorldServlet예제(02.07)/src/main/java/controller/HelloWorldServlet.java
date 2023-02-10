package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/SayHello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
					HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 호출하면 돌고 돌아서 이 메소드가 스레드에 의해서 
		// 호출되요... 여기에서 모든 처리를 진행하면 되요
		// 1. 클라이언트가 보내준 데이터를 받아요 -> 인자로 들어온 request 객체를 이용해서 d를 받고
		// 2. 로직처리를 해요 ( db처리를 포함해서 )
		// 3. 출력처리를 해요 -> response를 이용해서 출력함
		// 여기에서 이 작업을 다 하는 건 아니고 쪼개서 해요
		// 모델 뷰, mvc 처럼 촤악~! 사람들이 흔히 말하는 mvc가 바로 이것 ! 
		
		// 출력 먼저 해보기
		// 1. 데이터가 가기전에 내가 너에게 주는 데이터가 어떤 건지 먼저 알려줘야해요
		response.setContentType("text/html; charset=UTF-8"); 
		// 여기서 내가 주는 것이 이미지인지, 동영상인지, 어떤 종류인지 아려주기
		// minetype으로 어떤 종류인지 문자열형태로 설정해저요 -> text 형식의 html 파일이에요
		// 마인타입이 틀리면 긁적긁적하면서 저런 데이터를 찾지 못해요. -> 그럼 결과적으로 무조건 다운로드가 돼요!!!
		// 다운로드 창이 트면 마인타입이 잘못된겁니다.
		
		// 2. 어떤 건지 명시를 해줬으니까 실제 데이터를 보내주면 되요.
		// 네트웤을 통해서 전송해야 하기 때문에 stream을 열어서 데이터 전송!
		// 스트림은 어떻게 여나요? -> 
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>까꿍!</body></html>");
		out.close(); // 반드시 스트림을 닫아줘야해요 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
