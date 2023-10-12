<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="/css/weather_history/style.css">
</head>
<body>
	<div id="wrap" class="container">
		<div class="contents d-flex">
			<nav class="col-2">
				<div class="logo d-flex justify-content-center mt-3">
					<img src="/img/nav_logo.png" width="25"> <span
						class="text-white font-weight-bold ml-2">기상청</span>
				</div>
				<ul class="nav flex-column mt-4">
					<li class="nav-item"><a href="/weather_history/history-view"
						class="nav-link nav-font">날씨</a></li>
					<li class="nav-item"><a
						href="/weather_history/history-add-view" class="nav-link nav-font">날씨입력</a>
					</li>
					<li class="nav-item"><a href="/weather_history/history-view"
						class="nav-link nav-font">테마날씨</a></li>
					<li class="nav-item"><a href="/weather_history/history-view"
						class="nav-link nav-font">관측 날씨</a></li>
				</ul>
			</nav>
			<section class="col-10 mt-3 ml-5">
				<h2>날씨 입력</h2>
				<form method="post" action="">
					<div class="d-flex justify-content-around align-items-around">
						<div class="d-flex">
							<div class="mr-2">날짜</div>
							<input type="text" class="form-control" id="datepicker">
						</div>
						<div class="d-flex">
							<div class="mr-2">날씨</div>
							<select class="form-control">
								<option>맑음</option>
								<option>비</option>
								<option>구름조금</option>
								<option>흐림</option>
							</select>
						</div>
						<div class="d-flex">
							<div>미세먼지</div>
							<select class="form-control">
								<option>좋음</option>
								<option>보통</option>
								<option>나쁨</option>
								<option>최악</option>
							</select>
						</div>
					</div>
					<div class="d-flex justify-content-around">
						<div class="d-flex">
							<div>기온</div>
							<div class="input-group">
								<input type="text" class="form-control">
								<div class="input-group-append">
									<span class="input-group-text">℃</span>
								</div>
							</div>
						</div>
						<div class="d-flex">
							<div>강수량</div>
							<div class="input-group">
								<input type="text" class="form-control">
								<div class="input-group-append">
									<span class="input-group-text">mm</span>
								</div>
							</div>
						</div>
						<div class="d-flex">
							<div class="">풍속</div>
							<div class="input-group">
								<input type="text" class="form-control">
								<div class="input-group-append">
									<span class="input-group-text">km/h</span>
								</div>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-success d-flex justify-content-end">저장</button>
				</form>
			</section>
		</div>
		<footer class="d-flex align-items-center">
			<div class="footer-logo ml-4">
				<img src="/img/foot_logo.png" width="120">
			</div>
			<div class="ml-4">
				<small class="text-secondary"> (07062) 서울시 동작구 여의대방로16길61<br>
					Copyright@2020 KMA. All Rights RESERVED.
				</small>
			</div>
		</footer>
	</div>
</body>
</html>