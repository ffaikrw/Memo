<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 보기</title>

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
				<h1 class="text-center font-weight-bold">메모 상세</h1>
				
				<div class="d-flex justify-content-center mt-3">
					<label class="mr-3 font-weight-bold">제목: </label>
					<input type="text" id="subjectInput" class="form-control col-11" value="${ post.subject }">
				</div>
				
				<textarea id="contentInput" class="form-control mt-3" rows="5">${ post.content }</textarea>
				
				<div class="d-flex justify-content-between mt-3">
					<div class="d-flex">
						<a href="/post/list_view" class="btn btn-light">목록으로</a>
						<button type="button" id="deleteBtn" class="btn btn-danger ml-3">삭제</button>
					</div>
					<button type="button" id="saveBtn" class="btn btn-dark">수정</button>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	
	</div>

</body>
</html>