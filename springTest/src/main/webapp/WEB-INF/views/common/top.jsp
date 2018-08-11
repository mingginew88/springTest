<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--script -->
<!--===============================================================================================-->	
<script src="/js/jquery-1.12.4.js"></script>
<!--===============================================================================================-->	
<script src="/bootstrap/js/bootstrap.js"></script>
<!--===============================================================================================-->
<script src="/SE2/js/HuskyEZCreator.js"></script>
<!--===============================================================================================-->	
<script src="/js/allScript.js"></script>
<!--===============================================================================================-->	

<!-- Bootstrap core CSS -->
<!--===============================================================================================-->	
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<!--===============================================================================================-->	
<link href="/css/signin.css" rel="stylesheet">
<!--===============================================================================================-->	
<link href="/css/dashboard.css" rel="stylesheet">
<!--===============================================================================================-->	
<link href="/css/blog.css" rel="stylesheet">

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/main/main">${sessionId}님 환영합니다</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Help</a></li>
					<li><a href="/login/logout">Logout</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>