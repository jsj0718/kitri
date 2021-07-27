package com.kitri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	
	// service가 있으면 doGet에 PrintWriter가 작동하지 않는다.
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		int age = Integer.parseInt(request.getParameter("age"));
		String myintro = request.getParameter("myintro");
		
		// JSP의 ContentType 내용
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>내 정보 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>내 정보 페이지</h1>");
		out.println("	<div>");
		out.println("	닉네임 : " + nickname + "<br>");
		out.println("	이름 : " + name + "<br>");
		out.println("	ID : " + id + "<br>");
		out.println("	PW : " + pw + "<br>");
		out.println("	성별 : " + gender + "<br>");
		out.println("	취미 : ");
		for (int i=0; i<hobby.length; i++) {
			out.println(hobby[i] + ", ");			
		}
		out.println("<br>");
		out.println("	나이 : " + age + "<br>");
		out.println("	자기소개 : " + myintro + "<br>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		int age = Integer.parseInt(request.getParameter("age"));
		String myintro = request.getParameter("myintro");
		
		// JSP의 ContentType 내용
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>내 정보 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>내 정보 페이지</h1>");
		out.println("	<div>");
		out.println("	닉네임 : " + nickname + "<br>");
		out.println("	이름 : " + name + "<br>");
		out.println("	ID : " + id + "<br>");
		out.println("	PW : " + pw + "<br>");
		out.println("	성별 : " + gender + "<br>");
		out.println("	취미 : ");
		for (int i=0; i<hobby.length; i++) {
			out.println(hobby[i] + ", ");			
		}
		out.println("<br>");
		out.println("	나이 : " + age + "<br>");
		out.println("	자기소개 : " + myintro + "<br>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
