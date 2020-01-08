<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="tag" tagdir="tags/" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>

</head>
<body>
    <%-- <jsp:include page="../components/login.jsp"></jsp:include> --%>


<div class="container">
<div class="col-lg-12" id = "loadPage">



      
</div>

</div>


</body>

<script type="text/javascript">

	$(function() {
		$("#loadPage").load("/board/list");
	})

</script>


</html>