<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${editHistory}" var = "board">

	<h2>작성일자 : <c:out value="${board.regDate}"></c:out></h2> <hr>
	<div class="row container">
		<div class="col-lg-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="btn-group form-inline" role="group" aria-label="Basic example">
					<span class="form-group">
						Board detail
					</span>

						
					</div>
						<small class = "pull-right text-black-50"> ip:<c:out value="${board.ip_address}"></c:out></small> 
				</div>
				
				<!-- /.panel-heading -->
				
			
				<div class="panel-body">
					<div class="form-group" id= "bno_div" hidden="">
						<label>Bno</label> <input class="form-control" name="bno"
							value='<c:out value="${board.bno}"></c:out>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value='<c:out value="${board.title}"></c:out>'
							readonly="readonly" required/>
					</div>
					<div class="form-group">

				<div>	
				<div class="card panel border">
				
				<div  class = "panel-head border-primary bg-primary">content</div>
				<div  class = "panel-body border-primary content-div container-fluid">${board.content}</div>
				
				</div></div>
				<input type="hidden" name = "content">
					</div>
				
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer}"></c:out>'
							readonly="readonly" required/>
					</div>
				

				</div>
				<!-- /.panel-body -->
				
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

</c:forEach>