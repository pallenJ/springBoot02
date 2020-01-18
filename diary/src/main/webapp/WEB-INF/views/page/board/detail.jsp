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
		<a data-toggle="tooltip" title="edit" class = "btn"><i class="fa fa-edit"></i></a>
		<a data-toggle="tooltip" title="delete" class = "btn"><i class="fa fa-trash"></i></a>
		<a data-toggle="tooltip" title="share" class = "btn" id = "shareURL"><i class="fa fa-share"></i></a>
	
	</div>
	<div  class = "panel-body border-primary content-div container-fluid">
	${brdDetail.content}
	</div>
		
	</div>

</div>

</body>

<div class="modal fade" id="URLModal">
	<div class="modal-dialog" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">URL 공유</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				URL<input type="text" value = "" id = "nowURL" class = "form-control" readonly="readonly">
			</div>
			<div class="modal-footer">
				
				<button type="button" class="btn btn-primary" id = "shareAction">복사</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
			</div>
		</div>
	</div>
</div>
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