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
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/bookSearch")
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
		// 포스트 방식으로 한글을 넘어와야해요
		request.setCharacterEncoding("UTF-8");
		
		// 1. 입력받아오기
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		
		// 2. 로직 처리 - mybatis 설정이 들어가야해요
		// mybatis 세팅하고
		// 1) sqlsessionFactory 설정(SqlMapConfig.xml)
		// 2) 연결정보를 따로 분리해서 설정(driver.properties)
		// 3) sql을 실행하기 위한 mapper 설정(sqlmap/Book.xml)
		
		// 클라이언트가 보내준 데이터를 이용해서 vo를 생성해요
		// 왜? sql을 실행시켜주고 데이터를 넘겨주기 위해서
		Book book = new Book();
		book.setBtitle(keyword);
		book.setBprice(Integer.parseInt(price));
		
		SqlSession session = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<Book> result = session.selectList("myBook.selectBookByKeyword",book); //sql select의 결과가 여러개이구나
		
		session.close(); // try/finally구문을 원래 사용하지만 걍 close할게요
		
		// 3. 결과 처리
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
