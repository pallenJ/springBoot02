<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="134117933681-ek6lqck2fumttlnokvio4o6q8kd81866.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer>



</script>
<script type="text/javascript">

function onSignIn(googleUser) {
	alert("Aaa")
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	}

</script>
<title>Insert title here</title>
<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
<div align="center">
<h3>Google Login</h3>
<div class="g-signin2 btn" data-onsuccess="onSignIn"></div>
</div>
</body>
</html>

