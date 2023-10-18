<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<!-- bootstrap CDN link -->
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 	<!--  AJAX를 사용하려면 반드시 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarkList}" var="bookmark">
				<tr>
					<td>${bookmark.id}</td>
					<td>${bookmark.name}</td>
					<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td>
					<td>
						<%-- 1) value 속성을 이용해서 값 세팅 --%>
						<%-- <button type="button" class="del-btn btn btn-danger"  value="${bookmark.id}">삭제</button> --%>
						
						<%-- data를 이용해서 태그에 값 세팅 : 대문자X ; data-내가지정한속성 --%>
						<button type="button" class="del-btn btn btn-danger"  data-bookmark-id="${bookmark.id}" data-bookmark-url="${bookmark.url}">삭제</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

<script>
	$(document).ready(function() {
		// 삭제 버튼 클릭
		$('.del-btn').on('click', function(e) {
			// $('.del-btn')은 전체를 가져옴
			// 현재 내가 누른 버튼을 가져오려면 this이용
			
			// ----- value -----
			// value는 하나만 지정 가능
			// 1) value - jquery문법
			// let id = $(this).val(); 
			
			// 2) value - e
			// e : 지금 클릭된 객체를 알고있음(+다양한 정보 가지고 있음)
			// let id = e.target.value;
			
			
			// ----- data -----
			// data-내가지정한속성 => data("내가지정한속성") 함수 사용
			// data-bookmark-id => data("bookmark-id")
			let id = $(this).data('bookmark-id');
			// alert(id);
			
			
			$.ajax({
				
				// request
				// form일 때는 delete안됨 ajax일때만 가능
				type:"delete"
				, url:"/lesson06/quiz02/delete-bookmark"
				, data:{"id":id}
				
				
				// response
				,success:function(data) {
					if (data.code == 200) { // or data.result == "성공"
						// 새로고침(스크롤은 움직이지 않으면서)
						location.reload(); // or location.reload(true);
					} else {	// 오류는 나지 않았지만 로직에 문제 있음
						alert("삭제하는데 실패했습니다. 다시 시도해주세요.");
					}
				}
				, error:function(request, status, error) { 	// ajax 자체가 실패, 서버 오류
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
		
		
	});
</script>
</body>
</html>