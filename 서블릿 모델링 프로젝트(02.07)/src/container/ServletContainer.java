package container;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;
import threadinvoker.CilentThread;

// tomcat(was)안의 servelt container역할을 하는 클래스
public class ServletContainer {
	// 일반 자바 프로그램이라서 있는 거에요
	// 실제로 서블렛 컨테이너는 이런게 없어요
	public static void main(String[] args) {
		// 1. 사용자의 요청사항(request)을 분석
		// 어떤 서블릿을 실행하는 지 알아내기. -> add Servlet을 실행하라는 요청을 받음
		
		// 2. add 라는 서블릿의 instance가 있는지를 확인
		// 어디에? container않에 객체가 있는지를 확인
		
		// 3. 객체가 없기때문에 add servlet을 찾아서 객체를 생성해야 해요
		AddServlet servlet = new AddServlet();
		
		// 4. servlet instance가 생성되면 해당 서블릿에 init를 호출해요
		// 서버 컨테이너가 가지고 있는 init를 호출해!
		// init()
		servlet.init();
		
		// 5. 이닛이 끝났기때문에 클라이언트가 보내중 request 내용을 기반으로 객체를 하나 생성ㅎ가ㅗ
		// 당연히 이 객체에는 클라이언트가 보내준 데이터가 들어가 있어요
		HttpServletRequest request = 
				new HttpServletRequest();
		// 6. 클라이언트에세 최종 결과를 보내주기 위해서 reponse객체를 하나 민들어야 해요
		// 어디에 만들거냐면 ? arguments에 새로 생성
		HttpServletResponse reponse = 
				new HttpServletResponse();
		// 7. 지금은 thread가 나와야 해요
		// 대신에 일은 servlet instance가 해요
		// 그 일을 실제로 실행시켜주는 주체는 thread에요
		// 여기가 좀 어려워요 :)
		// 클라이언트의 요청을 실제로 처리하기 위해 thread가 있어야 해요 
		CilentThread thread =
				new CilentThread(servlet,request,reponse);
		thread.start();
		// 동작을 하기 위해서 thread를 실행시켜야 하는데
		// 여기서 서블렛, request, reponse를 인자로 넣어야 해요
		// 클라이언트 스레드가 생성자로 받아야하고
		
	}
}
