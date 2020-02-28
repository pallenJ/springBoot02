<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../header.jsp"></jsp:include>
</head>
<body>

<div class = "container">

<table class = "table">
  <tr>
    <th>이메일</th>
    <th>닉네임</th>
    <th>정보공개</th>
    <th>가입경로</th>
    <th>권한</th>
  </tr>
  <c:forEach items="${userList}" var = "userInfo">
  <tr>
  	<td>${userInfo.email}
  	<td>${userInfo.name}
  	<td>${userInfo.infoLock==1?'YES':'NO'}
  	<td>${userInfo.sns_reg==null?'E-mail':userInfo.sns_reg}
  	<td>${userInfo.grade}
  </c:forEach>
  
<!--   <tr>
  </tr> -->
</table>


</div>

</body>
<script type="text/javascript">

</script>

</html>