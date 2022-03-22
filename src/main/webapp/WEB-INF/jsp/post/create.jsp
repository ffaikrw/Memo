<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 입력</title>

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
		
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="d-flex justify-content-center">
			<div class="w-75 my-5">
				<h1 class="text-center font-weight-bold">메모 입력</h1>
				
				<div class="d-flex justify-content-center mt-3">
					<label class="mr-3 font-weight-bold">제목: </label>
					<input type="text" id="subjectInput" class="form-control col-11">
				</div>
				
				<textarea id="contentInput" class="form-control mt-3" rows="5"></textarea>
				
				<input type="file" class="mt-3" id="fileInput">
				
				<div class="d-flex justify-content-between mt-3">
					<a href="/post/list_view" class="btn btn-light">목록으로</a>
					<button type="button" id="saveBtn" class="btn btn-dark">저장</button>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	
	</div>
	
	
	<script>
	
		$(document).ready(function(){
			
			$("#saveBtn").on("click", function(){
				
				let title = $("#subjectInput").val();
				let content = $("#contentInput").val().trim();
				
				if (title == "") {
					alert("제목을 입력하세요.");
					return;
				}
				
				if (content == "") {
					alert("내용을 입력하세요.");
					return;
				}
				
				var formData = new FormData();
				formData.append("subject", title);
				formData.append("content", content);
				formData.append("file", $("#fileInput")[0].files[0]);
				
				$.ajax({
					
					type:"post",
					url:"/post/create",
					data:formData,
					// 파일업로드 필수 옵션 - enctype, processData, contentType
					enctype:"multipart/form-data",
					processData:false,
					contentType:false,
					success:function(data){
						if (data.result == "success") {
							location.href="/post/list_view";
						} else {
							alert("입력 실패");
						}
					},
					error:function(){
						alert("메모 입력 통신 에러");
					}
					
				});
				
				
			});
			
		});
	
	</script>
		
</body>
</html>