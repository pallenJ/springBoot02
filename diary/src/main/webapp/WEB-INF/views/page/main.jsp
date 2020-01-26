<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="tag" tagdir="tags/" %> --%>
<%-- <jsp:forward page="/board/list"></jsp:forward> --%>
<%

	String path = "/board/list";
	Object pg   = request.getAttribute("pg");
	if(pg!=null){
		path += (String)pg;
	}
	pageContext.forward(path);
%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>

</head>
<body>
    <jsp:include page="../components/login.jsp"></jsp:include>


<div class="container">
<div class="col-lg-12" id = "loadPage">



      
</div>

</div>


</body>

<script type="text/javascript">

	$(function() {
		const pg = <%=request.getParameter("pg")%>;
		const search = <%=request.getParameter("search")%>;
		var searchKeyword = "";
		
		$("#loadPage").load("/board/list?pg="+pg+"&search="+(search!=null));
	})

</script>


</html> --%>