package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 데이터 가져오고 연결하고 책제목, 저자, 가격순대로 넣고 검색하고 결과 나오게 하기 
@WebServlet("/booksearch")
public class BookSearchServlet extends HttpServlet {
	public ObservableList<BookVO> getResult(String search) {
		BookSearchService service = new BookSearchService();
		
		ObservableList<BookVO> book = service.selectBookByBookVO(search);
		
		
		return book;
	}
		
	private static final long serialVersionUID = 1L;
    
    public BookSearchServlet() {
    	
    }

//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 1. 입력받기
				String data1 = request.getParameter("");
				String data2 = request.getParameter("author");
				String data3 = request.getParameter("won");
				// 2. 로직처리
				
				// 3. 결과처리 
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<html><head></head><body>");
				out.println("책 제목은 :" + data1 + "<br>");
				out.println("저자 :" + data2 + "<br>");
				out.println("가격 :" + data3 + "<br>");
				out.println("<br><br>");
				out.println("</body></html>");
				out.close();
	}

}
