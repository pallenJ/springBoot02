<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<jsp:include page="include/header.jsp"></jsp:include>
</head>
<body>
<div align="center">
<h1>LOGIN</h1>
    <c:if test="${userId eq null}">
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=cd38b0930f04cc1506e2a3beecf1923c&redirect_uri=http://localhost:8007/login&response_type=code">
            <img src="/img/kakao_account_login_btn_medium_narrow.png">
        </a>
    </c:if>
    <c:if test="${userId ne null}">
        <h1>로그인 성공입니다</h1>
    </c:if>
</div>    
</body>
</html>