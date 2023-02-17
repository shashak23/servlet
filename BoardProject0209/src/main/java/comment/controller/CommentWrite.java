package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;

/**
 * Servlet implementation class CommentHead
 */
@WebServlet("/commentwrite")
public class CommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentWrite() {
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
		// 입력 / 로직(serlvet) / 출력(jsp)
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Member currentUser = (Member)session.getAttribute("member");
		
		// 오토인크리먼트로 해서 순서는 그냥 뺴고 되고
		// 접속 중인 사람만 댓글을 달 수 있는 구조로 하기위해 아이디 정보를 가져온다.
		String commentAuthor = currentUser.getMemberId();
		String commentContent = request.getParameter("commentT");
		int boardNum = Integer.parseInt(request.getParameter("bNum"));
		
		// vo를 import하고 코멘트마다 필요한 정보들을 넣어 세터로 불러오기, 받아오기
		Comment comment = new Comment();
		comment.setCommentAuthor(commentAuthor);
		comment.setCommentContent(commentContent);
		comment.setBoardNum(boardNum);
		
		CommentService service = new CommentService();
		
		//여기서 어떻게 써야하는거지? 그냥 데이터 update가 아닌데 
		int result = service.writeComment(comment);
		
		if (result == 1) {
			List<Comment> list = service.getAllComment(boardNum); // bnum을 넣어줘야 해당 게시글을 검색해 올 수 있어요
			
			if(list != null) {
				response.setContentType("applicaion/json; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				Gson gson = new Gson();
				String jsonData = gson.toJson(list);
				
				out.print(jsonData);
			}
		}

	}
}
