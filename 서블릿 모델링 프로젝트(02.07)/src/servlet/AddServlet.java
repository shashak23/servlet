package servlet;

import java.security.Provider.Service;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;

// SERVLET이라고 불리는 이 클래스느 원해  독자적으로 만ㄷ르지 않아요
// 이 클래스는 특정 클ㄹ스를 상속해서 이 클ㄹ스를 든 곳 
public class AddServlet {
	// override 된 상속이 된 init가 있따
	private void init() {
		// TODO Auto-generated method stub
		// 서블렛 인스턴스의 초기화를 담당하고
		// 생성자 초기화 
	}
	private void Service(HttpServletRequest request,
						 HttpServletResponse reponse) {
		// container가 만든 클라이언트 객체를 값으로 넣어주기
		// 이 메소드는 하는 일이 정해져 있어서 override하지 않아요
		// 여기서 request객체를 뒤져서 클라이언트의 요청방식이 어떤 방식인지 알아내요
		// get, post, put, delete 방식인지 알아내기
		// 그래서 만약에 get 방식이면 doGet()을 호출해요
		// doGet(requset, reponse)이렇게 함 
		doGet(requset, reponse);
		//만약 이게 post방식이면 doPost(requset, reponse)을 호출해요

	}
	private void doget(HttpServletRequest request,
			 HttpServletResponse reponse) {
		// 여기서 request 객체와 response 객체를 이용해서
		// 입력처리와 로직처리 그리고 출력처리를 진행해요!

	}
	private void dopush() {
		// TODO Auto-generated method stub

	}
	private void doput() {
		// TODO Auto-generated method stub

	}
	private void dodelete() {
		// TODO Auto-generated method stub

	}
}
