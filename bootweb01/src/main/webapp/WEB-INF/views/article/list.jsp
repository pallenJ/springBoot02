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
<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
<a class="btn btn-success" href="write">new post</a>
<div align="center">
<table class = "table table-hover">
  <tr>
    <th>id</th>
    <th>subject</th>
    <th>reg date</th>
  </tr>

<c:forEach items="${articleList}" var ="article">
	<tr class ="article-item" role = "${article.id}">
		<td>${article.id}
		<td>${article.subject}
		<td>${article.content}

</c:forEach>
</table>
</div>



</body>

<script type="text/javascript">

$(function() {
	$(".article-item").click(function() {
		alert($(this).attr("role"))
		location.href = "/article/"+$(this).attr("role")
	})
})

</script>

</html>