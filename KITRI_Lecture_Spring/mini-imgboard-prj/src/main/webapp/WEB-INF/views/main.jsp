<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	text-align: center;
}

#imgBoardList {
	width: 70%;
	margin: 0 auto;
	border: 1px solid gray;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
}

.imgBoardBox {
	width: 200px;
	height: 200px;
	margin: 5px;
	border: 1px solid black;
}

#moreList {
	width: 200px;
	height: 50px;
	border: 1px solid black;
	cursor: pointer;
	margin: 0 auto;
}

#modal-btn {
	display: inline-block;
	padding: 20px;
	background-color: #222;
	color: white;
	border-radius: 10px;
	cursor: pointer;
}

#modal-wrapper {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 10;
}

#modal-box {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 500px;
	height: 300px;
	width: 500px;
	background-color: white;
	border-radius: 20px;
	z-index: 2;
}

#modal-cancel-btn {
	position: absolute;
	top: 0;
	right: 0;
	padding: 10px;
	margin: 5px;
	color: white;
	border-radius: 10px;
	z-index: 2;
	background-color: #6E6E6E;
	cursor: pointer;
}

#modal-cancel-area {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.9);
	z-index: 1;
}

#modal-cancel-btn:hover {
	background-color: #222;
}

#modal-imgboardbox {
	text-align: center;
}
</style>
<script>
	$(document).ready(function() {
		$("#moreList").on("click", function(){
			let start = $(".imgBoardBox").length + 1;
			let end = start + 8;
			
			console.log(start + ", " + end);
			
			$.ajax({
				url: "${path}/main/morelist",
				type: "post",
				data: {"start" : start, "end" : end},
				dataType: "json",
				success: function(data) {
					if (data.length % 9 != 0) {
						$("#moreList").attr("style", "display:none");
					}
					
					if (data.length > 0) {
						let imgBoardBox = "";
						for (let i=0; i<data.length; i++) {
							imgBoardBox += '<div class="imgBoardBox">'
										+		'<input type="hidden" name="no" value="'+data[i].no+'">'
										+		'<input type="hidden" name="userid" value="'+data[i].userid+'">'
										+		'<input type="hidden" name="content" value="'+data[i].content+'">'
										+		'<input type="hidden" name="regdate" value="'+data[i].regdate+'">'
										+		'<img src="${path}/'+data[i].img+'" alt="image" width="200px" height="200px">'
										+	'</div>';
						}
						$("#imgBoardList").append(imgBoardBox);						
					}
				},
				error: function(request, status, error) {
					
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>이미지 게시판</h1>
	<c:choose>
		<c:when test="${id ne null}">
			<a href="${path}/main/imgboard-regist-page">등록</a>	
			<a href="${path}/user/logout">로그아웃</a>		
		</c:when>
		<c:otherwise>
			<a href="${path}/user/login">로그인</a>		
		</c:otherwise>
	</c:choose>

	<div id="imgBoardList">
		<c:forEach var="ibvo" items="${ibList}">
			<div class="imgBoardBox">
				<input type="hidden" name="no" value="${ibvo.no}">
				<input type="hidden" name="userid" value="${ibvo.userid}">
				<input type="hidden" name="content" value="${ibvo.content}">
				<input type="hidden" name="regdate" value="${ibvo.regdate}">

				<img src="${path}/${ibvo.img}" alt="image" width="200px" height="200px">
			</div>
		</c:forEach>
	</div>
	<div id="moreList">더보기</div>
	
	<div id="modal-wrapper">
		<div id='modal-cancel-btn'>X</div>
		<div id="modal-box"></div>
		<div id="modal-cancel-area"></div>
	</div>

	<script type="text/javascript">
		$("#imgBoardList").on("click", function(event) {
			console.log(event.target.nodeName);
			if (event.target.className == "imgBoardBox" || event.target.nodeName == "IMG") {
// 				$("#modal-wrapper").attr("style", "display: block");
				let imgBoardBox = $(event.target).parent();
				let userid = imgBoardBox.children("input:eq(1)");
				let content = imgBoardBox.children("input:eq(2)");
				let regdate = imgBoardBox.children("input:eq(3)");
				let img = $(event.target)
	
				let html = "";
				
				html += "<div id='modal-imgboardbox'>"
					 +    "<img alt='이미지' src='" + img.attr("src") + "' width='200px' height='200px'>"
					 +    "<div>" + userid.val() + "-" + regdate.val() + "</div>"
					 +    "<div id='modal-content'>" + content.val() + "</div>"
					 +  "</div>";
				
				$("#modal-box").append(html);
				$("#modal-wrapper").show();
			}
		});
		
		$("#modal-cancel-area").on("click", function() {
// 			$("#modal-wrapper").attr("style", "display: none");
			$("#modal-wrapper").hide();
			$("#modal-box").empty();
		});
		
		$("#modal-cancel-btn").on("click", function() {
			$("#modal-wrapper").hide();
			$("#modal-box").empty();
		});
	</script>
</body>
</html>