<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>

<div class = "container border">
<h1>title : ${brdDetail.title}</h1>
<h5>writer :  ${brdDetail.user.name}</h5>
<div align = "right">
<small class = "text-secondary">${brdDetail.ip_address}</small>
</div>

	<div class = "border panel">
	<div  class = "panel-head border-primary bg-primary">content</div>
	<div  class = "panel-head" align="right">
	<c:if test="${brdDetail.user.email eq sessionScope.loginUser.email}">
		<a data-toggle="tooltip" title="edit" class = "btn"><span class="fa fa-edit btn-outline-primary"></span></a>
		<a data-toggle="tooltip" title="delete" class = "btn"><span class="fa fa-trash btn-outline-danger"></span></a>
	</c:if>
		
		<a data-toggle="tooltip" title="share" class = "btn" id = "shareURL"><span class="fa fa-share"></span></a>
	
	</div>
	<div  class = "panel-body border-primary content-div container-fluid">
	${brdDetail.content}
	</div>
		
	</div>

</div>

</body>


<script type="text/javascript">

$(function() {
	
	const href = $(location).attr('href');
	
	$("#shareURL").click(function() {
		$("#nowURL").val(href);
		$("#URLModal").modal();
	})
	
	$("#shareAction").click(function(){
		$("#nowURL").select();
		document.execCommand("Copy");
		$("#nowURL").blur();
	})
})

</script>

</html>