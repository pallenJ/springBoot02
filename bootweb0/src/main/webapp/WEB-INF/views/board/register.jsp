<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>

<!-- <script type="text/javascript" src="/resource/js/util.js"></script> -->
<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
<!-- include summernote-ko-KR -->
<!-- <script src="lang/summernote-ko-KR.js"></script> -->
</head>
<body>
	<%-- <h1>${bno}</h1> --%>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="btn-group" role="group" aria-label="Basic example">
						new</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<form action="/board/register" method="post" id="board-form">


						<div class="form-group">
							<label>Title</label> <input class="form-control brd-item"
								name="title" required="required">
						</div>
						<div class="form-group">
							<a class='btn btn-default btn-sm text-info btn-preview'>preview</a>
							<textarea id="content_div" class="brd-item" name="content"></textarea>
							<div></div>
						</div>

						<div class="form-group">
							<label>Writer</label> <input class="form-control brd-item"
								name="writer" required="required">
						</div>

						<jsp:include page="forms/pw_form.jsp"></jsp:include>
						<button hidden="hidden" id="for_form_submit"></button>
					</form>
					<button data-oper="new" class="btn btn-primary" id="board-submit">submit</button>
					<button data-oper="list" class="btn btn-danger"
						onclick="history.back();">cancel</button>
					<%-- 				<form id = "operForm" action="/board/modify" method="get">
					<input type="hidden" id = "bno" name ="bno" value ='<c:out value="${board.bno}"></c:out>'>
					<input type="hidden" id = "pageNum" name ="pageNum" value ='<c:out value="${param.pageNum}"></c:out>'>
					<input type="hidden" id = "amount" name ="amount" value ='<c:out value="${param.amount}"></c:out>'>
					<input type="hidden" id = "type" name ="type" value ='<c:out value="${param.type}"></c:out>'>
					<input type="hidden" id = "keyword" name ="keyword" value ='<c:out value="${param.keyword}"></c:out>'>
				</form>
 --%>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

	<script type="text/javascript">
		$(function() {
			$('#content_div').summernote(
					{
						toolbar : [
								[ 'style', [ 'style' ] ],
								[
										'font',
										[ 'bold', 'italic', 'underline',
												'clear' ] ],
								[ 'fontname', [ 'fontname' ] ],
								[ 'color', [ 'color' ] ],
								[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
								[ 'height', [ 'height' ] ],
								[ 'table', [ 'table' ] ],
								[ 'insert', [ 'link', 'picture', 'hr' ] ],
								[ 'view', [ 'fullscreen', 'codeview' ] ],
								[ 'help', [ 'help' ] ] ],
						height : 300,
						lang : 'ko-KR', // 언어 세팅
					});

			$("#board-submit").click(function() {
				if($(".pw-form-custom").hasClass("is-valid")){
				$("#for_form_submit").click();
				}
			});

		});
	</script>


</body>
<footer>
	<%@include file="../include/footer.jsp"%>
</footer>
</html>