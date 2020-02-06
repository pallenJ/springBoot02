<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<table class = "table table-hover" id = "brdList">

	<tbody>
		<c:forEach items="${brdList}" var ="brdItem">
			<tr class = "brdItem">
				<td class = "bno" role = "${brdItem.bno}">${brdItem.bno}</td>
				<td>${brdItem.title}
				<c:if test="${brdItem.state eq 'UPDATED'}">
				<small class = "btn-outline-danger disabled">(수정)</small></c:if>
				</td>
				<td>
				<a href="/userInfo/@${brdItem.user.name}">
				${brdItem.user.name}
				</a>
				
				</td>
				<td class = "reg_date">${brdItem.reg_date}</td>
			
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