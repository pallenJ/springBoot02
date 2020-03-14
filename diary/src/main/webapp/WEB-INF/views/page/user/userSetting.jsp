<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../header.jsp"></jsp:include>
</head>
<body>

<div class = "container" align="center">
<form action="/userInfo/@${userInfo.name}" method="post">
	<div class="card bg-default mb-3" style="max-width: 20rem;">
  		<div class="card-header">setting</div>
  		<div class="card-body">
		<p><input type="checkbox"> 내 정보 비공개</p>	
		<input type = "hidden" name = "infoLock" value = "0">
		<p><a class = "btn btn-success">닉네임(${userInfo.name}) 변경</a></p>	
		<p><a class = "btn btn-info">비밀번호 변경</a></p>	
  </div>
  		<div class = "card-footer">
		<button class = "btn btn-primary">저장</button>
		<button class = "btn btn-light">취소</button>
		</div>
</div>
</form>

</div>

</body>
<script type="text/javascript">
$(function () {
	const checkBox = $("p").children("input[type='checkbox']");
	alert("${userInfo.infoLock}")
	if("${userInfo.infoLock}" == "1")
		checkBox.prop("checked", true)
		
	checkBox.change(function() {
		
		$("input[name='infoLock']").val($(this).prop("checked")?"1":"0")
	})	
})



</script>

</html>