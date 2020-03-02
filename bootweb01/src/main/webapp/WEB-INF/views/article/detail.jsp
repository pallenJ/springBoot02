<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
<a href = "/article"> list </a>
	<div class="container">
	
	<h2>${article.subject}</h2>
		<div class = "border">
			${article.content}
		
		</div>
	<div align="right">
	<small>${article.reg_date}</small>
	</div>
	</div>

</body>
</html>