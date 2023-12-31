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
				<button type="button" id="urlCheckBtn" class="btn btn-info ml-3">중복확인</button>
			</div>
			<small id="duplicatedText" class="text-danger d-none">중복된 url 입니다.</small>
			<small id="availableText" class="text-success d-none">저장 가능한 url 입니다.</small>
		</div>
		<input type="button" id="joinBtn" class="btn btn-success w-100" value="추가">
	</div>
</body>

<script>
	$(document).ready(function() {
		// Quiz2) 중복확인 버튼 클릭
		$('#urlCheckBtn').on('click', function() {
			// alert("클릭");
			let url = $('#url').val().trim();
			if (!url) {
				alert("검사할 url을 입력하세요.");
				return;
			}
			
			// DB에서 URL 중복 확인 - AJAX 통신
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/quiz02/is-duplicated-url"
				, data:{"url":url}
				
				// response
				, success:function(data) {	// data JSON => dictionary
					// {"code":200, "is_duplication":true} true:중복
					if (data.is_duplication) {
						// 중복 : id가 duplicatedText인 태그의 d-none class 제거
						$('#duplicatedText').removeClass('d-none');
						$('#availableText').addClass('d-none');
					} else {
						// 중복 아님
						$('#duplicatedText').addClass('d-none');
						$('#availableText').removeClass('d-none');
					}
				}
				, error:function(request, status, error) {
					alert("중복확인에 실패했습니다.");
				}
				
			});
		});
		
		// 중복 확인 버튼 클릭 시
		/* $('#isDuplicationBtn').on('click', function() {
			// alert("중복 확인");
			let url = $('#url').val().trim();
			// small 태그 안쪽 비우고 시작
			// 경고문 한 번만 보이도록 하기 위해
			$('#urlStatusArea').empty();
			
			// 주소 입력 안한 경우
			if (url == "") {
				$('#urlStatusArea').append('<span class="text-danger">주소를 입력해주세요.</span>');
				return;
			}
			
			$.ajax({
				// request
				type:"get"
				, url:"/lesson06/quiz01/is-duplication"
				, data:{"url":url}
				
				
				// response
				, success:function(data) {
					
					if(data.is_duplication) {	// 중복일 떄
						$('#urlStatusArea').append('<span class="text-danger">중복된 url입니다.</span>')
					} else {
						$('#urlStatusArea').append('<span class="text-danger" id="available">저장 가능한 url입니다.</span>')
					}
				}
				, error:function(request, status, error) {
					alert("중복 확인에 실패했습니다.")
				}
				
			});

		}); */
		// 추가 버튼 누를 때
		$('#joinBtn').on('click', function() {
			// alert("클릭");
			
			// validation check
			let name = $('#name').val().trim();
			let url = $('#url').val().trim();
			
			if (name == "") {	//  or if (!name)
				alert("사이트 제목을 입력해주세요.");
				return;
			}
			
			
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
			
			
			/* if ($('#urlStatusArea').children().length == 0) {
				alert("중복 확인을 해주세요.");
				return;
			} */
			
			// params 확인
			console.log(name);
			console.log(url);
			
			// Quiz02) 저장 가능한 URL일 때 추가 가능
			// availableText d-none 있으면 가입 불가
			if ($('#availableText').hasClass('d-none')) {
				alert("URL 중복확인을 다시 해주세요.");
				return;
			}
			
			
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