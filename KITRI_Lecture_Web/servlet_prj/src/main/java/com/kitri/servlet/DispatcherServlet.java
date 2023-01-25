package com.kitri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div>Dispacher Servlet</div>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("데이터베이스 접속");
		System.out.println("계산");
		System.out.println("데이터베이스 검색값 조회...");
		
		// dispatcher 경로이지만 dispatcher-html.html 내용을 띄움
		RequestDispatcher rd = 
				request.getRequestDispatcher("dispatcher-html.html");
		
		rd.include(request, response);
		
		// dispatcher-html.html로 이동
//		response.sendRedirect("dispatcher-html.html");
		
				
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
