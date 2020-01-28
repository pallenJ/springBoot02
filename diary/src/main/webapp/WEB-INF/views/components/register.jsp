<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="134117933681-b7itj3i408ntkkfpofkjp5chl72v0322.apps.googleusercontent.com"> -->
  <fieldset>
  <legend id = "login_leg" class = "btn btn-lg btn-default text-default">회원가입</legend>

  <div id = "" class = "">
<form action="components/register" method="post" id = "reg_form">
	<div>
    <div class="form-group">
      <label for="exampleInputEmail1" class = "text-left">Email address</label>
      <input type="email" class="form-control" id="reg_email" name = "email" aria-describedby="emailHelp" placeholder="Enter email" required="required">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    
    <div class="form-group">
      <label for="exampleInputName" class = "text-left">Name</label>
      <input type="text" class="form-control" id="reg_name" placeholder="Enter name" name = "name" required="required">
    </div>
    
    
    <div class="form-group">
      <label for="exampleInputPassword1" class = "text-left">Password</label>
      <input type="password" class="form-control" id="reg_pw" placeholder="Password" name = "password_before" required="required">
      <input type="hidden" name = "password" id="pw_param">
    </div>
	</div>
	<div hidden="hidden">
		<button type="submit" id="reg_submit"></button>
	</div>
	
</form>  

   
<div align="right" class = "modal-footer">
        <button type="button" class="btn btn-primary btn-modal-save" id= "reg_submit_btn">register</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
</div>
</div>

  </fieldset>
      
 <script type="text/javascript">
	const pw_regex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;	
$(function() {
	$("#reg_submit_btn").click(function() {
		
		var email = $("#reg_email").val();
		var pw = $("#reg_pw").val();
		var name = $("#reg_name").val();
		if(emailExist(email)){
			alert("이미 사용중인 이메일 입니다.");
			return;
		}else if(name==""){
			alert("이름을 입력해 주세요");
			return;
		}else if(!pw_regex.test(pw)){
			alert("비밀번호는 8자리이상 20자리이하의 영문,숫자,특수문자가 포함된 문자열이어야 합니다.")
			return;
		}else if(nameExist(name)){
			alert("이미 사용중인 닉네임 입니다")
			return;
		}
		var shapw = CryptoJS.SHA256(pw).toString();
		$("#pw_param").val(shapw);
		//$("#reg_form").submit();
		$("#reg_submit").click();
	})
	
	function emailExist(email) {
		var rs;
		$.ajax({  
		    type : "POST",  
		    url : "/components/userExist",
		    async:false,
		    data : {email:email},  
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
	
	
});



 </script>     
      