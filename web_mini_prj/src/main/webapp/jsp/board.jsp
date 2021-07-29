<%@page import="com.kitri.miniboard.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kitri.miniboard.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	header {
		width: 700px;
		margin:20px auto;	
	}
	
	h1 {
		margin: 20px auto;
		text-align: center;
	}
	
	table {
		margin: 0 auto;
		border: 1px solid black;
		width: 700px;
		border-collapse: collapse;
	}
	
	tr {
		height: 40px;
	}
	
	td, th {
		border: 1px solid black;
		text-align: center;
	}
	
	thead {
		background-color: skyblue;
	}
	
	
	thead th:nth-child(1) {
		width: 70px;
	}
	
	thead th:nth-child(2) {
		width: 480px;
	}
	
	thead th:nth-child(3) {
		width: 100px;
	}
	
	thead th:nth-child(4) {
		width: 150px;
	}

	tbody {
		background-color: white;
	}
</style>
</head>
<body>
<%
	BoardDAO bdao = new BoardDAO();
	ArrayList<BoardVO> blist = bdao.selectBoard();
%>
	<header>
		<h1>게시판</h1>	
		<a href="boardWrite.jsp">글 등록</a>
	</header>
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
<%	
		for (BoardVO bvo : blist) {
%>
			<tr>
				<td><%=bvo.getBno() %></td>
				<td><%=bvo.getBtitle() %></td>
				<td><%=bvo.getBwriter() %></td>
				<td><%=bvo.getBregDate() %></td>
			</tr>
<%			
		}
%>
		</tbody>
	</table>
</body>
</html>