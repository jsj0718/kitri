<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
1. 날짜 클릭
2. 메모 페이지
3. 메모 작성 후 저장 (DB 저장)
4. 캘린더
5. event 적용
 --%>

<%--
추가할 기능
1. 로그인 시에만 접속 가능하게 막기
2. 페이지 이동 간 적절한 데이터 배치
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>Astral by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/noscript.css" /></noscript>
		
		<link href='${pageContext.request.contextPath }/calendar-assets/main.css' rel='stylesheet' />
	    <script src='${pageContext.request.contextPath }/calendar-assets/main.js'></script>
	    <script>
	
			document.addEventListener('DOMContentLoaded', function() {
				var no = document.getElementById("no");
				var mdate = document.getElementById("mdate");
				var title = document.getElementById("title");
				var memo = document.getElementById("memo-area");
				var saveBtn = document.getElementById("save-btn");
				var updateBtn = document.getElementById("update-btn");
				var deleteBtn = document.getElementById("delete-btn");
				
				var calendarEl = document.getElementById('calendar');
				var calendar = new FullCalendar.Calendar(calendarEl, {
					initialView: 'dayGridMonth',
					// 날짜 선택하여 메모 작성하는 이벤트
					dateClick: function(info)  {
						// memo의 date 값을 설정
						mdate.value = info.dateStr;
						
						// 나머지 값 초기화
						no.value = "";
						title.value = "";
						memo.value = "";
						
						saveBtn.setAttribute("type", "button");
						updateBtn.setAttribute("type", "hidden");
						deleteBtn.setAttribute("type", "hidden");
						
						location.href = "${pageContext.request.contextPath }/index#memo";
// 						calendar.addEvent({
// 								id: 'b',
// 								title: 'my event2',
// 								start: info.dateStr		
// 						});
					},
					// event 클릭 시 발생하는 이벤트 추가
					eventClick: function(arg) {
						no.value = arg.event.id;
						mdate.value = arg.event.startStr;
						title.value = arg.event.title;
						memo.value = arg.event.extendedProps.description;
						
						saveBtn.setAttribute("type", "hidden");
						updateBtn.setAttribute("type", "button");
						deleteBtn.setAttribute("type", "button");
						
						location.href = "${pageContext.request.contextPath }/index#memo";
					},
					// DB에 저장되어 있는 이벤트 호출
					events: ${mjson}	// EL은 javascript에서 바로 사용 가능하다.
				});

			calendar.render();	// calendar를 그려주는 메소드

				const cancelBtn = document.getElementById("cancel-btn");
				var no = document.getElementById("no");
				var mdate = document.getElementById("mdate");
				var title = document.getElementById("title");
				var memo = document.getElementById("memo-area");
				
				// cancel 버튼 클릭 시
				cancelBtn.onclick = function() {
					// 값 초기화				
					no.value = "";
					mdate.value = "";
					title.value = "";
					memo.value = "";
					// 버튼 속성 초기화
// 					var saveBtn = document.getElementById("save-btn");
// 					var updateBtn = document.getElementById("update-btn");
// 					var deleteBtn = document.getElementById("delete-btn");

					saveBtn.setAttribute("type", "button");
					updateBtn.setAttribute("type", "hidden");
					deleteBtn.setAttribute("type", "hidden");
					
					location.href = "${pageContext.request.contextPath }/index#home";	// 취소 버튼 시 캘린더 창으로 이동
				}
				
// 				const saveBtn = document.getElementById("save-btn");
				saveBtn.onclick = function() {
					// ajax 통신 요청
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "${pageContext.request.contextPath}/memo-regist", true);
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					xhr.send("mdate=" + mdate.value + "&title=" + title.value + "&memo=" + memo.value);
					xhr.onreadystatechange = function() {
						if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
							
							var code = xhr.responseText;
							if (code) {
								// 성공
								alert("메모 등록 성공");	
								calendar.addEvent({
									title: title.value,
									start: mdate.value,
									description: memo.value
								});
							} else {
								// 실패
								alert("메모 등록 실패");								
							}
						}
					}
// 					document.form.submit();	// 서버요청 (페이지 이동)
				}
				
// 				const updateBtn = document.getElementById("update-btn");
				updateBtn.onclick = function() {
					document.form.action = "${pageContext.request.contextPath }/memo-update";
					document.form.submit();
				}
				
// 				const deleteBtn = document.getElementById("delete-btn");
				deleteBtn.onclick = function() {
					document.form.action = "${pageContext.request.contextPath }/memo-delete";
					document.form.submit();
				}
			});
	    </script>
	</head>
	<body class="is-preload">

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#home" class="icon solid fa-home"><span>Calendar</span></a>
<!-- 						<a href="#work" class="icon solid fa-folder"><span>Work</span></a> -->
						<a href="#memo" class="icon solid fa-envelope"><span>Memo</span></a>
<!-- 						<a href="https://twitter.com/ajlkn" class="icon brands fa-twitter"><span>Twitter</span></a> -->
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="home" class="panel intro">
								<div id='calendar'>
									
								</div>
							</article>


						<!-- memo -->
							<article id="memo" class="panel">
								<header>
									<h2>My Memo</h2>
								</header>
								<form action="${pageContext.request.contextPath }/memo-regist" method="post" name="form">
									<input type="hidden" name="no" id="no">
									<div>
										<div class="row">
											<div>
												<input type="date" name="mdate" id="mdate">
											</div>
											<div class="col-12">
												<input type="text" name="title" id="title" placeholder="Title" />
											</div>
											<div class="col-12">
												<textarea name="memo" id="memo-area" placeholder="Memo" rows="6"></textarea>
											</div>
											<div class="col-12">
												<input type="button" value="Save" id="save-btn" />
												<input type="hidden" value="Update" id="update-btn" />
												<input type="hidden" value="Delete" id="delete-btn" />
												<input type="button" value="Cancel" id="cancel-btn" />
											</div>
										</div>
									</div>
								</form>
							</article>

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/main.js"></script>

	</body>
</html>