package com.kitri.start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class ServletStart extends HttpServlet {

	public ServletStart() {
		System.out.println("ServletStart 클래스 객체 생성");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletStart init() 호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("ServletStart destroy() 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * get 방식
		 * - URL을 통해 호출
		 * - form 태그 method 속성 값은 get으로 지정하여 호출
		 * - URL을 사용하여 값을 전송하기 때문에 보안에 취약
		 * - 빠름
		 * 
		 */
		
		request.setCharacterEncoding("UTF-8");
		// Query 값을 가져오는 메소드
		String name = request.getParameter("name");
		
		
		System.out.println("doGet 메소드 호출");
		
		// 한글이 깨지지 않도록 response를 charset을 UTF-8로 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>start 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>Servlet Start 페이지</h1>");
		out.println("	<p>get 방식 호출</p>");
		out.println("	<div> name: " + name + "</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * post 방식
		 * - form 태그 method 속성 값은 post로 지정하여 호출
		 * - 값을 url에 보내지 않고 http 프로토콜의 header에 실어서 보내 보안에 강하다.
		 * - 살짝 느림
		 */
		System.out.println("doPost 메소드 호출");
		doGet(request, response);
	}

}
