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
      <input type="email" class="form-control" id="reg_email" aria-describedby="emailHelp" placeholder="Enter email">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    
    <div class="form-group">
      <label for="exampleInputName" class = "text-left">Email address</label>
      <input type="email" class="form-control" id="reg_email" aria-describedby="emailHelp" placeholder="Enter email">
    </div>
    
    
    <div class="form-group">
      <label for="exampleInputPassword1" class = "text-left">Password</label>
      <input type="password" class="form-control" id="reg_pw" placeholder="Password" name = "password_before">
      <input type="hidden" name = "password" id="pw_param">
    </div>
	</div>
</form>  

   
<div align="right" class = "modal-footer">
        <button type="button" class="btn btn-primary btn-modal-save" id= "reg_submit">register</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
</div>
</div>

  </fieldset>
      
 <script type="text/javascript">
$(function() {
	$("#reg_submit").click(function() {
		var shapw = CryptoJS.SHA256($("#reg_pw").val()).toString();
		$("#pw_param").val(shapw);
		alert("pw:"+$("#pw_param").val());
		$("#reg_form").submit();
		
	})
})
 </script>     
      