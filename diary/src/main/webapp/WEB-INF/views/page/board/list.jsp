<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <div class="panel panel-default">
  <div class="panel-header h4 text-dark border" align="center">board</div>
  <div class="panel-body" id ="brdList">
 	 <div align="right">
		<a id = "new_post" class ="btn btn-success btn-sm border text-white"> 
		<span  class="fa fa-pencil">  new post</span>
    	</a>
	</div>
  	
  	<table class = "table table-hover" id = "brdList">


	<tbody>
		<c:forEach items="${brdList}" var ="brdItem">
			<tr class = "brdItem">
				<td class = "bno" role = "${brdItem.bno}">${brdItem.bno}
				<td>${brdItem.title}
				<td>${brdItem.user.name}
				<td class = "reg_date">${brdItem.reg_date}
			
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
			const bno = $(this).children(".bno").attr("role");
			alert("/board/"+bno);
			location.href = "/board/"+bno;
		})
		
 		$("#new_post").click(function() {
			if(user == null||user ==""){
				alert("로그인후 이용해주세요")
				return;
			}
			location.href = "/board/new";
		})

	})
</script>


</div>
</div>