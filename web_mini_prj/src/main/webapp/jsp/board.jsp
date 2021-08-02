<%@ page import="com.kitri.miniboard.board.Pagination"%>
<%@ page import="com.kitri.miniboard.board.BoardVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.kitri.miniboard.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">

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
	
	/* pagination 가운데 정렬 */
	.pagination {
 	  display: block;
 	  text-align: center;
	}
	
	.pagination > li > a {
		float: none;
	}
</style>
</head>
<body>
<%
	BoardDAO bdao = new BoardDAO();
	
	String curPage = request.getParameter("curpage");
	if (curPage == null) {
		curPage = "1";
	}
	
	int curPageInt = Integer.parseInt(curPage);
	int totalContent = bdao.selectBoardCnt();
	Pagination pagination = new Pagination(curPageInt, totalContent, 5);
	
	// 한 page 내 보여줘야하는 게시물의 첫 번째 Rownum
	int start = (curPageInt * pagination.getContentCnt()) - (pagination.getContentCnt() - 1);
	// 한 page 내 보여줘야하는 게시물의 마지막 Rownum
	int end = curPageInt * pagination.getContentCnt();
	
	ArrayList<BoardVO> blist = bdao.selectBoardPage(start, end);
%>
<c:set var="page" value="<%=pagination %>"/>
<c:set var="blist" value="<%=blist %>"/>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="board.jsp">게시판</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">메인 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">메뉴
							<span class="caret"></span>
						</a>
						<!-- 로그인 여부에 따른 상단 네비게이션 -->
						<c:choose>
							<c:when test="${!empty sessionScope.userId }">
								<ul class="dropdown-menu" role="menu">
									<li><a href="boardWrite.jsp">글쓰기</a></li>
									<li><a href="logoutAction.jsp">로그아웃</a></li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul class="dropdown-menu" role="menu">
									<li><a href="login.jsp">로그인</a></li>
								</ul>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<header>
		<h1>게시판</h1>
	</header>
	
	<!-- 게시글 테이블 -->
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		
		<!-- 게시글 컨텐츠 -->
		<tbody>
		<c:forEach var="bvo" items="${blist }">
			<tr>
				<td>${bvo.bno}</td>
				<td><a href="boardDetail.jsp?bno=${bvo.bno}">${bvo.btitle}</a></td>
				<td>${bvo.bwriter}</td>
				<td>${bvo.bregDate}</td>
			</tr>		
		</c:forEach>
		</tbody>
	</table>
	
	<!-- pagination -->
	<nav>
		<ul class="pagination">
			<!-- 이전 버튼 -->
			<c:if test="${page.prevBtn }">
				<li>
					<a href="board.jsp?curpage=${page.startPage - 1 }" aria-label="Previous"> 
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			
			<!-- 페이지 처리 -->
			<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }" step="1">
				<c:choose>
					<c:when test="${param.curpage eq i }">
						<li class="active"><a href="#">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="board.jsp?curpage=${i }">${i }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 버튼 -->
			<c:if test="${page.nextBtn }">
				<li>
					<a href="board.jsp?curpage=${page.endPage + 1 }" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
		</ul>
	</nav>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>