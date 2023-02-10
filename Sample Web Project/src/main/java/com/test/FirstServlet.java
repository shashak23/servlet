package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/myservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// init()의 목적은 servlet instance를 초기화 하는데에 있어요!
    	System.out.println("init가 호출되었어요!");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// 이걸 호출해주는 것은 THREAD, 그래서 ()안데 thread 서비스 인자가 나옴.
    	super.service(req, resp);
    } 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 get방식으로 servlet을 호출하면 시 method가 호출되요
		// 결과적으로 보았을 떄 doget() method가 호출됩니다
		// 클라이언트 호출ㅋ> http://127.0.0.1:8080/sample/myservlet
		// 이 클래스 안에 잇는 doGet()이 호출되요
		// 여기에 코드를 작성하면 돼요 
		
		// 클랄이ㅌ그ㅏ 호출했을 떄 해야하는 일을 여기에 작성하면 되요
		// 프로그램 처리방식대로 작성해 봊
		// 1. 입력을 받는다. : 지금은 입력처리할 게 없어요
		// 2. 로직처리한다. : 처음이라서 없쥬
		// 3. 출력처리한다. : 간단하게 해 봐요~
		// 3번을 하기 위한 과정)) 
		// 3-1. 내가 클라이언트에게 전달할 데이터가 어떤 데이터인지 설정부터 해야 해요!
		response.setContentType("text/html; charset=UTF-8");
		// -> 얘는 클라이언트가 어떤 설정을 할건지 정하는 애...
		// 정해져 있어요! text/html 이 문서로 정해져잇다는 거에요~?! img/jpeg 이런것 처럼
		// 3-2. 클라이언트에게 데이터를 전달하기 우해 stream을 열어요 
		PrintWriter out = response.getWriter(); // 이 코드를 다 외워야 해요!
		// 3-3. 통로가 열였으니 이제 통로를 통해서 데이터를 전달해요
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>이건 서블릿의 결과에요...김베리는 고양이베리</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
