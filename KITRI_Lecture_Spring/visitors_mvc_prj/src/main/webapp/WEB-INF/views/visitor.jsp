<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		const searchVisitors = document.getElementById("search-visitors");
		// 클릭 시 발생하는 event를 매개 변수로 받을 수 있다. (target을 이용하면 클릭한 애의 요소를 가져올 수 있다.)
		searchVisitors.onclick = function(event) {
			$target = event.target;	// $나 _도 변수 지정 가능
			
			var nickname = $target.previousElementSibling.value;
			
			// nodeName은 태그 이름, readOnly는 true | false 반환
			if ($target.nodeName == "TEXTAREA" && $target.readOnly && nickname == "${nickname}") {
				var result = confirm("수정하시겠습니까?");
				if (result) {
					$target.readOnly = false;
				}
			}
		}
		
	}
	
	// $this를 매개변수로 받아서 클릭한 요소의 DOM 정보를 받아온다.
	function updateVisitor($this) {
// 		console.log($this);
		var form = $this.parentElement;
		form.action = "update";
		form.method = "post";
		form.submit();
		
	}
	
	function deleteVisitor($this) {
		var form = $this.parentElement;
		form.action = "delete";
		form.method = "post";
		form.submit();
	}
</script>
</head>
<body>
	<h1>방명록 입니다.</h1>
	<form action="regist" method="post">
		<input type="hidden" name="nickname" value="${nickname }"> 
		<textarea rows="10" cols="40" name="content"></textarea>
		<input type="submit" value="등록">
	</form>
	<div id="search-visitors">
		<c:forEach items="${vlist }" var="vvo">
		<form>
			<input type="hidden" name="vno" value="${vvo.vno }">
			<!-- 형제 요소를 호출하기 위해 textarea 바로 위에 위치해야 한다. -->
			<input type="hidden" name="nickname" value="${vvo.nickname }">
			<textarea rows="10" cols="40" name="content" readonly>${vvo.content }</textarea>
			<span>${vvo.nickname } - ${vvo.regdate }</span>
			
			<c:if test="${nickname eq vvo.nickname}">
			<!-- this를 통해 자기 자신(DOM 요소)을 가지고 간다. -->
			<a href="#" onclick="updateVisitor(this)">수정</a>
			<a href="#" onclick="deleteVisitor(this)">삭제</a>
			</c:if>

		</form>
		</c:forEach>	
	</div>
</body>
</html>