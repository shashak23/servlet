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
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변환하기
		request.setCharacterEncoding("UTF-8");
		// 어디까지 들어가야하지? 게시글이니까 게시글에 들어가는 모든 내용이 보여야겠지
		
		// 이 세션이었다! 이걸 해야지 id가 유지가 되는데 그 id는 member vo에서 나오니까! 헐 ㅠ
		HttpSession session = request.getSession();
		Member currentUser = (Member)session.getAttribute("member");
				
		// 1. 입력하기
		
		String boardTitle = request.getParameter("boardT");
		String boardContent = request.getParameter("boardC");
//		String boardAuthor = request.getParameter("boardA");
		String boardAuthor = currentUser.getMemberId();
		String boardDate = request.getParameter("boardD");
		

		// 테이블 만들기
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardAuthor(boardAuthor);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
//		board.setBoardLike(boardLike);
		
		// 2. 로직하기
		BoardService service = new BoardService();
		// 보드의 결과를 서비스와 연동
		int result = service.writeBoard(board);
		
		List<Board> list = null;
		if( result == 1) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}
		
		// 작성자가 세션에 저장되어 있는 걸로 하면 비교해서 되지 않을가?
		// 세션에 저장하는 거는 로그인 직후, 아이디를 저장해놓고 종료할때까지 가져가는 걸로
		
		// id가 존재하는 사람이면 정상 처리되어 게시글 완료 
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("loginSuccess.jsp");
		// request.setAttribute("속성노드명", 새로운 속성값);
		// boardList라는 속성노드명에 list라는 속성값을 줘서 request라는 애에
		// setAttribute라는 원하는 값을 하나 꺼내쓸 수 있는 메소드를 활용하여
		// 원하는 속성값도 꺼내고 메소드도 호출하는 것
		request.setAttribute("boardList", list);
		// 마지막으로 dispatcher를 요청해서 forward(request, response)를 실행해서
		// jsp로 넘기는 역할
		dispatcher.forward(request, response);


	}
	}
