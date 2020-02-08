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

<h2>
${userName}
</h2>
<hr>

<button class = "form-control btn btn-outline-primary" onclick="location.href = $(location).attr('pathname')+'/brdList'">작성글 리스트</button>
<button class = "form-control btn btn-outline-info" onclick="">자세히</button>

</div>

</body>
<script type="text/javascript">

</script>

</html>