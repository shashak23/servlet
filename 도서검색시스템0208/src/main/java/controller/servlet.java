package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/booksearch")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		// 1. 입력하기
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		
		// 팩토리가 만든 세션이 sql문장을 실행시켜주는 주체이다.
		// 2. 로직하기
		Book book = new Book();
		book.setBtitle(keyword); //여러객체를 보낼 떄
		book.setBprice(price);
		
		SqlSession session = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<Book> result = session.selectList("myBook.selectBookByKeyword",book); 
		//sql select의 결과가 여러개이구나
		
		session.close();
		
		// 3. 출력하기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<h3>검색키워드: " + keyword + "</h3>");
		out.println("<h3>검색가격: " + price + "</h3>");
		out.println("<ul>");
		
		for(Book tmp: result) {
			out.println("<li>" + tmp.getBtitle() + "," 
						+ tmp.getBprice() + "</li>");
		}

		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}

}
