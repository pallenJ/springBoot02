<%@page import="com.pallen.diary.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	pageContext.setAttribute("tcnt", session.getAttribute("theme_num"));

	String[] themes = new String[] { "cerulean", "cosmo", "cyborg", "darkly", "flatly", "journal", "litera",
			"lumen", "lux", "materia", "minty", "pulse", "sandstone", "simplex", "sketchy", "slate", "solar",
			"spacelab", "superhero", "united", "yeti" };
	String designTheme = themes[0];
	pageContext.setAttribute("theme", designTheme);//21개 테마
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<link rel="stylesheet" id="b-css"
	href="https://bootswatch.com/4/${theme}/bootstrap.css">
<link rel="stylesheet" id="b-min-css"
	href="https://bootswatch.com/4/${theme}/bootstrap.min.css">
<link rel="stylesheet" id="v-scss"
	href="https://bootswatch.com/4/${theme}/_variables.scss">
<link rel="stylesheet" id="b-scss"
	href="https://bootswatch.com/4/${theme}/_bootswatch.scss">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<!-- CDN -->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resource/css/custom.css" />
<link rel="stylesheet" href="/resource/css/tabs/tabs.css" />
<link rel="stylesheet" href="/resource/css/tabs/tabs.sideways.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- summernote-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
<div class="pull-right">
<c:choose>
	<c:when test="${not empty sessionScope.loginUser}">
		<h4>
			<span class = "text-border">${sessionScope.loginUser.name}</span>
			님<br> 환영합니다
		</h4>
		<a href = "/components/logout">로그아웃</a>|<a href="">내정보</a>
	</c:when>
	<c:otherwise>
		<a href="#" data-toggle="modal" data-target="#components_modal" class = "modal-component" role = "login">로그인</a>|
		<a href="#" data-toggle="modal" data-target="#components_modal" class = "modal-component" role = "register">회원가입</a>
	
	</c:otherwise>
</c:choose>



</div>


<div class="modal fade" id="components_modal">
	<div class="modal-dialog" role="dialog"
		style="max-width: 100%; display: table;">
		<div class="modal-content">
			<div class="modal-header bg-secondary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div id="modal_form" class="modal-body">
			</div>

<!-- 			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div> -->
		</div>
	</div>
</div>
<script>
$(function() {
	$(".modal-component").click(function() {
		var role = $(this).attr("role");
		$("#modal_form").load("/components/"+role)

	})
})
</script>
 <script type="text/javascript" src="<c:url value='/resource/js/core.min.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/resource/js/sha256.min.js'/>"></script>
 <br>
 <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
<!--     <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
    </ul> -->
<!--     <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form> -->
  </div>
</nav>