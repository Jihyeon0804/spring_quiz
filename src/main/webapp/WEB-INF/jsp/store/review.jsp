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
			<div class="title ml-4">배탈의 민족</div>
		</header>
		<section class="review">
			<div class="sec-title mt-2">${storeName} - 리뷰</div>
			
			<%-- 리뷰 없는 경우 --%>
			<c:if test="${empty reviewList}">
				<div class="non-review mt-5 ml-5 d-flex align-items-center">작성된 리뷰가 없습니다.</div>
			</c:if>
			
			<%-- 리뷰 있는 경우 --%>
			<c:forEach items="${reviewList}" var="review">
				<div class="store my-4 p-4">
					<div class="d-flex">
						<div class="storeName">${review.userName}</div>
						
						<%-- 별점 --%>
						<div class="point d-flex align-items-center ml-2">
							<%-- 소수점 제외 구하기(pointQuot) --%>
							<fmt:parseNumber value="${review.point}" var="pointQuot" integerOnly="true"/>
							
							<%-- 소수점 제외 부분 만큼 꽉 찬 별 반복 --%>
							<c:forEach begin="1" end="${pointQuot}" step="1">
								<img src="/img/star_fill.png" width="30">
							</c:forEach>
							
							<%-- 별점 5 제외 (추가로 채워줄 부분 없으므로) 빈 별, 반쪽 별 --%>
							<c:if test="${pointQuot != 5}">
							
								<%-- 빈 별 개수(pointRemain) --%>
								<fmt:parseNumber value="${5 - review.point}" var="pointRemain" integerOnly="true"/>
								
								<%-- 0.5가 있는 경우 --%>
								<c:if test="${review.point - pointQuot != 0}">
									<img src="/img/star_half.png" width="30">
								</c:if>
								
								<%-- 빈 별의 개수 만큼 반복 --%>
								<c:forEach begin="1" end="${pointRemain}" step="1">
									<img src="/img/star_empty.png" width="30">
								</c:forEach>
							</c:if>
						</div>
					</div>
					
					<%-- 리뷰 날짜 --%>
					<div class="review-date">
						<fmt:formatDate value="${review.updatedAt}" pattern="yyyy년 M월 d일"/>
					</div>
					
					<%-- 리뷰 내용 --%>
					<div class="review-contents mt-4">${review.review}</div>
					
					<%-- 주문 메뉴 --%>
					<div class="mt-3"><span class="review-menu p-2">${review.menu}</span></div>
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