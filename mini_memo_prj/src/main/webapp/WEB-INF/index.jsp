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
1. 로그인 
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>Astral by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/mini_memo_prj/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="/mini_memo_prj/assets/css/noscript.css" /></noscript>
		
		<link href='/mini_memo_prj/calendar-assets/main.css' rel='stylesheet' />
	    <script src='/mini_memo_prj/calendar-assets/main.js'></script>
	    <script>
	
			document.addEventListener('DOMContentLoaded', function() {
				var calendarEl = document.getElementById('calendar');
				var calendar = new FullCalendar.Calendar(calendarEl, {
					initialView: 'dayGridMonth',
					dateClick: function(info)  {
						// memo의 date 값을 설정
						var mdate = document.getElementById("mdate");
						mdate.value = info.dateStr;
						location.href = "/mini_memo_prj/index#memo";
// 						calendar.addEvent({
// 								id: 'b',
// 								title: 'my event2',
// 								start: info.dateStr		
// 						});
					},
					events: ${mjson}	// EL은 javascript에서 바로 사용 가능하다.
				});

			calendar.render();	// calendar를 그려주는 메소드
			});
		
			window.onload = function() {
				const cancelBtn = document.getElementById("cancel-btn");
				cancelBtn.onclick = function() {
					location.href = "/mini_memo_prj/index#";	// 취소 버튼 시 캘린더 창으로 이동
				}
			}
	    </script>
	</head>
	<body class="is-preload">

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#" class="icon solid fa-home"><span>Calendar</span></a>
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
								<form action="memo-regist" method="post">
									<div>
										<div class="row">
											<div>
												<input type="date" name="mdate" id="mdate" value="">
											</div>
											<div class="col-12">
												<input type="text" name="title" placeholder="Title" />
											</div>
											<div class="col-12">
												<textarea name="memo" placeholder="Memo" rows="6"></textarea>
											</div>
											<div class="col-12">
												<input type="submit" value="Save" />
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
			<script src="/mini_memo_prj/assets/js/jquery.min.js"></script>
			<script src="/mini_memo_prj/assets/js/browser.min.js"></script>
			<script src="/mini_memo_prj/assets/js/breakpoints.min.js"></script>
			<script src="/mini_memo_prj/assets/js/util.js"></script>
			<script src="/mini_memo_prj/assets/js/main.js"></script>

	</body>
</html>