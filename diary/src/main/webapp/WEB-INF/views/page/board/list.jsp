<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <div class="panel panel-default">
  <div class="panel-header h4 text-dark border" align="center">board</div>
  <div class="panel-body bg-secondary" id ="brdList">Panel Content</div>
  
  
<div class="panel-footer">
  
<!-- paging -->



<div align="center">
  <ul class="pagination">
    <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <li class="page-item active">
      <a class="page-link" href="">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="">2</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="">3</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="">4</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="">5</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="">&raquo;</a>
    </li>
  </ul>
</div>
<!-- .paging -->

<script type="text/javascript">
		
	$(function() {
		const path = $(location).attr('pathname');
		$(".page-link").each(function() {
			$(this).prop("href", path+"?pg="+$(this).text());
		})
	})
</script>


</div>
</div>