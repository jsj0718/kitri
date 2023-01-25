package com.kitri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>내 정보 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>내 정보 페이지</h1>");
		out.println("	<div>");
		out.println("	ID : " + id + "<br>");
		out.println("	PW : " + password + "<br>");
		out.println("	이름 : " + name + "<br>");
		out.println("	성별 : " + gender + "<br>");
		out.println("	성별 : " + email + "<br>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
