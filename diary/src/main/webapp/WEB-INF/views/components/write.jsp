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
								[ 'insert', [ 'link', 'hr' ] ],
								[ 'view', [ 'fullscreen', 'codeview' ] ],
								[ 'help', [ 'help' ] ] ],
						height : 300,
						lang : 'ko-KR', // 언어 세팅
						callbacks: {
					          onImageUpload: function(files, editor, welEditable) {
					        	  //alert(editor);
					          	//sendFile(files[0], editor, welEditable);
					            for (var i = files.length - 1; i >= 0; i--) {
					              console.log(files[i]);
					             // alert("파일 첨부는 불가능 합니다.");
					            }
					            
					            
					          }
						}
					});
			
			function sendFile(file, editor, welEditable) {
				
				var form_data = new FormData();
				form_data.append("file", files)
				$.ajax({  
				    type : "POST",  
				    url : "/uploadFile",
				    async:false,
				    data : {file:file},  
			        contentType: false,
			        enctype: 'multipart/form-data',
			        processData: false,
				    success : function(data){  
				    	 //$(el).summernote('editor.insertImage', url);
				          //$('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
						editor.insertImage(data)
				    },  
				    error:function(xhr,status,error){ //ajax 오류인경우  
				            alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);                 
				    }  
				}); 
			}
			
			
			$("#board-submit").click(function() {
				//alert($("#content_div").summernote("code"))
				$("#for_form_submit").click();
			});

		});
	</script>