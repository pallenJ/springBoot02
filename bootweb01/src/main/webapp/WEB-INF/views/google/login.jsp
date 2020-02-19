<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="134117933681-ek6lqck2fumttlnokvio4o6q8kd81866.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js">
</script>
<script src="https://apis.google.com/js/platform.js?onload=init" ></script>
<title>Insert title here</title>
<jsp:include page="../include/header.jsp"></jsp:include>
<script type="text/javascript">
$(function () {
	
$("#showBtn").click(function() {
	
	
	if($(this).text()==="로그아웃")	{
	alert("로그아웃")
	$("#myModal").modal("hide");  
 	var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
    auth2.disconnect();
    $(this).text("로그인");
    
    return ;
	}
	    
	$("#myModal").modal();  
	
})
})

function onSignIn(googleUser) {
	$("#myModal").modal("hide");  

	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  
	  $("#showBtn").text("로그아웃")
	  $("input[name=email]").val(profile.getEmail())
	  $("input[name=name]").val(profile.getName())
	  	$("#myModal").modal("hide");  
 	var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
    auth2.disconnect();
	 $("#login_form").submit()
	  
	}

</script>
<script>


</script>
</head>
<body>
<div align="center">
<h3>Google Login</h3>
<a id = "showBtn" class = "btn btn-outline-danger">로그인</a>
</div>

<form method="post" action="login" id = "login_form">
<input type="hidden" name = "email" value="aaa">
<input type="hidden" name = "name" value="bbb">
</form>

<div class="modal fade" id="myModal">
	<div class="modal-dialog" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<a class="g-signin2 btn" data-onsuccess="onSignIn"></a>
			</div>
			<div class="modal-footer">
				
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


</body>
</html>

