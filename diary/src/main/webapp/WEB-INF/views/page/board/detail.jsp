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

<c:if test="${brdDetail.state eq 'UPDATED'}"><a href="${bno}/history">수정내역</a></c:if>

<div align = "right">

<small class = "text-secondary">${brdDetail.ip_address}</small>
</div>

	<div class = "border panel">
	<div  class = "panel-head border-primary bg-primary">content</div>
	<div  class = "panel-head" align="right">
	<c:if test="${brdDetail.user.email eq sessionScope.loginUser.email}">
		<a data-toggle="tooltip" title="edit" class = "btn" href="${brdDetail.bno}/edit">
		<span class="fa fa-edit btn-outline-primary"></span>
		</a>
		
		<a data-toggle="tooltip" title="delete" class = "btn" id= "deleteBtn">
		<span class="fa fa-trash btn-outline-danger"></span>
		</a>
	</c:if>
		
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
	
	$("#deleteBtn").click(function() {
		if(!confirm("정말 삭제하시겠습니까?")) return;
		$.ajax({
			url : "/board/delete/${brdDetail.bno}",
			type : 'POST',
			async : false,
			success : function(){
				alert("삭제되었습니다")
				location.href = "/board/list?pg=${pg}&kwd=${kwd}";
			}
		});
	})
})

</script>

</html>