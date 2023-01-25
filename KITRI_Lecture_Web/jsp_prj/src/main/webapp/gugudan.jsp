<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		display: inline-block;
		margin: 0;
		padding: 0;
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	tr, th {
		border: 1px solid black;
	}
	
	caption, th {
		background-color: skyblue;
		border: 1px solid black;
	}

</style>
</head>
<body>

	<h1>구구단 표</h1>	
<%
	for (int i=2; i<10; i++) {
%>
	<table border="1">
		<caption><%=i + "단" %></caption>
		<tr>
			<th>식</th>
			<th>결과값</th>
		</tr>
		<%-- out 객체를 이용해 HTML에 출력 가능 --%>		
		<%
			for (int j=1; j<10; j++) {
		%>
		<tr>
			<td><%=i + " X " + j %></td>
			<td><%=i * j %></td>
		</tr>
		<%
			}
		%>
	</table>
<%
	}
%>
</body>
</html>