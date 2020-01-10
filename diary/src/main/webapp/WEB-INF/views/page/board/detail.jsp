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

<h1>${brdDetail.title}</h1>
<h3>${brdDetail.content}</h3>
<h3>${brdDetail.user.name}</h3>

</body>
</html>