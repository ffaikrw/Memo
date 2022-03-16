<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!-- bootstrap CDN link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!-- stylesheet -->
<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>

	<div id="wrap">
	
		<header class="d-flex align-items-center">
			<h1 class="ml-3">Memo</h1>
		</header>
		
		<section class="d-flex justify-content-center">
			<div class="join-box my-5 h-100">
				
				<h1 class="text-center mb-5">회원가입</h1>
				
				<!-- 아이디, 비밀번호, 비밀번호 확인, 이름, 이메일 -->
				
				<input type="text" id="loginId" class="form-control" placeholder="아이디">
				<input type="password" id="password" class="form-control mt-3" placeholder="비밀번호">
				<input type="password" id="passwordConfirm" class="form-control mt-3" placeholder="비밀번호 확인">
				<input type="text" id="name" class="form-control mt-3" placeholder="이름">
				<input type="text" id="email" class="form-control mt-3" placeholder="이메일">
				
				<button id="joinBtn" class="btn btn-primary btn-block mt-4">회원가입</button>
				
			</div>
		</section>
		
		<footer class="d-flex justify-content-center align-items-center">
			Copyright 2022. Memo all rights reserved.
		</footer>
	
	</div>
	
	
	<script>
		
		$(document).ready(function(){
			
			$("#joinBtn").on("click", function(){
				
				let loginId = $("#loginId").val().trim();
				let password = $("#password").val().trim();
				let passwordConfirm = $("#passwordConfirm").val().trim();
				let name = $("#name").val().trim();
				let email = $("#email").val().trim();
				
				// 유효성 확인
				if (loginId == "") {
					alert("아이디를 입력하세요.");
					return;
				}
				
				if (password == "") {
					alert("비밀번호를 입력하세요.");
					return;
				}
				
				if (password != passwordConfirm) {
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				
				if (name == "") {
					alert("이름을 입력하세요.");
					return;
				}
				
				if (email == "") {
					alert("이메일을 입력하세요.");
					return;
				}
				
				
				$.ajax({
					
					type:"post",
					url:"/user/sign_up",
					data:{"loginId":loginId, "password":password, "name":name, "email":email},
					success: function(data){
						
						if(data.result == "success") {
							alert("회원가입 성공");
						} else {
							alert("회원가입 실패");
						}
						
					},
					error: function(){
						alert("회원가입 통신 에러");
					}
					
				});
				
				
			});
			
		});
	
	</script>
	
	
</body>
</html>











