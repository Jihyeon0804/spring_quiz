<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2) - 2</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>멤버십</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>등급</th>
					<th>포인트</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${membership}" var="memberships" varStatus="status">
				<%-- 등급이 VIP인경우 글씨를 빨간색으로, 등급이 GOLD인경우 노란색으로 표시하세요.
					포인트가 5000점 이상이면 포인트를 파란색으로 표시하세요. --%>
				<tr>
					<td>${memberships.get('name')}</td>
					<td>${memberships.get('phoneNumber')}</td>
					<c:choose>
					<c:when test="${memberships.get('grade') == 'VIP'}">
					<td class="text-danger">${memberships.get('grade')}</td>
					</c:when>
					<c:when test="${memberships.get('grade') == 'GOLD'}">
					<td class="text-warning">${memberships.get('grade')}</td>
					</c:when>
					<c:otherwise>
					<td>${memberships.get('grade')}</td>
					</c:otherwise>
					</c:choose>
					
					<c:choose>
					<c:when test="${memberships.get('point') >= 5000}">
					<td class="text-primary">${memberships.get('point')}P</td>
					</c:when>
					<c:otherwise>
					<td>${memberships.get('point')}P</td>
					</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>