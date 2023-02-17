package comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;

/**
 * Servlet implementation class CommentModify
 */
@WebServlet("/commentmodify")
public class CommentModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentModify() {
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
		// 한글이 안 깨지게끔 해주느 거 
				request.setCharacterEncoding("UTF-8");
				// 데이터 보낼 거 입력하기
				String boardContent = request.getParameter("boardC");
				int bNum = Integer.parseInt(request.getParameter("bNum"));
				
				Board board = new Board();
				board.setBoardContent(boardContent);
				board.setBoardNum(bNum);
				
				//보드넘버를 명시해주는 과정이 없다
				
				// 로직을 위한 service 생성 및 결과
				BoardService service = new BoardService();
				int result = service.updateBoard(board);
				List<Board> list = null;
			
				if(result ==1) {
					
					BoardService bservice = new BoardService();
					list = bservice.getAllBoard();
					// 다른 페이지에서도 찾을 수 있게 키와 값을 쌍으로 명시한다
					request.setAttribute("boardList", list);
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("loginSuccess.jsp");
					dispatcher.forward(request, response);
				} else {
					response.sendRedirect("modifyFail.html");
				}
	}

}
