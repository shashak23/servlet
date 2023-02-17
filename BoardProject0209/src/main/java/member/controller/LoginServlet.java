package member.controller;

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
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// Servlet은 MVC(Model-View-Controller) pattern에서 Controller의 역할을 해요!
		// Model : 1. Data Model => VO class가 이 역할을 담당
		//         2. Business Logic Model => Service class가 이 역할을 담당
		//            -데이터베이스 처리가 들어올 수 있어요! 이 데이터베이스 처리는 DAO가 담당해요!
		// View : HTML, JSP
		// Controller : View와 Model을 연결해주는 역할을 담당 => Servlet
		//              View로부터 사용자데이터를 받아서 Model(Service)에게 전달해서
		//              로직처리시키고 로직처리된 결과를 Model(Service)로부터 받아와요!
		//              그 결과를 보고 특정View를 선택(HTML,JSP)해서 그 View를 클라이언트에게
		//              전달하도록 시켜요~!
		
		// 1. 입력담당 - servlet
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
//		String remember = request.getParameter("remember"); // 리멤버라는 파일 저장
		
		// 입력받은 데이터로 VO를 생성해요!
		// 데이터베이스 테이블을 기준으로 VO을 생성해야 하니..당연히 Table이 있어야 해요!
		// Table을 생성한 후 VO를 만들고 데이터를 세팅해서 Service에게 넘겨줄 준비를 했어요!
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw); //이렇게 하면 일단 컨트롤러가 하는 일은 일시적으로 끝나고, 데이터를 받고 끝남 챡!
		
		// 2. 로직담당 - 
		// 로직처리를 하기위해 Service객체를 생성해야 해요!
		MemberService service = new MemberService();
		// 인스턴스 = 메소드 
		// 클라이언트가 요청할 떄마다 이게 실행되는데, 100명이면 100개가 만들어지겠쬬?
	    // 그럼 서버가 많이 힘들어요? 이렇게 되겠쬬? -> 이런 식의 코드는 좋지 않지만 의미론적으로 우리끼리 하는 거니까 해봐요!
	    // 객체가 생성되었으면 이제 일을 시켜요
		//  boolean result = service.login(member);  //불리언을 쓴다면 login이 트루, 폴스
		// 만약 로그인이 성공하면 VO안에 회원의 이름까지 포함해서 들고와요.
		// 만약 로그인이 실패하면 null을 리턴받을꺼예요!
		
		Member result = service.login(member);
		
		List<Board> list = null; //vo가 있어야기 테이블을 댕겨서 데이터를 담아서 리스트를 쓰겠쬬?
	      // 위에처럼 미리 선언하는 거에요
		

		if(result != null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}
		
		// 3. 출력처리해요!
		if(result != null) {
			// 로그인에 성공했어요!
			// 로그인에 성공한 흔적을 남겨놔야 해요! => session에 남겨놓으면 좋아요!
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result);
	    	// 로그인에 성공했으니까 게시판 HTML페이지를 클라이언트에게 전송해요!(jsp) 
			// 로그인에 성공했으면 세션을 발급하고 
			// JSP는 그 실체가 Servlet이예요!
			// html -> servlet -> service - > dao -> 
			// service -> controller -> jsp(servlet) -> client
	    	// jsp라고 불리는 다른 servlet에 처리해달라고 전달하는 거에요

			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("loginSuccess.jsp");
			 // 디스패텨는 지정하는 것, 연결 성공하면 나오는 화면은 ""이거에요
	    	  // 만약 내가 로그인화면에서 다른 것을 더 보고 싶다? 그러면 더 해야하는데 그건 금요일에!
	    	  
	    	  // session를 jsp로 보내서 꺼내서 보는 걸로 0209에 설정했는데
	    	  // list라는 결과를 얻어왔을 떄 똑같이 sessionc에 넣는게 가능한가? -> 결론: 저장이 안되는 건 아니지만 세션의 크기가 데이터가 커져요!
	    	  // 이 사람이 뭔가를 할 때마다 세션이 정보를 갖다줄 수 있도록 하는 건데 
	    	  // 여기서 list는 계속 유지가 되지 않고 일회성 데이터를 넣는 거는 괜히 세션의 공간만 차지하는 행휘라서 문제가 생김
	    	  
	    	  // reuqest는 클라이언트가 나한테 보내느 정보를 객체화한 것인데
	    	  // 이 안에도 저장공간이 있는데 serattribute라는 공간이 있다~!
			request.setAttribute("boardList", list);
			 // jsp로 리스트를 보내지? 그럼 리퀘스으세 있는 이 공간에 리스트가 딸려가겠찌?
	    	  //실행이 끝나면 리퀘스트 객체와 리스폰스 객체가 같이 사라지지? 이런 동작이 일회성에게는 성질이 맞아부러?맞나?
	    	  
	    	  // 세션이 붙여서 전달하는 것! 리붸스트 객체에 붙여서 하는 것! 이렇게 구분됩니다?! 
	    	  
	    	  // 디스페처에게 ()을 밀어주는 것 -> 인식하고 -> 동작하기 
	    	  // 이런 데이터 전달방식을 통해 웹 데이터 시스템을 구축할 수 있어요 ! 
			dispatcher.forward(request, response);
			
		} else {
			// 로그인에 실패했어요! 그러면 세션 발급 실패 -> session.removeAttribute("id");
			// 오류 HTML페이지를 클라이언트에게 전송해요!(HTML)
	    	  // 내가 보내줄 html 파일을 명시 - loginFail.html

			response.sendRedirect("loginFail.html");
			 // 내 id와 pw는 나에게 할당된 login session에 데이터를 박아두기
	    	  // 어느 servlet에서 session이 살아있는 한! 데이터를 지속적으로 이용 가능함
	    	  // session에 박는 걸 어디다가 할건가요? -> servlet과 관련된 처리는 servlet에서 해야해요
	    	  // session은 servlet에서 처리하는 것 다른 곳에서는 처리할 수가 없어요!
		}
		
		
	}

}








