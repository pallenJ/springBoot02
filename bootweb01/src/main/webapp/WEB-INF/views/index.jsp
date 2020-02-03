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
        <a href="">
            <img src="/img/kakao_account_login_btn_medium_narrow.png">
        </a>
    </c:if>
    <c:if test="${userId ne null}">
        <h1>로그인 성공입니다</h1>
    </c:if>
</div>    
</body>
</html>