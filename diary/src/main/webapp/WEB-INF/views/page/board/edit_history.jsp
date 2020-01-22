<%@page import="com.pallen.diary.entity.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
Board brdDetail = (Board)pageContext.getAttribute("brdDetail");
%>    
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
	
		<a data-toggle="tooltip" title="share" class = "btn" id = "shareURL"><span class="fa fa-share"></span></a>
	
	</div>
	<div  class = "panel-body border-primary content-div container-fluid">
	${brdDetail.content}
	</div>
	<div class = "panel-footer">
		<small class = "text-info">${brdDetail.reg_date} 작성</small><br>
		<small class = "text-info">
		<c:if test="${brdDetail.state eq 'UPDATED'}">${brdDetail.update_date} 수정</c:if>
		</small>
		</div>
		<a href="/board/${bno}/history" class="btn btn-outline-info">수정내역으로</a>
		<a href="/board/${bno}" class="btn btn-outline-warning">원글로</a>
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