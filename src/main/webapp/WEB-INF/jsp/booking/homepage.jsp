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
		<header
			class="bg-light d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 팬션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">팬션소개</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="banner bg-info">
			<img src="/img/booking/banner1.jpg" alt="banner" width="100%">
		</section>
		<section class="reserve bg-primary d-flex">
			<section
				class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
				<div class="display-4 text-white">
					실시간<br>예약하기
				</div>
			</section>
			<section class="confirm col-4">
				<!-- 예약 확인, 회원 비회원 라디오 버튼 -->
				<div class="m-3">
					<span class="reserve-confirm mr-3">예약 확인</span> <label for="member"
						class="mr-3"> <span class="text-white">회원</span> <input
						type="radio" id="member" name="member" value="member"
						checked="checked">
					</label> <label for="nonMember"> <span class="text-white">비회원</span>
						<input type="radio" id="nonMember" name="member" value="nonMember">
					</label>
				</div>

				<!-- 아이디 비밀번호(회원용) -->
				<div id="memberInputBox">
					<div class="d-flex justify-content-end align-items-center mr-4">
						<div class="subject">아이디</div>
						<input type="text" id="id" class="form-control input-form">
					</div>
					<div
						class="d-flex mt-2 justify-content-end align-items-center mr-4">
						<span class="subject">비밀번호</span> <input type="password"
							id="password" class="form-control input-form">
					</div>

					<!-- 버튼 -->
					<div
						class="d-flex mt-2 justify-content-end align-items-center mr-4 mt-3">
						<button type="button" class="btn btn-success submit-btn">조회
							하기</button>
					</div>
				</div>

				<!-- 아이디 비밀번호(비회원용)-->
				<div id="nonMemberInputBox">
					<div class="d-flex justify-content-end mr-4">
						<span class="subject">이름</span> <input type="text" id="name"
							class="form-control input-form">
					</div>
					<div class="d-flex mt-2 justify-content-end mr-4">
						<span class="subject">전화번호</span> <input type="text"
							id="phoneNumber" class="form-control input-form">
					</div>
					<div class="d-flex mt-2 justify-content-end mr-4">
						<span class="subject">날짜</span> <input type="text"
							id="reserveDateText" class="form-control input-form">
					</div>

					<!-- 버튼 -->
					<div class="text-right mt-2 mr-4">
						<button type="button" class="btn btn-success submit-btn">조회
							하기</button>
					</div>
				</div>
			</section>
			<section
				class="inquiry col-4 d-flex justify-content-center align-items-center">
				<div class="text-white">
					<h4 class="font-weight-bold">예약문의:</h4>
					<h1>
						010-<br>0000-1111
					</h1>
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
		$(document).ready(
				function() {
					// 2-1. 회원/비회원 선택시 인풋폼 내용 바뀌도록 설정
					$('input[name=member]').change(function() {
						//alert($(this).val());
						var radioValue = $(this).val();
						if (radioValue == 'member') {
							$('#memberInputBox').removeClass("d-none");
							$('#nonMemberInputBox').addClass("d-none");
						} else {
							$('#nonMemberInputBox').removeClass("d-none");
							$('#memberInputBox').addClass("d-none");
						}
					});

					// 2-2. 날짜 영역 datePicker로 선택하기
					

					// 3. 조회하기 버튼 클릭
					$('.submit-btn').on(
							'click',
							function(e) {
								e.preventDefault();

								var memberRadioValue = $(
										'input:radio[name=member]:checked')
										.val(); // 라디오 버튼 중 선택된 value
								console.log(memberRadioValue); // member or nonMember

								if (memberRadioValue == 'member') {
									// 회원 validation
									if ($('#id').val().trim() == '') {
										alert("아이디를 입력하세요");
										return;
									}

									if ($('#password').val() == '') {
										alert("비밀번호를 입력하세요");
										return;
									}
								} else {
									// 비회원 validation
									if ($('#name').val().trim() == '') {
										alert("이름을 입력하세요");
										return;
									}

									if ($('#phoneNumber').val().trim() == '') {
										alert("전화번호를 입력하세요");
										return;
									}

									if ($('#reserveDateText').val() == '') {
										alert("날짜를 선택해주세요");
										return;
									}

									// 전화번호가 010으로 시작하는지 확인
									//-- 첫번째 방법
									//var frontNumber = $('#phoneNumber').val().slice(0, 3);
									//alert(frontNumber);
									// if (frontNumber != '010') {
									//     alert("010으로 시작하는 번호만 입력 가능합니다.");
									//     return;
									// }

									//-- 두번째 방법
									if ($('#phoneNumber').val().startsWith(
											'010') === false) {
										alert("010으로 시작하는 번호만 입력 가능합니다.");
										return;
									}
								}
							});

					// 4. 이미지 3초 간격으로 변경하기


				});
	</script>
</body>
</html>