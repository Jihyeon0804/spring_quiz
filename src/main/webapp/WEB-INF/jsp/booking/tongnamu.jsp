<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<!-- bootstrap CDN link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!--  AJAX를 사용하려면 반드시 jquery 원본 필요 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- 내가 만든 스타일 시트 -->
<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 펜션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item">
					<a href="#" class="nav-link text-white font-weight-bold">팬션소개</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link text-white font-weight-bold">객실보기</a>
				</li>
				<li class="nav-item">
					<a href="/booking/reserve-view" class="nav-link text-white font-weight-bold">예약하기</a>
				</li>
				<li class="nav-item">
					<a href="/booking/reserve-list-view" class="nav-link text-white font-weight-bold">예약목록</a>
				</li>
			</ul>
		</nav>
		<section class="banner">
			<img src="/img/booking/banner1.jpg" alt="banner" width="1110" height="500">
		</section>
		<section class="reserve d-flex">
			<section class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
			    <div class="display-4 text-white">실시간<br>예약하기</div>
			</section>
			<section class="confirm col-4">
			    <div class="m-3">
			        <span class="reserve-confirm mr-3">예약 확인</span>
			    </div>

			    <!-- 예약 확인 -->
			    <div id="memberInputBox" class="m-2">
			        <div class="d-flex justify-content-end mr-3">
			            <span class="text-white">이름:</span>
			            <input type="text" id="name" class="form-control input-form">
			        </div>
			        <div class="d-flex mt-2 justify-content-end mr-3">
			            <span class="text-white">전화번호:</span>
			            <input type="text" id="phoneNumber" class="form-control input-form">
			        </div>

			        <!-- 버튼 -->
			        <div class="text-right mt-3 mr-3">
			            <button type="button" class="submit-btn btn btn-success">조회 하기</button>
			        </div>
			    </div>
			</section>
			<section class="inquiry col-4 d-flex justify-content-center align-items-center">
			    <div class="text-white">
			        <h4 class="font-weight-bold">예약문의:</h4>
			        <h1>010-<br>0000-1111</h1>
			    </div>
			</section>
		</section>
		<footer class="d-flex align-items-center pl-3">
			<div class="address">
				제주특별자치도 제주시 애월읍<br> 사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 /
				대표:김통목<br> Copyright 2025 tongnamu. All right reserved.
			</div>
		</footer>
	</div>

<script>
$(document).ready(function() {
	
	// 조회하기 버튼 클릭 시
	$('.submit-btn').on('click', function() {
		// alert('조회하기');
		
		let name = $('#name').val().trim();
		let phoneNumber = $('#phoneNumber').val().trim();
		
		// param 확인
		/* console.log(name);
		console.log(phoneNumber); */
		
		// validation check
		if (!name) {
			alert("이름을 입력해주세요.");
			return;
		}
		
		if (!phoneNumber) {
			alert("전화번호를 입력해주세요.");
			return;
		}
		
		if (phoneNumber.startsWith('010') == false) {
			alert("올바른 전화번호 형식이 아닙니다.\n다시입력해주세요.");
			return;
		}
		
		$.ajax({
			
			// request
			type:"post"
			, url:"/booking/search-reserve"
			, data:{"name":name, "phoneNumber":phoneNumber}
			
			
			// response
			, success:function(data) {
				// {"code":200, "result":"success", "existBooking" : existBooking}
				if (data.existBooking != null) {
					alert("이름 : " + data.existBooking.name
							+ "\n 날짜 : " + data.existBooking.date
							+ "\n 일수 : " + data.existBooking.day
							+ "\n 인원 : " + data.existBooking.headcount
							+ "\n 상태 : " + data.existBooking.state);
				} else {
					alert("예약 내역이 없습니다.");
				}
			}
			, error:function(request, status, error) {
				alert("조회 실패");
			}
		});
		
	});
});

</script>
</body>
</html>