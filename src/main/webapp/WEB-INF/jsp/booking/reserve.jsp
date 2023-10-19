<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
	<!-- bootstrap CDN link -->
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 	
 	<!--  AJAX를 사용하려면 반드시 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<%-- datepicker --%>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
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
		<section>
			<div class="my-3 d-flex justify-content-center align-items-center">
				<h2>예약하기</h2>
			</div>
			<div class="reserve-contents d-flex justify-content-center align-items-center">
				<div class="col-6">
					<div>
						<label for="name">이름</label>
						<input type="text" class="form-control" id="name" name="name">
						<small><span id="checkName" class="text-danger d-none">이름을 입력해주세요.</span></small>
					</div>
					<!-- 예약 날짜 - datepicker -->
					<div class="mt-2">
						<label for="date">예약날짜</label>
						<input type="text" class="form-control" id="date" name="date">
						<small><span id="checkDate" class="text-danger d-none">날짜를 선택해주세요.</span></small>
					</div>
					<div class="mt-2">
						<label for="day">숙박일수</label>
						<input type="text" class="form-control" id="day" name="day">
						<small><span id="checkDay" class="text-danger d-none">숙박일수를 입력해주세요.</span></small>
						<small><span id="notAvailableDay" class="text-danger d-none">올바른 형식이 아닙니다.</span></small>
					</div>
					<div class="mt-2">
						<label for="headcount">숙박인원</label>
						<input type="text" class="form-control" id="headcount" name="headcount">
						<small><span id="checkHeadCount" class="text-danger d-none">숙박인원을 입력해주세요.</span></small>
						<small><span id="notAvailableHeadCount" class=" text-danger d-none">올바른 형식이 아닙니다.</span></small>
					</div>
					<div class="mt-2">
						<label for="phoneNumber">전화번호</label>
						<input class="form-control" id="phoneNumber" name="phoneNumber">
						<small><span id="checkPhoneNumber" class="checkPhoneNumber text-danger d-none">전화번호를 입력해주세요.</span></small>
						<small><span id="notAvailablePhoneNumber"  class="notAvailablePhoneNumber text-danger d-none">올바른 전화번호 형식이 아닙니다.</span></small>
					</div>
					<button type="button" id="reserve-btn" class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>
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
			
			// 예약 날짜 선택(datepicker)
			$("#date").datepicker({
	            dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
	            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
	            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	            dateFormat: "yy-mm-dd",
	            minDate: 0	// 오늘 날짜부터 선택
			});
			
			
			// 예약하기 버튼 클릭 시
			$('#reserve-btn').on('click', function() {
				// alert("예약");
				
				// name, date, day, headcount, phoneNumber
				let name = $('#name').val().trim();
				let date = $('#date').val();
				let day = $('#day').val().trim();
				let headcount = $('#headcount').val().trim();
				let phoneNumber = $('#phoneNumber').val().trim();
				
				// validation check
				// name
				if (!name) {
					$('#checkName').removeClass('d-none')
					return;
					
				} else {
					$('#checkName').addClass('d-none')
				}
				
				// date
				if (!date) {
					$('#checkDate').removeClass('d-none')
					return;
				} else {
					$('#checkDate').addClass('d-none')
				}
				
				// day
				if (!day) {
					$('#checkDay').removeClass('d-none')
					return;
				} else {
					$('#checkDay').addClass('d-none')
				}
				
				
				
				// headcount
				if (!headcount) {
					$('#checkHeadCount').removeClass('d-none')
					return;
				} else {
					$('#checkHeadCount').addClass('d-none')
				}
				
				
				
				// phoneNumber
				if (!phoneNumber) {
					$('#checkPhoneNumber').removeClass('d-none')
					return;
				} else {
					$('#checkPhoneNumber').addClass('d-none')
				}
				

				if (phoneNumber.startsWith('010') == false) {
					$('#notAvailablePhoneNumber').removeClass('d-none')
				} else {
					$('#notAvailablePhoneNumber').addClass('d-none')
				}
				
				/* if (Number.isInteger(parseInt(day)) && parseInt(day) > 0) {
					$('#notAvailableDay').addClass('d-none')
					return;
				} else {
					$('#notAvailableDay').removeClass('d-none')
					$('#checkDay').addClass('d-none')
				}
				
				if (Number.isInteger(parseInt(headcount)) && parseInt(headcount) > 0) {
					$('#notAvailableHeadCount').addClass('d-none')
					$('#checkHeadCount').addClass('d-none')
					return;
				} else {
					$('#notAvailableHeadCount').removeClass('d-none')
					$('#checkHeadCount').addClass('d-none')
				} */
				
				
				$.ajax({
					// request
					// name, date, day, headcount, phoneNumber
					type:"post"
					, url:"/booking/add-reserve"
					,data:{"name":name, "date":date, "day":day,
						"headcount":headcount, "phoneNumber":phoneNumber}
					
					// response
					, success:function(data) {
						if (data.code == 200) {
							alert("예약되었습니다.");
							location.href="/booking/reserve-list-view"
						} else {
							alert("예약하는데 실패했습니다. 다시 시도해주세요.");
						}
					}
					,error:function(request,status, error) {
						alert("예약하는데 실패했습니다. 관리자에게 문의해주세요.");
					}
					
				});
			});
		});
	</script>
</body>
</html>