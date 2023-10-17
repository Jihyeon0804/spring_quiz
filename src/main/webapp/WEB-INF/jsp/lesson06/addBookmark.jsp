<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 추가 화면</title>
	<!-- bootstrap CDN link -->
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 	<!--  AJAX를 사용하려면 반드시 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap" class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div>
			<label for="name">제목</label>
			<input type="text" id="name" name="name" class="form-control">
		</div>
		<div class="my-4">
			<label for="url">주소</label>
			<div class="d-flex">
				<input type="text" id="url" name="url" class="form-control">
				<button type="button" id="isDuplicationBtn" class="btn btn-info ml-3">중복확인</button>
			</div>
			<small id="urlStatusArea"></small>
		</div>
		<input type="button" id="joinBtn" class="btn btn-success w-100" value="추가">
	</div>
</body>

<script>
	$(document).ready(function() {
		$('#joinBtn').on('click', function() {
			// alert("클릭");
			
			// validation check
			let name = $('#name').val().trim();
			if (name == "") {	//  or if (!name)
				alert("사이트 제목을 입력해주세요.");
				return;
			}
			
			let url = $('#url').val().trim();
			if (url == "") {
				alert("사이트 주소를 입력해주세요.");
				return;
			}
			
			// http 또는 https 프로토콜까지 모두 입력되었는지 validation
			// http://도 아니고 https://도 아닐 때로 조건 잡을 것임
			
			if (url.startsWith("http://") == false && url.startsWith("https://") == false) {
				alert("주소 형식이 잘못되었습니다.");
				return;
			}
			
			// params 확인
			console.log(name);
			console.log(url);
			
			// AJAX 통신
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/quiz01/add-bookmark"
				, data:{"name":name, "url":url}
				
				
				// response
				, success:function(data) {	// data : response 응답값(JSON String) => Dictinary Object
					// data는 JSON String => Object 변환된 형태로 사용할 수 있음
					// jquery의 ajax 함수의 기능이기 때문에
					/* alert(data.code);
					alert(data.result); */
					if (data.code == 200) {	// or data.result == "success"
						location.href="/lesson06/quiz01/bookmark-list-view"
					}
				}
				
				, error:function(request, status, error) {
					alert("추가에 실패했습니다. 관리자에게 문의해주세요.");
					/* alert(request);
					alert(status);
					alert(error); */
				}
				
				
			});
		});
	});
</script>
</html>