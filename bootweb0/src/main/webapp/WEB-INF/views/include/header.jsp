<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	pageContext.setAttribute("tcnt", session.getAttribute("theme_num"));

	String[] themes = new String[]{"cerulean", "cosmo", "cyborg", "darkly", "flatly", "journal", "litera",
			"lumen", "lux", "materia", "minty", "pulse", "sandstone", "simplex", "sketchy", "slate", "solar",
			"spacelab", "superhero", "united", "yeti"};
	pageContext.setAttribute("themes", themes);
	
	String designTheme = ""; 
	if(session.getAttribute("designTheme")!=null&&!session.getAttribute("designTheme").toString().equals("")){
		designTheme= session.getAttribute("designTheme").toString();
	}else {
		designTheme = themes[new Random().nextInt(themes.length)];
		session.setAttribute("designTheme", designTheme);
	}
	pageContext.setAttribute("theme", designTheme);//21개 테마
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script type="text/javascript">
	//alert("${theme}")
</script>
<div id="tm-change"></div>

<link rel="stylesheet" id="b-css"
	href="https://bootswatch.com/4/${theme}/bootstrap.css">
<link rel="stylesheet" id="b-min-css"
	href="https://bootswatch.com/4/${theme}/bootstrap.min.css">
<link rel="stylesheet" id="v-scss"
	href="https://bootswatch.com/4/${theme}/_variables.scss"> 
<link rel="stylesheet" id="b-scss"
	href="https://bootswatch.com/4/${theme}/_bootswatch.scss">
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

	<div class="collapse navbar-collapse" id="navbar">
	
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/">Home
					<span class="sr-only">(current)</span>
			</a></li>
<!-- 			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="user_menu"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 유저 메뉴 </a>
				<div class="dropdown-menu" aria-labelledby="user_menu">
					<div class="">
						<a class="dropdown-item btn cus-dropdown" href="#"
							data-toggle="modal" data-target="#loginModal" id="login_a">로그인</a>


					</div>
				</div></li> -->

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="admin_menu"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 관리자 메뉴 </a>
				<div class="dropdown-menu" aria-labelledby="admin_menu">
					<div class="">
						<span class="dropdown-item btn bg-primary text-white active">게시글
						</span>
					</div>
					<div class="text-secondary">
						<a class="dropdown-item btn cus-dropdown"
							href="/board/admin/deletedList">삭제 게시글</a> <a
							class="dropdown-item btn cus-dropdown"
							href="/board/admin/updatedList">수정 게시글</a> <a
							class="dropdown-item btn cus-dropdown"
							href="/board/admin/normalList">일반 게시글</a>
					</div>

				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="design_themes"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 테마 </a>
				<div class="dropdown-menu" aria-labelledby="design_themes">
					<span class="dropdown-item btn bg-dark text-white active">bootswatch
						themes </span>
					<c:forEach items="${themes}" var="btheme">
						<a class="dropdown-item btn theme-options" title="${btheme}"
							role="${btheme}">${btheme}</a>
					</c:forEach>
				</div>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
		</ul>




		<form class="form-inline my-2 my-lg-0 navbar-right">
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>
<!--   <div id="page-wrapper">
  사이드바
  <div id="sidebar-wrapper" class="bg-primary">
    <ul class="sidebar-nav">
      <li class="sidebar-brand">
        <a href="#">Zeta</a>
      </li>
      <li><a href="#">메뉴 1</a></li>
      <li><a href="#">메뉴 2</a></li>
      <li><a href="#">메뉴 3</a></li>
      <li><a href="#">메뉴 4</a></li>
      <li><a href="#">메뉴 5</a></li>
      <li><a href="#">메뉴 6</a></li>
      <li><a href="#">메뉴 7</a></li>
      <li><a href="#">메뉴 8</a></li>
      <li><a href="#">메뉴 9</a></li>
    </ul>
  </div></div>   -->
<style>
/* 사이드바 래퍼 스타일 */
#page-wrapper {
	padding-left: 250px;
}

#sidebar-wrapper {
	position: fixed;
	width: 250px;
	height: 100%;
	margin-left: -250px;
	overflow-x: hidden;
	overflow-y: auto;
}

#page-content-wrapper {
	width: 100%;
	padding: 20px;
}
/* 사이드바 스타일 */
.sidebar-nav {
	width: 250px;
	margin: 0;
	padding: 0;
	list-style: none;
}

.sidebar-nav li {
	text-indent: 1.5em;
	line-height: 2.8em;
}

.sidebar-nav li a {
	display: block;
	text-decoration: none;
	color: #999;
}

.sidebar-nav li a:hover {
	color: #fff;
}

.sidebar-nav>.sidebar-brand {
	font-size: 1.3em;
	line-height: 3em;
}
</style>


<script type="text/javascript">
	$(function() {
		if (("${sessionScope.designTheme}") == "minty") {
			forExceptTheme();
		}

		$(".theme-options").each(function(i, element) {
			if ($(this).text() == "${sessionScope.designTheme}") {
				$(this).addClass("active")
			}
		})

		$(".theme-options").click(
				function() {
					var d_theme = $(this).prop("title");
					$(".theme-options").each(function(i, element) {
						if ($(this).prop("class").indexOf("active") > -1) {
							$(this).removeClass("active");
						}

					})

					$(this).addClass("active");
					//$(this).addClass("text-white"); 
					$.ajax({
						type : "POST",
						url : "/thm_change",
						data : {
							"theme" : d_theme
						},
						dataType : "json",
						success : function(data) {
							//요청 작업을 성공적으로 수행 후 페이지에서 추가적으로 작업할 내용 입력     

						}
					});
					if (d_theme == "minty") {
						$(".cus-dropdown").addClass("text-primary")
						$(".cus-dropdown").hover(function() {
							$(this).removeClass("text-primary")
							$(this).addClass("text-default")

						}, function() {
							$(this).addClass("text-primary")
						})
					}
					$("#b-css").prop(
							"href",
							"https://bootswatch.com/4/" + d_theme
									+ "/bootstrap.css")
					$("#b-min-css").prop(
							"href",
							"https://bootswatch.com/4/" + d_theme
									+ "/bootstrap.min.css")
					$("#v-scss").prop(
							"href",
							"https://bootswatch.com/4/" + d_theme
									+ "/_variables.scss")
					$("#b-scss").prop(
							"href",
							"https://bootswatch.com/4/" + d_theme
									+ "/_bootswatch.scss")

				})
		$(".theme-options").hover(function() {
			$(this).toggleClass("text-default text-info")
		})

		function forExceptTheme() {
			$(".cus-dropdown").addClass("text-primary")
			$(".cus-dropdown").hover(function() {
				$(this).removeClass("text-primary")
				$(this).addClass("text-default")

			}, function() {
				$(this).addClass("text-primary")
			})
		}

	})
</script>
<!-- CDN -->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resource/css/bootstrap.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- summernote-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
<%
	try {
		session.setAttribute("nowTheme", pageContext.getAttribute("theme"));
	} catch (Exception e) {
		session.setAttribute("nowTheme", "minty");
	}
%>
<!-- 개인적으로 쓰는 리소스들 -->

<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> -->

<hr>