<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<!-- <script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="134117933681-b7itj3i408ntkkfpofkjp5chl72v0322.apps.googleusercontent.com"> -->
  <fieldset>
  <legend id = "login_leg" class = "btn btn-lg btn-default text-default">로그인</legend>

  <div class = "form-group">
  <div align="center" id = "sns_form"> 
  		<!-- <div class="g-signin2" data-onsuccess="onSignIn"></div> -->
		<button  title="Google" class="btn btn-circle btn-google"><span class="fa fa-google fa-lg"></span> </button> &nbsp;
		<button  title="Naver" class="btn btn-circle btn-naver"><span class="fa fa-naver fa-lg font-weight-bold">N</span> </button> &nbsp;
		<button title="Facebook" class="btn btn-circle btn-facebook"><span class="fa fa-facebook fa-lg"></span> </button> &nbsp;
		<button  title="twitter" class="btn btn-circle btn-twitter"><span class = "fa fa-twitter fa-lg"></span></button> &nbsp;
		<button  title="GitHub" class="btn btn-circle btn-github"><span class="fa fa-github fa-lg"></span> </button> &nbsp;
		<button  title="email" class="btn btn-circle btn-secondary"><span class="fa fa-envelope fa-lg" id = "email_login"></span> </button> &nbsp;
	</div>
  </div>
  <div id = "email_form" class = "">
	<div>
    <div class="form-group">
      <label for="exampleInputEmail1">Email address</label>
      <input type="email" class="form-control" id="login_email" aria-describedby="emailHelp" placeholder="Enter email">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Password</label>
      <input type="password" class="form-control" id="login_pw" placeholder="Password">
    </div>
	</div>

   
<div align="right">
        <button type="button" class="btn btn-primary btn-modal-save" id= "login_submit">login</button>
</div>
</div>
<form >
</form>  

	<hr>


  </fieldset>
  <br>
<!--         <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div> -->
      
 <script type="text/javascript">
 $(function () {
		$("#email_form").hide();
		$("#sns_form").show();
	$("#login_leg").click(function() {
		$("#email_form").hide();
		$("#sns_form").show();
		$("#login_leg").text("로그인")
		$(this).removeClass("btn-info")
	})
	
	$("#email_login").click(function() {
		$("#sns_form").hide();
		$("#email_form").show();
		$("#login_leg").text("sns로 로그인")
		$("#login_leg").addClass("btn-info")
	})
	
	
})
 
 </script>     
      