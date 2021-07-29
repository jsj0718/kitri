<%@page import="com.kitri.javabean.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<%
	StudentVO student = new StudentVO();
	student.setName("학생1");
	student.setAge(17);
	student.setBan("1반");
	
	out.print("<h1> 이름: " + student.getName() + "</h1>");
	out.print("<h1> 나이: " + student.getAge() + "</h1>");
	out.print("<h1> 반: " + student.getBan() + "</h1>");
%>
--%>
 
<%--
<jsp:useBean id="student" class="com.kitri.javabean.StudentVO"/>
<jsp:setProperty name="student" property="name" value="학생1"/>
<jsp:setProperty name="student" property="age" value="17"/>
<jsp:setProperty name="student" property="ban" value="1반"/>

<h1>이름 : <jsp:getProperty property="name" name="student"/></h1>
<h1>나이 : <jsp:getProperty property="age" name="student"/></h1>
<h1>반 : <jsp:getProperty property="ban" name="student"/></h1>
--%>

<jsp:useBean id="student" class="com.kitri.javabean.StudentVO"/>
<jsp:setProperty property="*" name="student"/>
<%--
<jsp:setProperty property="name" name="student"/>
<jsp:setProperty property="age" name="student"/>
<jsp:setProperty property="ban" name="student"/>
--%>
 
<%-- <h1>이름 : <jsp:getProperty property="name" name="student"/></h1> --%>
<h1>이름 : <%=student.getName() %></h1>
<h1>나이 : <jsp:getProperty property="age" name="student"/></h1>
<h1>반 : <jsp:getProperty property="ban" name="student"/></h1>

</body>
</html>