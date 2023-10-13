<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 리뷰</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/store/style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex align-items-center">
			<div class="title">배탈의 민족</div>
		</header>
		<section>
			<div class="sec-title mt-2">우리동네 가게</div>
			<c:forEach items="${storeList}" var="store">
				<div Onclick="location.href='/store/review?storeId=${store.id}&storeName=${store.name}'" class="store my-4 p-4">
					<h3>${store.name}</h3>
					<div>
						전화번호: ${store.phoneNumber}<br>
						주소:  ${store.address}
					</div>
				</div>
			</c:forEach>
		</section>
		<hr>
		<footer>
			<div class="foot-cp">(주)우와한형제</div>
			<div class="phoneNumber text-secondary">고객센터 : 1500-1500</div>
		</footer>
	</div>
</body>
</html>