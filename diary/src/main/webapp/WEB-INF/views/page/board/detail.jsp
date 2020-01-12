<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>

<div class = "container">
<h1>title : ${brdDetail.title}</h1>
<h5>writer :  ${brdDetail.user.name}</h5>
<div align = "right">
<small class = "text-secondary">${brdDetail.ip_address}</small>
</div>
<div class = "border">${brdDetail.content}</div>
</div>
</body>
</html>