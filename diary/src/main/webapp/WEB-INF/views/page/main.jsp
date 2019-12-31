<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>

</head>
<body>
    <%-- <jsp:include page="../components/login.jsp"></jsp:include> --%>

	<div id="app">
  		{{ message }}
	</div>
	<div id="app-2">
  		<span v-bind:title="message">
    	내 위에 잠시 마우스를 올리면 동적으로 바인딩 된 title을 볼 수 있습니다!
  	</span>
	</div>



</body>
<script>
var app = new Vue({
	  el: '#app',
	  data: {
	    message: '안녕하세요 Vue!'
	  }
	})

var app2 = new Vue({
	  el: '#app-2',
	  data: {
	    message: '이 페이지는 ' + new Date() + ' 에 로드 되었습니다'
	  }
	})
</script>


</html>