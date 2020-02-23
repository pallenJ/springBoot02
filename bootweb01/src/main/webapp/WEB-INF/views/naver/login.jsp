<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/header.jsp"></jsp:include>
<script>


</script>
</head>
<body>
<div align="center">
<!-- <h3>Naver Login</h3>
<a id = "showBtn" class = "btn btn-outline-success">로그인</a> -->
<!-- 네이버 아이디로그인을 위한 자바스크립트 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>

<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<div id="naver_id_login"></div>

<script type="text/javascript">
  	var naver_id_login = new naver_id_login("kshKjN065CWIg2C10bnq", "http://localhost:8007/naver/login");
  	var state = naver_id_login.getUniqState();
    naver_id_login.response_type="code";
  	naver_id_login.setButton("white", 3, 40);
  	naver_id_login.setDomain("http://localhost:8007/naver/login");
  	naver_id_login.setState(state);
  	naver_id_login.init_naver_id_login();
</script>
</div>




</body>
</html>

