<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<script type="text/javascript">
	// 접근 토큰 값 출력
// 	alert(naver_id_login.oauthParams.access_token);
	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
// 		alert(naver_id_login.getProfileData('email'));
// 		alert(naver_id_login.getProfileData('name'));
// 		alert(naver_id_login.getProfileData('birthday'));
// 		alert(naver_id_login.getProfileData('mobile'));
		
		let user = new Object();
		user.name = naver_id_login.getProfileData('name');
		user.email = naver_id_login.getProfileData('email');
		user.birthday = naver_id_login.getProfileData('birthday');
		user.mobile = naver_id_login.getProfileData('mobile');
		
		console.log(user.name);
		console.log(user.email);
		// jquery
		// 라이브러리 (직접 다운 가능, cdn (code delivery network) : web에서 라이브러리를 제공 받는 것)
		// javascript dom객체 (html 요소)를 편리하게 사용하기 위한 라이브러리
		// javascript 예) document.getElementById("id");
		// 				 document.getElementsByName("name"); -> 배열로 가져와진다. (골라내기가 힘듦)
		
		// jquery 예) $(선택자) ID -> $("#id")
		//						 -> $(".class")
		//						 -> $("tag")
		
		$.ajax({
			url: "${pageContext.request.contextPath}/user/naverlogincheck",	// 이동할 url 값
			type: "POST",	// method POST, GET
			data: JSON.stringify(user),	// url로 이동시킬 데이터 값
			dataType: "json",	// 데이터 타입 설정 (json, xml)
			contentType: "application/json",
			success:function(data) {
				console.log(data)
				
				window.location.replace("${pageContext.request.contextPath}/main");	// redirect는 replace()로 진행
				
			}, 
			error: function(request, status, error) {
				console.log("code: " + request.status);
				console.log("message: " + request.responseText);
				console.log("error: " + error);
			}
		});
		
	}
</script>
</body>
</html>
