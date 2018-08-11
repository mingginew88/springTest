<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/css/Login_v3/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/css/util.css">
	<link rel="stylesheet" type="text/css" href="/css/Login_v3/css/main.css">
<!--===============================================================================================-->
	
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<!-- <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->

<!-- Custom styles for this template -->
<!-- <link href="/css/signin.css" rel="stylesheet">     -->
    
</head>

<body class="text-center">	

	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="post" action="/login/joinProcess">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Join Us
					</span>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter mem_Id">
						<input type="text" id="joinId" name="joinId" class="form-control" placeholder="아이디" required autofocus>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter mem_name">
						<input type="text" id="joinName"  name="joinName" class="form-control" placeholder="이름" required>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input type="password" id="joinPassword"  name="joinPassword" class="form-control" placeholder="비밀번호" required>
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter mem_email">
						<input type="text" id="joinEmail"  name="joinEmail" class="form-control" placeholder="이메일" required>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter mem_tel">
						<input type="text" id="joinTel"  name="joinTel" class="form-control" placeholder="전화번호" required>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter mem_addr1">
						<input type="text" id="joinAddr1"  name="joinAddr1" class="form-control" placeholder="주소" required>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter mem_addr2">
						<input type="text" id="joinAddr2"  name="joinAddr2" class="form-control" placeholder="상세주소" required>
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">
							가입하기
						</button>
					</div>
				</form>
				<br>
				<form  action="/login/view">
					<div class="container-login100-form-btn">
						<button  class="login100-form-btn" type="submit">Back</button>
					</div>
				</form>
			
				<div class="text-center p-t-90">
					<p>&copy; 2018-02 대덕인재개발원</p>
				</div>
				
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="/css/Login_v3/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/css/Login_v3/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/css/Login_v3/vendor/bootstrap/js/popper.js"></script>
	<script src="/css/Login_v3/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/css/Login_v3/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/css/Login_v3/vendor/daterangepicker/moment.min.js"></script>
	<script src="/css/Login_v3/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/css/Login_v3/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/css/Login_v3/js/main.js"></script>
	
</body>
</html>