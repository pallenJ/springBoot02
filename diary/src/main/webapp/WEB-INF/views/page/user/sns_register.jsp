<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../header.jsp"></jsp:include>
</head>
<body>
	<div class = "card">
	<fieldset>
		<legend id="login_leg" class="btn btn-lg btn-default text-default">회원가입</legend>

		<div id="" class="">
			<form action="components/register" method="post" id="reg_form">
				<div>
					<div class="form-group">
						<input type="hidden" class="form-control" id="reg_email" value="${reg_email}"
							name="email" aria-describedby="emailHelp"
							placeholder="Enter email" required="required"> 
					</div>

					<div class="form-group">
						<label for="exampleInputName" class="text-left">Nick Name</label>
						<input type="text" class="form-control form-inline" id="reg_name" value = "${reg_name}"
							placeholder="Enter name" name="name" required="required">
						<a id="nameCheck" class="btn btn-success text-white form-inline">유효성체크</a>
						<div class="invalid-feedback">사용할 수 없는 닉네임 입니다</div>
						<div class="valid-feedback">사용 가능한 닉네임 입니다</div>
					</div>


				</div>
				<div hidden="hidden">
					<button type="submit" id="reg_submit"></button>
				</div>
				<div>
					<input type = "hidden" value = "${sns_reg}" name = "sns_reg">
				</div>
				<div>
					<input type = "hidden" value = "NORMAL" name = "grade">
				</div>
				<div>
					<input type = "hidden" value = "0" name = "infoLock">
				</div>
			</form>

			<div align="right" class="modal-footer">
				<button type="button" class="btn btn-primary btn-modal-save"
					id="reg_submit_btn">register</button>
				<!-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button> -->
			</div>
		</div>

	</fieldset>
	</div>

	<script type="text/javascript">
		$(function() {
			alert("${sns_reg}")
			const name_regex = /[\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]/gi;
			$("#nameCheck").click(function() {
				var name = $("#reg_name").val();
				const nameEmpty = name == "";
				const nameExt = nameExist(name);
				const nameRegex = name_regex.test(name);

				if (nameEmpty) {
					$(".invalid-feedback").text("닉네임을 입력해주세요");
					isValid(false, $("#reg_name"));
				} else if (nameExt) {
					$(".invalid-feedback").text("이미 사용중인 닉네임 입니다");
					isValid(false, $("#reg_name"));
				} else if (nameRegex) {
					$(".invalid-feedback").text("특수문자는 사용할 수 없습니다");
					isValid(false, $("#reg_name"));
				} else {
					isValid(true, $("#reg_name"));
				}
			})
			function nameExist(name){
				var rs;
				$.ajax({  
				    type : "POST",  
				    url : "/components/nameExist",
				    async:false,
				    data : {name:name},  
				    dataType : "json",  
				    success : function(data){  
						rs = data;
				    	
				    },  
				    error:function(xhr,status,error){ //ajax 오류인경우  
				            alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);                 
				    }  
				}); 
				return rs;
			}
			$("#reg_submit_btn").click(function() {

				var name = $("#reg_name").val();
				if (name == "" || nameExist(name)|| name_regex.test(name)) {
					alert("닉네임을 확인해 주세요");
					$("#nameCheck").click();
					return;
				}
				$("#reg_submit").click();
				})

		
			function isValid(flag, selector) {
				if (flag) {
					selector.removeClass("is-invalid")
					selector.addClass("is-valid")
				} else {
					selector.removeClass("is-valid")
					selector.addClass("is-invalid")
				}
			}
		
		});
	</script>

</body>
</html>