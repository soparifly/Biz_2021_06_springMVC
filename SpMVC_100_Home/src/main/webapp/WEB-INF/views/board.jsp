<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/7f8ef4d19e.js"
	crossorigin="anonymous"></script>
</head>
<body>
<link href="${rootPath}/static/css/board.css?ver=2021-06-12-001"
		rel="stylesheet" />
	<h2>자유게시판</h2>
	<hr></hr>
	<div class="ser_title">
		<i class="fas fa-search"></i> <input id="search" type="text"
			placeholder="키워드를 입력하세요" />
		<button id="sear_click">검색</button>
	</div>
	<div>
		<table>
			<tr class="table">
				<th id="no">번호</th>
				<th id="title">제목</th>
				<th id="avo">추천수</th>
				<th id="au">작성자</th>
				<th id="date">작성일</th>
				<th id="time">작성시간</th>
			</tr>
			<tr class="value">
				<td id="no">1</td>
				<td id="title">1</td>
				<td id="avo">0</td>
				<td id="au">아무개</td>
				<td id="date">2021-06-11</td>
				<td id="time">14:40:23</td>
			</tr>
		</table>
	</div>
	<div class="btn_writ">
		<button id="write" type="button" onclick="location.href='input'">글쓰기</button>
	</div>
</body>
</html>