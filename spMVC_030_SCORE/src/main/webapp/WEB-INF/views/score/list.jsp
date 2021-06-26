<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<table class="score_list detail">
	<tr>
		<td>학생이름</td>
		<td>학번</td>
		<td>과목이름</td>
		<td>과목코드</td>
		<td>점수</td>
	</tr>
	<c:choose>
		<c:when test="${empty SCORES}">
			<tr>
				<td colspan="5">데이터가 없음</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${SCORES}" var="SCORE">
				<tr data-st_num="${SCORE.sc_stnum}">
					<td>${SCORE.sc_stname}</td>
					<td>${SCORE.sc_stnum}</td>
					<td>${SCORE.sc_sbname}</td>
					<td>${SCORE.sc_sbcode}</td>
					<td class="number">${SCORE.sc_score}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div class="btn_box">
	<button class="score insert">성적등록</button>
	<button class="score student list">학생정보 바로가기</button>
</div>
<script>

</script>