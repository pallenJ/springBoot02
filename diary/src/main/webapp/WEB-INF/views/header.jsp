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
	<a href="#" data-toggle="modal" data-target="#components_modal" class = "modal-component" role = "login">로그인</a>|
	<a href="#" data-toggle="modal" data-target="#components_modal" class = "modal-component" role = "register">회원가입</a>

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