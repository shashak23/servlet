package threadinvoker;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;

public class CilentThread extends Thread{
	// 필드 생성
	private AddServlet servlet;
	private HttpServletRequest request;
	private HttpServletResponse reponse;
	
	// constructor 생성
	public CilentThread(AddServlet servlet, HttpServletRequest request, HttpServletResponse reponse) {
		super();
		this.servlet = servlet;
		this.request = request;
		this.reponse = reponse;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		servlet.service(request, reponse); // 서블렛에 서비스로 re
	}
}
