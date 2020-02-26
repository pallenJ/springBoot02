<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="btn-group" role="group" aria-label="Basic example">
						new</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<form action="" method="post" id="board-form">
						

						<div class="form-group">
							<label>Title</label> <input class="form-control brd-item"
								name="title" required="required" value="${boardDetail.title}" id = "brdTitle">
								
						</div>
						<div class="form-group">
							<a class='btn btn-default btn-sm text-info btn-preview'>preview</a>
							<textarea id="content_div" class="brd-item" name="content">
								</textarea>
							<div></div>
						</div>

<!-- 						<div class="form-group">
							<label>Writer</label> <input class="form-control brd-item"
								name="writer" required="required">
						</div> -->

						
						<button hidden="hidden" id="for_form_submit"></button>
					</form>
					<button data-oper="new" class="btn btn-primary" id="board-submit">submit</button>
					<button data-oper="list" class="btn btn-danger"
						onclick="history.back();">cancel</button>
					<%-- 				<form id = "operForm" action="/board/modify" method="get">
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
				//alert($("#content_div").summernote("code"))
				$("#for_form_submit").click();
			});

		});
	</script>