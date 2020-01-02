<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="134117933681-b7itj3i408ntkkfpofkjp5chl72v0322.apps.googleusercontent.com"> -->
  <fieldset>
  <legend id = "login_leg" class = "btn btn-lg btn-default text-default">로그인</legend>

<form action="/components/login" method="post" id = "login_form">
	<div>
    <div class="form-group">
      <label for="exampleInputEmail1" class = "text-left">Email address</label>
      <input type="email" class="form-control" id="login_email" aria-describedby="emailHelp" placeholder="Enter email" name= "email" required>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1" class = "text-left">Password</label>
      <input type="password" class="form-control" id="login_pw" placeholder="Password" name = "password_before" required>
      <input type="hidden" name = "password" id="pw_param">
    </div>
	</div>
   	<div hidden="hidden">
   		<button type="submit" id = "login_submit"></button>
   	</div>
</form>  
<div align="right" class = "modal-footer">
        <button type="button" class="btn btn-primary btn-modal-save" id= "login_submit_btn">login</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
</div>



  </fieldset>

 <script type="text/javascript">
	$(function() {
		$("#login_submit_btn").click(function() {
			var shapw = CryptoJS.SHA256($("#login_pw").val()).toString();
			$("#pw_param").val(shapw);
			alert("pw:"+$("#pw_param").val());
			$("#login_submit").click();
		})
	})
 </script>     
      