<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
  <div class="panel panel-default">
  <div class="panel-header h4 text-dark border" align="center">board</div>
  <div class="panel-body" id ="">
  	<div align="center">
 	 <div align="right" class="col-sm-6">
		<a href="/board/${bno}" class ="btn btn-success btn-sm border text-white"> 
		<span  class="fa fa-file">  원래글로</span>
    	</a>
	</div>
  	<table class = "table table-hover col-sm-6" id = "hisList">


	<tbody>
		<c:forEach items="${hisList}" var ="brdItem">
			<tr class = "brdItem">
				
				<td class = "hbno" role = "${brdItem.hbno}">${brdItem.bno}</td>
				<td>${brdItem.title}
				</td>
				<td>${brdItem.user.name}</td>
				<td class = "reg_date">${brdItem.update_date}</td>
			
			</tr>
		</c:forEach>
	
	</tbody>
	
	<thead>
		<tr>
			<th> no 		
			<th> title 		
			<th> writer		
			<th> date 		
		
		</tr>
	</thead>

</table>
  	</div>
  
  </div>
  
  
<div class="panel-footer">
  
<!-- paging -->



<div align="center">
  <ul class="pagination">
  
  	<c:if test="${paging.hasPrev}">
  	<li class="page-item">
      <a class="page-link page-prev" href="${paging.startShow-1}">&laquo;</a>
    </li>
  	</c:if>
  
  	<c:forEach var="i" begin="${paging.startShow}" end="${paging.endShow}">
  	
    <li class="page-item">
      <a class="page-link page-num" href="${i}">${i}</a>
    </li>
  	</c:forEach>
	<c:if test="${paging.hasNext}">
    <li class="page-item">
      <a class="page-link page-next" href="${paging.endShow+1}">&raquo;</a>
    </li>
    </c:if>
  </ul>
</div>

<!-- .paging -->
</div>
</div>
</body>
<script type="text/javascript">
		
	$(function() {
		const path = $(location).attr('pathname');
		const user = "${sessionScope.loginUser}";
		var pg = <%=request.getParameter("pg")%>;
		if(pg==null) pg =1;
		$(".page-link").each(function() {
			var pageValue = $(this).text();
			$(this).prop("href", path+"?pg="+$(this).attr("href"));
						
			
			if(pageValue.toString() === pg.toString()){
				$(this).parents("li").addClass("active");
			}
		});
		
		$(".brdItem").click(function() {
			const hbno = $(this).children(".hbno").attr("role");
			location.href = "/board/${bno}/history/"+hbno;
		})
		

	})
</script>



