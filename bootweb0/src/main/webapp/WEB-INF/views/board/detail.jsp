<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<!-- 글 보기 및 수정/삭제페이지 -->


<head>
<meta charset="UTF-8">
<%@include file="../include/header.jsp"%>
<!-- 부트 스트랩 테마 및 리소스, navbar -->
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>  -->
<script src="/resource/summernote/dist/lang/summernote-ko-KR.js"></script>
<script src="/resource/summernote/dist/summernote.js"></script>
<script src="/resource/summernote/dist/summernote.min.js"></script>
<link href="/resource/summernote/dist/summernote.css">
<!-- <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/codemirror.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/theme/monokai.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/codemirror.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/mode/xml/xml.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/2.36.0/formatting.js"></script> -->

<title>Board</title>
</head>
<body>

	<div id="hisSetting"></div>


	<!-- container -->
	<div class="container">
		<!-- card -->
		<div class="card">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="btn-group form-inline" role="group"
						aria-label="Basic example">
						<span class="form-group"> Board detail </span>


					</div>
					<small class="pull-right text-warning"> ip:<c:out
							value="${board.ip_address}"></c:out></small>
				</div>

				<c:if test="${board.state ne 'NORMAL' }">
					<button id = "editHis" class="btn btn-outline-info pull-right" data-toggle="modal"
						data-target="#historyModal">수정내역보기</button>
				</c:if>

				<!-- /.panel-heading -->


				<div class="panel-body">
					<!-- 게시물 수정시 사용되는 폼 -->
					<!-- register에서 추가와 수정을 함께 제어 -->
					<form action="/board/register" method="post" id="board_form">
						<!-- Bno -->
						<div class="form-group" id="bno_div" hidden="">
							<label>Bno</label> <input class="form-control" name="bno"
								value='<c:out value="${board.bno}"></c:out>' readonly="readonly">
						</div>
						<!-- /.Bno -->

						<!-- Title -->
						<div class="form-group">
							<label>Title</label> <input class="form-control" name="title"
								value='<c:out value="${board.title}"></c:out>'
								readonly="readonly" required />
						</div>
						<!-- /.Title -->

						<!-- content -->
						<div class="form-group">

							<div>
								<div id="content_include_div" class="card panel border">

									<div id="content_header_div"
										class="panel-head border-primary bg-primary">content</div>

									<a class='btn btn-default btn-sm text-info btn-preview'>preview</a>

									<div id="content_div"
										class="panel-body border-primary content-div container-fluid summernote-trs">
										<c:out value='${board.content}'></c:out>
									</div>

								</div>
							</div>
							<input type="hidden" name="content">
						</div>
						<!-- /.content -->
						<!-- wrier -->
					</form>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer}"></c:out>'
							readonly="readonly" required />
					</div>
					<!-- 글쓴이는 변경 불가 -->
					<!-- /.writer -->
					<!-- button들 -->
					<div id="detail-pg-btns"> 
					
						<!-- 그냥 볼때를 detail상태, 수정시 modify라고 구분. -->
						<!-- btn-for-detail은 detail상태에서만 보이는 버튼 -->
						<!-- btn-for-modify는 modify상태에서만 보이는 버튼 -->
						<!-- 둘다 없으면 항상 보이는 버튼 -->


						<!-- 수정버튼. detail상태에서 클릭시 비밀번호 입력 Modal이 뜸 -->
						<!-- 그리고 수정 상태에서 클릭시 수정여부 Modal이 뜸.-->
						<button data-oper="modify"
							class="btn btn-secondary btn-icon-split border" id="brd_modify">
							<span class="fa fas fa-edit active"></span> <span>Modify</span>
						</button>

						<!-- 게시판으로 돌아가는 버튼.  -->
						<button data-oper="list"
							class="btn btn-info btn-go btn-for-detail" title="list">
							<i class="fa fas fa-clipboard"></i> List
						</button>

						<!-- 새로운 글 쓰기 버튼 -->
						<button data-oper="register"
							class="btn btn-primary btn-for-detail btn-go" title="register">
							<i class="fa fas fa-pencil"></i> new Post
						</button>

						<!-- 삭제버튼. 실제 삭제는 아니고 삭제한 걸로 state를 바꿈 -->
						<button data-oper="remove"
							class="btn btn-danger btn-go btn-for-edit" title="remove"
							id="remove_brd_btn">
							<i class="fa fa-trash"></i> remove
						</button>

						<!-- 취소버튼 -->
						<button data-oper="cancel"
							class="btn btn-warning btn-go btn-for-edit" title="cancel"
							id="cancel_brd_btn">cancel</button>
						<div class="pull-right brd-date-info">
							<small>작성일자 : <c:out value="${board.regDate}"></c:out></small> <br>
							<small>최종수정일자 : <c:out value="${board.updateDate}"></c:out></small>

						</div>
					</div>
					<!-- 버튼 end -->

				</div>
				<!-- /.panel-body -->

			</div>
			<!-- /.panel -->


		</div>
		<!-- /.card -->
		<hr>
		<div class="card bg-primary">
			<div class="card-header text-white">
				<span class="fa fa-comment"> reply</span>

			</div>
			<div class="card-body">

				<table class="table">

					<thead>
						<tr>
							<td colspan="100%">
								<div class="form-inline">
									<textarea class="btn-block" id ="reply_add_area"></textarea>
									<button class="btn btn-success btn-md">add</button>
								</div> <!-- <td align="center" colspan="10%"> <button class = "btn btn-success btn-block">add</button> -->
					</thead>

				</table>

				<!-- 	<form class="form-inline">
			 
			</form> -->

			</div>
		</div>


	</div>
	<!-- /.container -->

</body>

<!-- 수정내역 Modal -->
<!-- Modal -->
<div class="modal fade" id="historyModal">
	<div class="modal-dialog modal-lg" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">수정내역</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div id="content_history" class="modal-body">
				<!-- modal history 페이지를 불러옴 -->
				<%-- <jsp:include page="detail_history.jsp"></jsp:include> --%>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- ./Modal -->

<script type="text/javascript">
	$(function() {

		if ("${board.state}" == "DELETED") {
			alert("삭제된 게시물 입니다")
			history.back();
		}

		$(".btn-preview").hide();
		/* 
		 $("#content_div").summernote({

		 "code":$("#content_div").val(),
		 "height": 300,
		 "display": "none",
		 });

		 $("#content_div").summernote('disable')

		 $(".note-toolbar").hide();

		 */

		$(".btn-for-edit").hide();

		//alert(content);
		//$("#content_div").html(content);
		$("#brd_modify").click(
				function() {

					$(".btn-preview").hide();
					var isDiv = ($("#content_div").prop("class"))
							.indexOf("content-div") > -1;
					if (isDiv) {
						$("#passwordModal").modal();
						//modifyActive();
					} else {
						//$("#board-form").submit();
						$("#modifyModal").modal();

					}

					$("#passwordSubmit").click(
							function() {
								var bno = "${board.bno}";
								var insertPW = $("#modalPWCheck").val();
								
								 $.ajax({
									    url: 'pwCheck',
									    type: 'POST',
									    async: false,
									    dataType: 'json',
									    data: {bno:bno,pw:insertPW},
									    success: function(data){
									   		if(data){
									   			modifyActive();
									   		}else{

											$("#modalPWCheck").addClass(
													"is-invalid");
											return;}
									    }
									});
								
								
							})

							
					$(".btn-modal-save").click(
							function() {
								$("input[name='content']").prop("value",
										$('#content_div').summernote("code"));
								$("#board_form").submit();
							})

				});

		function modifyActive() {
			/* $("#content_div").prop("data-toggle", "modal")
			$("#content_div").prop("data-target", "#modifyModal") */
			$("input[name!='writer']").prop("readonly", false);

			$("#bno_div").hide();
			$(".brd-date-info").hide();
			$(".btn-for-detail").hide();
			$(".btn-for-edit").show();

			$("#content_include_div").removeClass();
			$("#content_header_div").hide();

			$("#content_div").summernote(
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
						  codemirror: { // codemirror options
							    theme: 'monokai'
							  },
						//airMode: true,
						lang : 'ko-KR',
					});
			/* 
			$("#content_div").summernote("enable");
			$(".note-toolbar").show();
			 */
			$(".btn-preview").show();
			$("#passwordModal").modal("hide");

			$("#content_div").removeClass("content-div");

		}

		$(".btn-go").click(
				function() {
					var go_url = $(this).prop("title");
					if (go_url == (null || "" || "cancel")) {
						location.reload();

						return;
					} else if (go_url.indexOf("remove") > -1
							&& go_url.indexOf("remove?") == -1) {
						$("#removeModal").modal();
					} else {

						$(location).attr("href", $(this).prop("title"));
					}
				})

		$("#editHis").click(function() {
			//수정내역 불러오는 부분

			//간단한 버전
			$("#content_history").load("/board/editHistoryForm?bno=${bno}");

			//ajax버전
			/*  
			$.ajax({
			        url : '/board/editHistoryForm',
			        type : 'GET',
			        data : {'bno':'${bno}'},
			        datatype:'html',
			        success: function(data) {
			        	alert($(data));
			        	$("#content_history").html(data);
			  },
			  error: function(xhr, status, error){
			      alert("xhr:"+xhr+", status:"+ status + ", error:"+error);
			  }
			        
			 }); 
			 */

		});
		
		$("#reply_add_area").focus(function() {
			$(this).summernote({
				width:  "100%" ,
				lang : 'ko-KR'
			});
		})
		

	});
</script>

<footer>
	<%@include file="../include/footer.jsp"%>
</footer>

</html>