<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/header.jsp"></jsp:include>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<div align="center">
<!-- <h3>Naver Login</h3>
<a id = "showBtn" class = "btn btn-outline-success">로그인</a> -->
<!-- 네이버 아이디로그인을 위한 자바스크립트 -->

<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<div id="naver_id_login"></div>


<script type="text/javascript">
	var naver_id_login = new naver_id_login("kshKjN065CWIg2C10bnq", "http://localhost:8007/naver/login");
  // 접근 토큰 값 출력
  alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
   // alert(naver_id_login.getProfileData('nickname'));
/*     alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age')); */
  }
</script>



</div>




</body>
</html>

